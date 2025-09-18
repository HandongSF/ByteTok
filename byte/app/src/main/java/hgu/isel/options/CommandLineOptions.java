package hgu.isel.options;

import org.apache.commons.cli.*;

public class CommandLineOptions {
    private final Options options;

    public CommandLineOptions() {
        options = new Options();


        Option vocab = Option.builder("v")
                .longOpt("vocab")
                .hasArgs()
                .desc("create vocabulary with input path and max length")
                .build();


        Option tokenize = Option.builder("a")
                .longOpt("analyze")
                .hasArgs()
                .desc("analyze input class file")
                .build();

        Option remove = Option.builder("r")
                .longOpt("remove")
                .hasArgs()
                .desc("remove scala / kotlin files which include customized attributes from input directory path")
                .build();

        Option generate = Option.builder("g")
                .longOpt("generate")
                .hasArgs()
                .desc("generate new text files as inputs of pre-trained model")
                .build();

        Option delete = Option.builder("d")
                .longOpt("delete")
                .hasArgs()
                .desc("delete files which have large constant pool")
                .build();

        Option find = Option.builder("f")
                .longOpt("find")
                .hasArgs()
                .desc("find all customized attributes in scala / kotlin class files")
                .build();

        Option extract = Option.builder("e")
                .longOpt("extract")
                .hasArgs()
                .desc("extract all methods from the input path")
                .build();

        Option search = Option.builder("s")
                .longOpt("search")
                .hasArgs()
                .desc("search specific method with input string")
                .build();

        options.addOption(vocab);
        options.addOption(tokenize);
        options.addOption(remove);
        options.addOption(generate);
        options.addOption(delete);
        options.addOption(find);
        options.addOption(extract);
        options.addOption(search);

    }

    public CommandLine parse(String[] args) throws ParseException {
        CommandLineParser parser = new DefaultParser();
        return parser.parse(options, args);
    }

    public void printHelp() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("java -jar app.jar", options, true);
    }

}
