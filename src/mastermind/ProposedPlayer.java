package mastermind;

import java.util.ArrayList;

public class ProposedPlayer {
    ProposedCombination proposedCombination = new ProposedCombination();
    private int attemps;
    ArrayList<ProposedCombination> listProposedCombination = new ArrayList<>();
    
    public int getAttemps(){
        return attemps;
    }
    
    public void setAttemps(int attemps){
        this.attemps = attemps;
    }
    
    public void writeAttemps(){
        System.out.println(getAttemps()+" attempt(s):");
    }
    
    public void propose(){
        proposedCombination = new ProposedCombination();
        proposedCombination.read();
        listProposedCombination.add(proposedCombination);
    }
    
    public ProposedCombination getLastProposedPlayer(){
        return proposedCombination;
    }

    public void writeProposeCombinations() {
        for(ProposedCombination proposedCombination : listProposedCombination){
            System.out.print(proposedCombination.getColorOne().name()+proposedCombination.getColorTwo().name()+proposedCombination.getColorThree().name()+proposedCombination.getColorFour().name()+" --> ");
            proposedCombination.write();
        }
    } 
    
    public boolean isWinner(){
       return proposedCombination.isWinner();
    }
    
    public boolean islooser(){
        if(attemps == 10){
            System.out.println("You've lost!!! :-(");
            return true;
        }
        else
            return false;
    }
}
