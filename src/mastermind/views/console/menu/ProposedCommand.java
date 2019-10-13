package mastermind.views.console.menu;

import mastermind.controllers.PlayController;

public class ProposedCommand extends Command {
    
    public ProposedCommand(PlayController playController){
        super(CommandTitle.PROPOSED_COMBINATION.getTitle(),playController);
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    protected void execute() {
        
    }

 
    
}
