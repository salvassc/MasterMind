package mastermind;

public class SecretPlayer {
    
    SecretCombination secretCombination;
    ProposedPlayer proposedPlayer;
    
    
    public SecretPlayer(ProposedPlayer proposedPlayer){
        this.proposedPlayer = proposedPlayer;
    }
    
    public void prepare(){
        secretCombination = new SecretCombination();
        write();
    }
    
    public void answer(){
        secretCombination.calculateResult(proposedPlayer.getLastProposedPlayer());
    }
    
    public void write(){
        System.out.println(secretCombination.getColorOne().name()+secretCombination.getColorTwo().name()+secretCombination.getColorThree().name()+secretCombination.getColorFour().name());
    } 
}
