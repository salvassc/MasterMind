package mastermind.models;

import java.util.List;
import mastermind.types.Color;

public class Session {
    
    private State state;
    private Game game;
    
    public Session(){
        this.state = new State();
        this.game = new Game();
    }
    
    public void next(){
        this.state.next();
    }
    
    public void addProposedCombination(List<Color> colors){
        this.game.addProposedCombination(colors);
    }
    
    public boolean isWinner(){
        return this.game.isWinner();
    }
    
    public boolean isLooser(){
        return this.game.isLooser();
    }

    public List<Color> getColors(int position) {
        return this.game.getColors(position);
    }
    
    public int getBlacks(int i) {
        return this.game.getBlacks(i);
    }

    public int getWhites(int i) {
        return this.game.getWhites(i);
    }

    public int getAttempts() {
        return this.game.getAttempts();
    }

    public StateValue getValueState() {
        return this.state.getStateValue();
    }

    public void clear() {
        this.game.clear();
        this.state.reset();
    }
    
    public int getWidth(){
        return Combination.getWidth();
    }
}
