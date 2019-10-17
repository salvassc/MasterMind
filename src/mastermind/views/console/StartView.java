package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class StartView extends WithConsoleView {

    public StartView (){
        console.writeln(MessageView.TITLE.getMessage());
        new SecretCombinationView().writeln();
    }

}
