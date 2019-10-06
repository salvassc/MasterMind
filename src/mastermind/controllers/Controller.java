package mastermind.controllers;


import mastermind.models.Game;
import mastermind.models.ProposedCombination;
import mastermind.models.State;
import mastermind.models.Error;
import mastermind.views.console.MessageView;

public abstract class Controller {
    
    protected Game game;
    protected State state;
    
    public Controller(Game game, State state) { 
        this.game = game;
        this.state = state;
    }
    
    public abstract void accept(ControllerVisitor controllerVisitor);

    public void read() {
        do{
            ProposedCombination proposedCombination = new ProposedCombination();
            proposedCombination.read();
            this.game.getProposedCombinations().add(proposedCombination);
            this.game.getResults().add(this.game.getSecretCombination().getResult(proposedCombination));
            this.game.writeln();
        } while (!this.game.isFinished()); 
    }

    public int getWidth() {
        return this.game.getWidth();
    }
}