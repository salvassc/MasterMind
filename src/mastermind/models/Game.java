package mastermind.models;

import java.util.ArrayList;
import java.util.List;
import mastermind.views.console.MessageView;
import utils.WithConsoleModel;

public class Game extends WithConsoleModel{
    
    private static final int MAX_LONG = 10;
    SecretCombination secretCombination;
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;

    public Game() {
        this.clear();
    }

    public void clear() {
        this.secretCombination = new SecretCombination();
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
    }

    public void writeln() {
        this.console.writeln();
        MessageView.ATTEMPTS.writeln(this.getAttemps());
        this.secretCombination.writeln();
        for (int i = 0; i < this.getAttemps(); i++) {
            this.proposedCombinations.get(i).write();
            this.results.get(i).writeln();
        }
    }

    public boolean isFinished() {
        if (this.results.get(this.getAttemps() - 1).isWinner()) {
            MessageView.WINNER.writeln();
            return true;
        }
        if (this.getAttemps() == MAX_LONG) {
            MessageView.LOOSER.writeln();
            return true;
        }
        return false;
    }

    public int getAttemps() {
        return this.proposedCombinations.size();
    }
    
    public SecretCombination getSecretCombination(){
        return this.secretCombination;
    }

    public List<ProposedCombination> getProposedCombinations(){
        return proposedCombinations;
    }
    
    public  List<Result> getResults(){
        return results;
    }

    public int getWidth() {
        return Combination.getWidth();
    }

    public void addProposedCombination(List<Color> colors) {
        ProposedCombination proposedCombination = new ProposedCombination();
        this.proposedCombinations.add(proposedCombination);
        this.results.add(this.secretCombination.getResult(proposedCombination));
    }

    public List<Color> getColors(int position) {
        return this.proposedCombinations.get(position).colors;
    }

    public int getBlacks(int position) {
        return this.results.get(position).getBlacks();
    }

    public int getWhites(int position) {
        return this.results.get(position).getWhites();
    }
}
