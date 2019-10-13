package mastermind.views.console.menu;

import mastermind.controllers.StartController;

class NewGameCommand extends Command{
    
    public NewGameCommand(StartController startController){
        super(CommandTitle.NEWGAME_COMMAND.getTitle(),startController);
    }

    @Override
    protected void execute() {
        ((StartController) this.acceptorController).start(title);
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}
