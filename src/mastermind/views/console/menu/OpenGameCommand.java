package mastermind.views.console.menu;

import mastermind.controllers.StartController;

class OpenGameCommand extends Command{
    
    protected  OpenGameCommand(StartController startController){
        super(CommandTitle.OPENFGAME_COMMAND.getTitle(),startController);
    }

    @Override
    protected void execute() {
        new GameSelectedMenu((StartController) this.acceptorController).execute();
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}
