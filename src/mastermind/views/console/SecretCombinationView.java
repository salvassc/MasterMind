package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;
import mastermind.models.Combination;
import mastermind.models.Session;

class SecretCombinationView extends WithConsoleView {

    void writeln() {
        for (int i = 0; i < Combination.getWidth(); i++) {
            this.console.write(MessageView.SECRET.getMessage());
        }
        this.console.writeln();
    }
	
}
