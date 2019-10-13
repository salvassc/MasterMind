package mastermind.views.console.menu;

import mastermind.controllers.PlayController;

public class ExitCommand extends Command{
    
    public ExitCommand(PlayController playController){
        super(CommandTitle.EXIT_COMMAND.getTitle(),playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).next();
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}
