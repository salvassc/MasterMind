package mastermind.views.console;

import java.util.List;
import mastermind.models.Session;
import mastermind.types.Color;
import santaTecla.utils.WithConsoleView;
import mastermind.views.MessageView;

public class ProposalView extends WithConsoleView {
    
    private Session session;
    
    public ProposalView(Session session){
        this.session = session;
    }

    public boolean write(List<Color> colors) {
        this.console.writeln();
        new AttemptsView(this.session).writeln();
        new SecretCombinationView().writeln();
        for (int i = 0; i < this.session.getAttempts(); i++) {
            new ProposedCombinationView().write(this.session.getColors(i));
            new ResultView(session).writeln(i);
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
