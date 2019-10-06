package mastermind.views.console;

import mastermind.controllers.Controller;
import mastermind.controllers.ProposedCombinationController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.StartController;
import mastermind.views.View;
import utils.YesNoDialog;

public class ConsoleView extends View {
    
    GameView gameView;

    @Override
    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        startController.start();
        new GameView(startController).writeln();
    }

    @Override
    public void visit(ProposedCombinationController proposedController) {
        new ProposedCombinationView(proposedController).read();
    }

    @Override
    public void visit(ResumeController resumeController) {
        MessageView.RESUME.write();
        resumeController.resume(new YesNoDialog().read());
    }
    
}
