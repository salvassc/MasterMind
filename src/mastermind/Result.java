package mastermind;

public class Result {
    
    private int deads;
    private int damaged;
    
    public Result(int deads, int damaged){
        this.deads = deads;
        this.damaged = damaged;
    }
    
    public int getDeads(){
        return deads;
    }
    
    public void setDeads(int deads){
        this.deads = deads;
    }
    
    public int getDamaged(){
        return damaged;
    }
    
    public void setDamaged(int damaged){
        this.deads = damaged;
    }
    
    public void write(Result result){
        System.out.println(result.getDeads() + " deads and " + result.getDamaged() + " damageds");
    }
    
    public boolean isWinner(){
        if(getDeads() == 4){
            System.out.println("You've won!!! ;-)");
            return true;
        }
        else
            return false;
    }
}
