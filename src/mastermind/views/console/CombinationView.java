package mastermind.views.console;

import mastermind.controllers.Controller;

public abstract class CombinationView {
    
    protected final Controller controller;
    
    public CombinationView(Controller controller){
        this.controller = controller;
    }
}
