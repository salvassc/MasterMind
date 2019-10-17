package mastermind.views.console;

import mastermind.models.Session;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

class ResultView extends WithConsoleView {
    
    Session session;
    
    public ResultView (Session session){
        this.session = session;
    }

    void writeln(int position) {
        this.console.writeln(MessageView.RESULT.getMessage()
                        .replaceFirst("#blacks", "" + this.session.getBlacks(position))
                                        .replaceFirst("#whites", "" + this.session.getWhites(position)));
    }

}
