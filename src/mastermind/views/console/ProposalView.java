package mastermind.views.console;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.types.Color;
import mastermind.types.Error;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {

    void interact(PlayController playController) {  
        Error error;
        do {
            List<Color> colors = new ProposedCombinationView(playController).read();
            error = playController.addProposedCombination(colors);
            if (error != null) {
                new ErrorView(error).writeln();
            }
        } while (error != null);
        playController.setRegistry();
        this.console.writeln();
        writeProposedCombinations(playController);
        if (playController.isWinner()) {
            this.console.writeln(MessageView.WINNER.getMessage());
        } else if (playController.isLooser()) {
            this.console.writeln(MessageView.LOOSER.getMessage());
        }
    }
    
    public void writeProposedCombinations(PlayController playController){
        new AttemptsView(playController).writeln();
        new SecretCombinationView(playController).writeln();
        for (int i = 0; i < playController.getAttempts(); i++) {
            new ProposedCombinationView(playController).write(i);
            new ResultView(playController).writeln(i);
        }
    }

}
