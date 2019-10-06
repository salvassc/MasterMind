package mastermind.models;

import mastermind.views.console.MessageView;

public class ProposedCombination extends Combination {
    
    public ProposedCombination(){
        super();
    }
    
    void write() {
        for (Color color : this.colors) {
                color.write();
        }
    }    

    public Error read() {
        Error error;
        do {
            error = null;
            MessageView.PROPOSED_COMBINATION.write();
            String characters = this.console.readString();
            if (characters.length() != Combination.getWidth()) {
                return Error.WRONG_LENGTH;
            } else {
                for (int i = 0; i < characters.length(); i++) {
                    Color color = Color.getInstance(characters.charAt(i));
                    if (color == null) {
                        return Error.WRONG_CHARACTERS;
                    } else {
                        for(int j=0; j< this.colors.size(); j++){
                            if (color == this.colors.get(j)){
                                return Error.DUPLICATED;
                            }
                        }
                    this.colors.add(color);
                    }
                }
            }
            if (error != null) {
                error.writeln();
                while (!this.colors.isEmpty()){
                    this.colors.remove(0);
                }
            }
        } while (error != null);
        return null;
    }

    boolean contains(Color color, int position) {
        return this.colors.get(position) == color;
    }

    boolean contains(Color color) {
        for (int i = 0; i < this.colors.size(); i++) {
            if (this.colors.get(i) == color) {
                return true;
            }
        }
        return false;
    }
}