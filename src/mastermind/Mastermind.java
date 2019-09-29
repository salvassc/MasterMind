package mastermind;

import java.util.Scanner;

public class Mastermind {

   
    public static void main(String[] args) {
        play();
    }
    
    private static void play(){
        String readResponse;
        
        do{
            ProposedPlayer proposedPlayer = new ProposedPlayer();
            SecretPlayer secretPlayer = new SecretPlayer(proposedPlayer);

            System.out.println("----- MASTERMIND -----");      
            secretPlayer.prepare();  
            do{
                proposedPlayer.propose();
                secretPlayer.answer();
                proposedPlayer.setAttemps(proposedPlayer.getAttemps()+1);
                secretPlayer.answer();
                proposedPlayer.writeAttemps();
                secretPlayer.write();
                proposedPlayer.writeProposeCombinations();
            } while(!proposedPlayer.islooser() && !proposedPlayer.isWinner());
            System.out.print("Do you want to continue? (s/n): ");
            Scanner scanner = new Scanner(System.in);
            readResponse = scanner.next();
        } while(readResponse.equals("s")); 
    }
    
}
