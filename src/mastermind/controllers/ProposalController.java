package mastermind.controllers;

import java.util.List;
import mastermind.models.Combination;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.views.console.ErrorView;
import mastermind.types.Error;
import mastermind.views.console.ProposalView;
import mastermind.views.console.ProposedCombinationView;

public class ProposalController extends Controller {

    public ProposalController(Session session) {
        super(session);
    }

    public Error addProposedCombination(List<Color> colors) {
        Error error = null;
        if (colors.size() != Combination.getWidth()) {
            error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < colors.size(); i++) {
                if (colors.get(i) == null) {
                    error = Error.WRONG_CHARACTERS;
                } else {
                    for (int j = i+1; j < colors.size(); j++) {
                        if (colors.get(i) == colors.get(j)) {
                            error = Error.DUPLICATED;
                        }
                    }
                }				
            }
        }
        if (error == null){
            this.session.addProposedCombination(colors);
        }
        return error;	
    }

    @Override
    public void control() {
        List<Color> colors;
        do{
            Error error;
            do{
                colors = new ProposedCombinationView().read();
                error = this.addProposedCombination(colors);
                if (error != null)
                    new ErrorView(error).writeln();
            }while(error != null);
        }while (!new ProposalView(session).write(colors));
        this.session.next();
    }

}
