import com.adobe.editor.cfml.parser.generated.CFParse;

void main(String[]args) {

    String pathName;

    if (args.length > 0) {
        pathName = args[0];
    } else {
        pathName = ".";
    }

    CFParse.init();

    CFParse.parseFileOrDir(pathName);
}
