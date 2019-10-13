package mastermind.views.console.menu;

import mastermind.controllers.StartController;
import santaTecla.utils.Console;
import santaTecla.utils.Menu;

class GameSelectedMenu extends Menu {

    public GameSelectedMenu(StartController startController) {
        String[] gamesNames = startController.getGamesNames();
        for (String title : gamesNames)
            this.addCommand(new GameSelectedCommand(title, startController));
    }
    
    
    
    

   
    
}
