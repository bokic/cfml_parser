import com.adobe.editor.cfml.parser.generated.CFParse;


private void usage()
{
    System.out.println("Usage:\ncfml_parser -dir <some_dir> [--write_json]\ncfml_parser <file.cfm|file.cfc>");
    System.exit(1);
}

void main(String[]args) {

    if (args.length == 0) {
        usage();
    }

    if (Objects.equals(args[0], "-dir")) {
        if ((args.length < 2)||(args.length >= 4)) {
            usage();
        }

        String pathName = args[1];
        boolean writeJsonFiles = false;

        if (args.length == 3) {
            if (!Objects.equals(args[2], "--write_json")) {
                usage();
            }

            writeJsonFiles = true;
        }

        CFParse.parseFileOrDir(pathName, writeJsonFiles);
    } else {
        if (args.length != 1) {
            usage();
        }

        String filename = args[0];

        CFParse.parseFile(filename, false);
    }
}
