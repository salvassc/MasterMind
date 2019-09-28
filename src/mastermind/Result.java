package mastermind;

public class Result {
    
    private int deads;
    private int damaged;
    
    public Result(int deads, int damaged){
        this.deads = deads;
        this.damaged = damaged;
    }
    
    private int getDeads(){
        return deads;
    }
    
    private void setDeads(int deads){
        this.deads = deads;
    }
    
    private int getDamaged(){
        return damaged;
    }
    
    private void setDamaged(int damaged){
        this.deads = damaged;
    }
    
    
    
}
