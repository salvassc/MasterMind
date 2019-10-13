package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import santaTecla.utils.Console;

class GameSelectedCommand extends Command{
    
    public GameSelectedCommand(String title, StartController startController){
        super(title, startController);
    }

    @Override
    protected void execute() {
        new Console().writeln(title);
        ((StartController) this.acceptorController).start(title);
    }

    @Override
    public boolean isActive() {
        return true;
    }
    
}
