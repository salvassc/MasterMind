package mastermind.views.console;

import mastermind.models.Session;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {
    
    Session session;
    
    public AttemptsView(Session session){
        this.session = session;
    }

    void writeln() {
        this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
                        "" + this.session.getAttempts()));
    }
    
}
