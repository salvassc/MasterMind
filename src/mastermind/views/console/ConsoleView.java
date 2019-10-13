package mastermind.views.console;

import mastermind.controllers.AcceptorController;
import mastermind.controllers.PlayController;
import mastermind.controllers.ResumeController;
import mastermind.controllers.SaveController;
import mastermind.controllers.StartController;
import mastermind.views.MessageView;
import mastermind.views.View;
import mastermind.views.console.menu.PlayMenu;
import santaTecla.utils.YesNoDialog;
import santaTecla.utils.Console;

public class ConsoleView extends View {
	
    private StartView startView;
    private ProposalView proposalView;
    private ResumeView resumeView;

    public ConsoleView(){
        this.startView = new StartView();
        this.proposalView = new ProposalView();
        this.resumeView = new ResumeView();
    }
    
    @Override
    public void interact(AcceptorController acceptorController) {
        acceptorController.accept(this);
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);		
    }

    @Override
    public void visit(PlayController playController) {
        new PlayMenu(playController).execute();
        this.proposalView.interact(playController);
    }

    @Override
    public void visit(ResumeController resumeController) {
            this.resumeView.interact(resumeController);
    }

    @Override
    public void visit(SaveController saveController) {
        boolean save = new YesNoDialog().read(MessageView.SAVE.toString());
        String name = null;
        if (save) {
            if (saveController.hasName())
                saveController.save();
            else {
                boolean exists = false;
                do {
                    name = new Console().readString(MessageView.NAME.toString());
                    exists = saveController.exists(name);
                    if (exists)
                        new Console().writeln(MessageView.NAME_EXISTS.toString());
                } while (exists);
                saveController.save(name);
            }
        }
        saveController.next();
    }

}
