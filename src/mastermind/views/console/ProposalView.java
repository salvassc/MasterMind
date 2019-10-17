package mastermind.views.console;

import java.util.List;
import mastermind.models.Session;
import mastermind.types.Color;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {
    
    private SecretCombinationView secretCombinationView;
    private ProposedCombinationView proposedCombinationView;
    private ResultView resultView;
    private Session session;
    
    public ProposalView(Session session){
        this.session = session;
        this.secretCombinationView = new SecretCombinationView();
        this.proposedCombinationView = new ProposedCombinationView();
        this.resultView = new ResultView(session);
    }

    public boolean write(List<Color> colors) {
        this.console.writeln();
        new AttemptsView(this.session).writeln();
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.session.getAttempts(); i++) {
            this.proposedCombinationView.write(colors);
            this.resultView.writeln(i);
        }
        if (this.session.isWinner()) {
            this.console.writeln(MessageView.WINNER.getMessage());
            return true;
        } else if (this.session.isLooser()) {
            this.console.writeln(MessageView.LOOSER.getMessage());
            return true;
        }
        return false;
    }

}
