package com.adobe.editor.cfml.parser.generated;

import com.adobe.coldfusion.ls.CFMLParserManager;
import com.adobe.editor.cfml.preferences.PreferencesManager;
import com.adobe.editor.cfml.util.BOMUtil;
import com.adobe.ide.coldfusion.dictionary.DictionaryManager;
import org.eclipse.lsp4j.jsonrpc.validation.NonNull;

import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static com.adobe.editor.cfml.parser.generated.CFMLParserConstants.FORMAL_COMMENT;

public class CFFormat {

    static {
        String profileLocation = System.getenv("CFML_PARSER_PROFILE_LOCATION");

        DictionaryManager.initDictionaries();
        PreferencesManager.getInstance();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.name", "default");
        prefs.put("profile.location", Objects.requireNonNullElse(profileLocation, "."));
        PreferencesManager.setActivePreferences(prefs);
    }

    static private void fill(@NonNull byte[] out, int start, int end, byte format) {
        Arrays.fill(out, start, end, format);
    }

    static public byte[] format(@NonNull byte[] src) throws IOException {
        byte[] ret = new byte[src.length];

        CFMLParser parser;

        ByteArrayInputStream inStream = new ByteArrayInputStream(src);
        Reader reader = BOMUtil.createReader(inStream);
        ASCII_CharStream charStream = new ASCII_CharStream(reader);
        parser = CFMLParserManager.INSTANCE.getParser(charStream);
        parser.init();

        var index = parser.getIndex();

        HashSet<Token> tokens;

        try {
            Field field = CFIndex.class.getDeclaredField("tokens");
            field.setAccessible(true);
            tokens = (HashSet<Token>)field.get(index);
        } catch (NoSuchFieldException | IllegalAccessException _) {
            return ret;
        }

        if (tokens == null) {
            return ret;
        }

        for(var token: tokens) {
            int start = token.getActualStartColumnOffset();
            int end = token.getActualEndColumnOffset();

            if (token.kind == 0) {
                fill(ret, start, end + 1, (byte) FORMAL_COMMENT);
            } else {
                fill(ret, start, end + 1, (byte) token.kind);
            }
        }

        CFMLParserManager.INSTANCE.returnParser(parser);

        return ret;
    }

    static public byte[] format(String pathName) throws IOException {

        byte[] content;
        try {
            content = Files.readAllBytes(Paths.get(pathName));
        } catch (IOException e) {
            return null;
        }

        return format(content);
    }

    static public void formatFileOrDir(String pathName) {
        File isDir = new File(pathName);

        if (isDir.isDirectory()) {
            var files = isDir.listFiles();
            if (files != null) {
                for (var file : files) {
                    formatFileOrDir(file.getAbsolutePath());
                }
            }
        } else {
            try {
                System.out.print("Parsing " + pathName);
                var format = format(pathName);
                System.out.println(" done.");

                if (format != null) {
                    String jsonPathName = pathName + ".parsed";
                    Files.write(Paths.get(jsonPathName), format);
                }
            } catch (IOException e) {
                System.err.println("Error parsing " + pathName + ". Error" + e.getMessage());
            }
        }
    }
}
