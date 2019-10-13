package mastermind.views.console.menu;

import mastermind.controllers.PlayController;
import mastermind.views.console.ProposalView;

public class UndoCommand extends Command{
    
    public UndoCommand(PlayController playController){
        super(CommandTitle.UNDO_COMMAND.getTitle(),playController);
    }

    @Override
    protected void execute() {
        ((PlayController) this.acceptorController).undo();
        new ProposalView().writeProposedCombinations(((PlayController) this.acceptorController));
    }

    @Override
    public boolean isActive() {
        return ((PlayController) this.acceptorController).undoable();
    }
    
}
