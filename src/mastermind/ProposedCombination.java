package mastermind;

import java.util.Scanner;

public class ProposedCombination extends Combination{
    
    Result result;
    
    public ProposedCombination(){
        super();
    }

    public void read(){
        Scanner scanner;
        String readKeyboard;
                
        do{
            System.out.print("Propose a combination: ");
            scanner = new Scanner(System.in);
            readKeyboard = scanner.next();
        }while(!checkProposedCombination(readKeyboard));
        
        assignProposedCombination(readKeyboard);
    }
    
    public boolean containsColor(Color color){
        if(color.name().equals(this.getColorOne().name()) || color.name().equals(this.getColorTwo().name()) 
                || color.name().equals(this.getColorThree().name()) || color.name().equals(this.getColorFour().name()))
            return true;
        return false;
    }
    
    public boolean containsPosition(Color color, int position){
        switch (position){
            case 1:
                if(!color.name().equals(this.getColorOne().name()))
                    return false;
            case 2:
                if(!color.name().equals(this.getColorTwo().name()))
                    return false;
            case 3:
                if(!color.name().equals(this.getColorThree().name()))
                    return false;
            case 4:
                if(!color.name().equals(this.getColorFour().name()))
                    return false;    
        }
        return true;
    }
    
    public void setResult(int deads, int damageds){
        result = new Result(deads, damageds);
    }
    
    public void write(){
        result.write(result);
    }
    
    public boolean isWinner(){
        return result.isWinner();
    }
    
    private void assignProposedCombination(String readKeyboard){
        this.setColorOne(searchColor(readKeyboard.charAt(0)));
        this.setColorTwo(searchColor(readKeyboard.charAt(1)));
        this.setColorThree(searchColor(readKeyboard.charAt(2)));
        this.setColorFour(searchColor(readKeyboard.charAt(3)));
    }
    
    private boolean checkProposedCombination(String proposedCombination) {
        if(checkCombinationSize(proposedCombination) && checkRepeatedColours(proposedCombination) && checkColour(proposedCombination))
            return true;
        else 
            return false;
    }
    
    private boolean checkCombinationSize(String proposedCombination) {
        if(proposedCombination.length() == 4)
            return true;
        else {
            System.out.println("Wrong proposed combination length");
            return false;
        }
    }
    
    private boolean checkRepeatedColours(String proposedCombination) {     
        int countElements = 0;
        
        for(int i = 0; i < proposedCombination.length(); i++){
            for(int j = 1 + countElements; j < proposedCombination.length(); j++){
                if(proposedCombination.charAt(i) == proposedCombination.charAt(j)){
                    System.out.println("Repeated colors");
                    return false;
                }
            }
            countElements++;
        }
        return true;
    }
    
    private boolean checkColour(String proposedCombination){
         int counterWrongColors = 0; 
        
        for(int i = 0; i < proposedCombination.length(); i++){
            counterWrongColors = 0;
            for(Color color : Color.values())
                if(!color.name().equalsIgnoreCase(String.valueOf(proposedCombination.charAt(i)))){
                    counterWrongColors++;
            }
            if(counterWrongColors == 6) {
                System.out.println("Wrong colors, they must be: " + Color.r + Color.b + Color.y + Color.g + Color.o + Color.p);
                return false;
            }
        }
        return true;
    }
}
