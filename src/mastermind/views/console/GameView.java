package mastermind.views.console;

import mastermind.controllers.Controller;

public class GameView {
    
    private final Controller controller;
    private SecretCombinationView secretCombinationView;
    
    public GameView(Controller controller){
        this.controller = controller;
    }
    
    public void writeln(){
        MessageView.TITLE.writeln();
        this.secretCombinationView = new SecretCombinationView(controller);
        this.secretCombinationView.writeln();
    }
}
