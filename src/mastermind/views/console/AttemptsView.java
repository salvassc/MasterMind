package mastermind.views.console;

import mastermind.controllers.PlayController;
import mastermind.views.MessageView;
import santaTecla.utils.WithConsoleView;

public class AttemptsView extends WithConsoleView {

	private PlayController playController;

	AttemptsView(PlayController playController) {
		this.playController = playController;
	}

	void writeln() {
		this.console.writeln(MessageView.ATTEMPTS.getMessage().replaceFirst("#attempts",
				"" + this.playController.getAttempts()));
	}

}
