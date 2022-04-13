package space.mxthys;

public class Main {
    public static void main(String[] args) {

        boolean isCommand = false;
        String arg;
        String command = null;
        String content = null;

        if(args.length == 0) {
            help("Please use a argument", true);
        }

        for (int i = 0; i < args.length; i++) {
            arg = args[i];
            if(isCommand) {
                isCommand = false;
                continue;
            }
            while(arg.substring(0,1).contains("-")) {
                arg = arg.substring(1);
                command = arg;
                isCommand = true;
            }

            if(!isCommand) continue;

            if(args.length <= i + 1) {
                isCommand = false;
            }
            else content = args[i + 1];

            // Add any arguments here
            if(command.equals("help") || command.equals("h")) {
                // Stop the programm
                help(true);
            }
            else if (command.equals("customlog")) {
                if(content == null) help("Please enter a valid log", true);
                System.out.println();
                System.out.println(content);
                System.out.println();
            }
            else if (command.equals("log")) {
                System.out.println();
                System.out.println("This is a test log");
                System.out.println();

                // Put this if a argument doesn't need user input
                isCommand = false;
            }
            else {
                help("Unknown arguments : --" + command, true);
            }
        }
        System.exit(0);
    }

    static void help() {
        help("{{nothing}}", false);
    }

    static void help(boolean exit) {
        help("{{nothing}}", exit);
    }

    static void help(String additionalMessage) {
        help(additionalMessage, false);
    }

    static void help(String additionalMessage, Boolean exit) {
        System.out.println();
        if(!additionalMessage.contains("{{nothing}}")) {
            System.out.println(additionalMessage);
            System.out.println();
        }
        System.out.println("This is a code base for a command line script");
        System.out.println();
        System.out.println("Arguments :");
        System.out.println(" --help : Return help about the command");
        System.out.println(" --log : Logs out a test log");
        System.out.println(" --customlog : Logs out a custom log");
        System.out.println();
        if(exit) System.exit(0);
    }
}

