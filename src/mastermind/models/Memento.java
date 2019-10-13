package mastermind.models;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    
    private List<ProposedCombination> proposedCombinations;
    private List<Result> results;
    
    public Memento() {
        this.proposedCombinations = new ArrayList<ProposedCombination>();
        this.results = new ArrayList<Result>();
    }  
    
    public void addProposedCombination(ProposedCombination proposedCombination){
        this.proposedCombinations.add(proposedCombination);
    }
    
    public ProposedCombination getProposedCombination(int index){
        return this.proposedCombinations.get(index);
    }
    
    public void addResults(Result results) {
        this.results.add(results);
    }
    
    public Result getResult(int index){
        return this.results.get(index);
    }
    
}
