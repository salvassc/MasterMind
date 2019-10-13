package mastermind.models;

import java.util.List;
import mastermind.types.Color;

public class SessionImplementation implements Session{
    
    private State state;
    private Game game;
    private Registry registry;
    private String name;
    
    public SessionImplementation(){
        this.state = new State();
        this.game = new Game();
        this.registry = new Registry(this.game);
    }  
    
    public void resume(){
        this.game.clear();
        this.state.reset();
        this.registry.reset();
    }
    
    public void next(){
        this.state.next();
    }
    
    public void clear(){
        this.game.clear();
    }
    
    public StateValue getStateValue(){
        return this.state.getValueState();
    }
    
    public boolean undoable(){
        return this.registry.undoable();
    }
    
    public boolean redoable() {
        return this.registry.redoable();
    }

    public void undo() {
        this.registry.undo(this.game);
    }

    public void redo() {
        this.registry.redo(this.game);
    }
    
    public void addProposedCombination(List<Color> colors) {
        this.game.addProposedCombination(colors);
    }
    
    public boolean isWinner() {
        return this.game.isWinner();
    }
    
    public boolean isLooser() {
        return this.game.isLooser();
    }
    
    public int getAttempts() {
        return this.game.getAttempts();
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

    public void setRegistry() {
        this.registry.registry();
    }
    
    @Override
    public StateValue getValueState() {
        return this.state.getValueState();
    }
    
    @Override
    public int getWidth() {
        return this.game.getWidth();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void save(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void hasName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean exists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
