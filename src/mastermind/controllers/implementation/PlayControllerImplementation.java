package mastermind.controllers.implementation;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.controllers.ProposalController;
import mastermind.models.Session;
import mastermind.controllers.*;
import mastermind.types.Color;

public class PlayControllerImplementation extends PlayController{
    
    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;
    private ExitController exitController;
    
    public PlayControllerImplementation(Session session) {
        super(session);
        this.proposalController = new ProposalController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
        this.exitController = new ExitController(this.session);
    }

    public int getBlacks(int index) {
        return this.proposalController.getBlacks(index);
    }

    public int getWhites(int index) {
        return this.proposalController.getWhites(index);
    }

    public List<Color> getColors(int position) {
        return this.proposalController.getColors(position);
    }

    public int getAttempts() {
        return this.proposalController.getAttempts();
    }

    public mastermind.types.Error addProposedCombination(List<Color> colors) {
        return this.proposalController.addProposedCombination(colors);
    }

    @Override
    public void undo() {
        this.undoController.undo();
    }

    @Override
    public void redo() {
        this.redoController.redo();
    }

    @Override
    public boolean undoable() {
        return this.undoController.undoable();
    }

    @Override
    public boolean redoable() {
        return this.redoController.redoable();
    }

    @Override
    public boolean isWinner() {
        return this.proposalController.isWinner();
    }
    
    public boolean isLooser() {
        return this.proposalController.isLooser();
    }

    @Override
    public void next() {
        this.exitController.next();
    }
    
    
    
    
}
