package mastermind.models;

public class State {

    private StateValue statueValue;
    
    public State() {
        this.statueValue = StateValue.INITIAL;
    }
    
    public void next() {
        this.statueValue = StateValue.values()[this.statueValue.ordinal() + 1];
    }
    
    public void reset() {
        this.statueValue = StateValue.INITIAL;
    }
    
    public StateValue getStatueValue() {
        return this.statueValue;
    }
    
}
