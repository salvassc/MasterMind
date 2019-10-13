package mastermind.models;

import java.util.ArrayList;

public class Registry {
    
    private Game game;
    private int undoCount;
    private ArrayList<Memento> mementoList;
    
    public Registry(Game game){
        this.game = game;
        this.undoCount = 0;
        this.mementoList = new ArrayList<>();
    }
    
    void registry(){
       this.mementoList.add(this.game.createMemento());
    }
    
    void undo(Game game){
        this.undoCount++;
        game.restore(this.mementoList.get(this.undoCount));
    }
    
    void redo(Game game){
        this.undoCount--;
        game.restore(this.mementoList.get(this.undoCount));
    }
    
    boolean undoable(){
        return this.undoCount < this.mementoList.size() - 1;
    }
    
    boolean redoable(){
        return this.undoCount >=1;
    }
    
    void reset() {
        this.mementoList = new ArrayList<Memento>();
        this.undoCount = 0;
        this.mementoList.add(undoCount, this.game.createMemento());
    }
}
