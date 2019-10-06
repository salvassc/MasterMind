package mastermind.controllers;

import java.util.List;
import mastermind.models.Game;
import mastermind.models.State;
import mastermind.models.Color;
import mastermind.models.Error;
import mastermind.models.Combination;

public class ProposedCombinationController extends Controller {

    public ProposedCombinationController(Game game, State state) {
        super(game, state);
    }
    
    public void next() {
        this.state.next();
    }

    @Override
    public void accept(ControllerVisitor controllerVisitor) {
        controllerVisitor.visit(this);
    }
    
    public Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i+1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }				
            }
        }
        if (error == null){
            this.game.addProposedCombination(colors);
            if (this.game.isFinished()) {
                this.state.next();
            }
        }
        return error;	
    }

	public int getAttempts() {
            return game.getAttemps();
	}

	public List<Color> getColors(int position) {
            return this.game.getColors(position);
	}

	public int getBlacks(int position) {
            return this.game.getBlacks(position);
	}

	public int getWhites(int position) {
            return this.game.getWhites(position);
	}
}
