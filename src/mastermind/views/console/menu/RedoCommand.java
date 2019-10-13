package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.ProposalView;

public class RedoCommand extends Command{
    
    public RedoCommand(PlayController playController){
        super(CommandTitle.REDO_COMMAND.getTitle(),playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).redo();
        new ProposalView().writeProposedCombinations(((PlayController) this.acceptorController));
    }

    @Override
    public boolean isActive() {
        return ((PlayController) this.acceptorController).redoable();
    }
    
}
