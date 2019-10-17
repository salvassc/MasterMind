package mastermind.views.console;

import mastermind.views.MessageView;
import santaTecla.utils.YesNoDialog;

public class ResumeView {

    public boolean write() {
        return new YesNoDialog().read(MessageView.RESUME.getMessage());
    }

}
