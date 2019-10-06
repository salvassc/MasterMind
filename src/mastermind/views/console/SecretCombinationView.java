package mastermind.views.console;

import mastermind.controllers.Controller;
import utils.Console;
import mastermind.models.SecretCombination;

public class SecretCombinationView extends CombinationView{
    
    SecretCombination secretCombination;
       
    public SecretCombinationView(Controller controller) {
        super(controller);
    }
    
    public void writeln() {
        Console console = new Console();
        
        for (int i = 0; i < this.controller.getWidth(); i++)
            console.write(MessageView.SECRET.getMessage());
        console.writeln();
    }
}
