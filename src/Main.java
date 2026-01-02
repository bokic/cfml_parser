void main(String[]args) {

    String pathName;

    if (args.length > 0) {
        pathName = args[0];
    } else {
        pathName = ".";
    }

    com.adobe.editor.cfml.parser.generated.CFParse.parseFileOrDir(pathName);
}
