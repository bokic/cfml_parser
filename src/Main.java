import com.adobe.coldfusion.ls.log.CFLogManager;
import com.adobe.editor.cfml.parser.generated.CFFormat;
import com.adobe.editor.cfml.parser.generated.CFParse;


private void usage()
{
    System.out.println("Usage:\ncfml_parser -dir <some_dir> [--write_json|--write_formatting]\ncfml_parser <file.cfm|file.cfc> [--print_formatting]");
    System.exit(1);
}

void main(String[]args) {

    CFLogManager.init("");

    if (args.length == 0) {
        usage();
    }

    if (Objects.equals(args[0], "-dir")) {
        if ((args.length < 2)||(args.length >= 4)) {
            usage();
        }

        String pathName = args[1];
        boolean writeJsonFiles = false;

        if ((args.length == 3)&&(Objects.equals(args[2], "--write_formatting"))) {
            CFFormat.formatFileOrDir(pathName);
            return;
        }

        if (args.length == 3) {
            if (!Objects.equals(args[2], "--write_json")) {
                usage();
            }

            writeJsonFiles = true;
        }

        CFParse.parseFileOrDir(pathName, writeJsonFiles);
    } else {
        if (args.length > 2) {
            usage();
        }

        boolean print_formatting = false;

        if (args.length == 2) {
            if (!Objects.equals(args[1], "--print_formatting")) {
                usage();
            }

            print_formatting = true;
        }

        String filename = args[0];

        if (print_formatting) {
            byte[] format = null;
            try {
                format = CFFormat.format(filename);
                if (format != null) {
                    System.out.println(new String(format, StandardCharsets.ISO_8859_1));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            CFParse.parseFile(filename, false);
        }
    }
}
