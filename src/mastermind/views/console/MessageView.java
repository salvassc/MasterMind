package mastermind.views.console;

import utils.Console;

public enum MessageView {
    ATTEMPTS("#attempts attempt(s): "), 
    SECRET("*"), 
    RESUME("Do you want to continue"), 
    RESULT(" --> #blacks blacks and #whites whites"), 
    PROPOSED_COMBINATION("Propose a combination: "), 
    TITLE("----- MASTERMIND -----"), 
    WINNER("You've won!!! ;-)"), 
    LOOSER("You've lost!!! :-("),
    NEW_LINE("\n");

    private String message;
    static private Console console; 
    
    static {
        MessageView.console = new Console();
    }

    private MessageView(String message) {
       this.message = message;
    }

    public void write() {
        MessageView.console.write(this.message);
    }

    public void writeln() {
        MessageView.console.writeln(this.message);
    }

    public void writeln(int attempts) {
        MessageView.console.writeln(this.message.replaceAll("#attempts", "" + attempts));
    }

    public void writeln(int blacks, int whites) {
        MessageView.console.writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }
    
    public String getMessage() {
        return this.message;
    }
}
