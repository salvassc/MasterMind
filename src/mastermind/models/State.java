package mastermind.models;

public class State {
    
    private StateValue stateValue;
    
    public State(){
        this.stateValue = StateValue.INITIAL;
    }
    
    void next(){
        this.stateValue = StateValue.values()[this.stateValue.ordinal() + 1];
    }
    
    void reset(){
        this.stateValue = StateValue.INITIAL;
    }
    
    StateValue getStateValue() {
        return this.stateValue;
    }
    
}
