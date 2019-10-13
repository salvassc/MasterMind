package mastermind.views.console.menu;

public enum CommandTitle {
    
    PROPOSED_COMBINATION("Propose Combination"),
    UNDO_COMMAND("Undo previous Proposal"),
    REDO_COMMAND("Redo previous Proposal"),
    NEWGAME_COMMAND("Start a new game"),
    OPENFGAME_COMMAND("Open a new game"),
    EXIT_COMMAND("Exit game");
    
    private String title;

    private CommandTitle(String title) {
        this.title = title;
    }
    
    public String getTitle(){
        return this.title;
    }
    
}
