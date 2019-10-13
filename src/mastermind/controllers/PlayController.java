package mastermind.controllers;

import java.util.List;
import mastermind.models.Session;
import mastermind.models.SessionImplementation;
import mastermind.types.Color;
import mastermind.types.Error;

public abstract class PlayController extends AcceptorController {
    
    public PlayController(Session session) {
        super(session);
    }
    
    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
    
    public abstract void undo();
    
    public abstract void redo();

    public abstract boolean undoable();

    public abstract boolean redoable();

    public abstract boolean isWinner();

    public abstract boolean isLooser();

    public abstract int getBlacks(int index);

    public abstract int getWhites(int index);

    public abstract List<Color> getColors(int position);

    public abstract int getAttempts();

    public abstract Error addProposedCombination(List<Color> colors);
    
    public abstract void next();

    public void setRegistry() {
        ((SessionImplementation)this.session).setRegistry();
    }
    
}
