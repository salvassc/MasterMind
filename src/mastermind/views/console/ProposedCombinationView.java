package mastermind.views.console;

import mastermind.controllers.Controller;

public class ProposedCombinationView extends CombinationView {
    
    public ProposedCombinationView(Controller controller) {
        super(controller);
        
    }

    public void read() {
        this.controller.read();
    }
}
