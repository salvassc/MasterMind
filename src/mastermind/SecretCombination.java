package mastermind;

import java.util.Random;

public class SecretCombination extends Combination{
    
    public SecretCombination(){
        generateSecretCombination();
    }  

    public void calculateResult(ProposedCombination proposedCombination){
        int deads = 0;
        int damageds = 0;
        
        if(proposedCombination.getColorOne() == this.getColorOne()){
                deads++;
        } else if(proposedCombination.containsColor(this.getColorOne()))
            damageds++;
        
        if(proposedCombination.getColorTwo() == this.getColorTwo()){
                deads++;
        } else if(proposedCombination.containsColor(this.getColorTwo()))
            damageds++;
        
        if(proposedCombination.getColorThree() == this.getColorThree()){
                deads++;
        } else if(proposedCombination.containsColor(this.getColorThree()))
            damageds++;
        
        if(proposedCombination.getColorFour() == this.getColorFour()){
                deads++;
        } else if(proposedCombination.containsColor(this.getColorFour()))
            damageds++;
        
        proposedCombination.setResult(deads, damageds);
    }
    
    private void generateSecretCombination(){
        do{
            setColorOne(Color.values()[new Random().nextInt(Color.values().length)]);
            setColorTwo(Color.values()[new Random().nextInt(Color.values().length)]);
            setColorThree(Color.values()[new Random().nextInt(Color.values().length)]);
            setColorFour(Color.values()[new Random().nextInt(Color.values().length)]);
        }while(getColorOne() == getColorTwo() || getColorOne() == getColorThree() || getColorOne() == getColorFour()
                || getColorTwo() == getColorThree() || getColorTwo() == getColorFour() || getColorThree() == getColorFour());
    }
}
