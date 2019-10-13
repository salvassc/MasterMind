package mastermind.distributed.dispatchers;

import mastermind.controllers.implementation.PlayControllerImplementation;

public class RedoableDispatcher extends Dispatcher{
    
    public RedoableDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
        
    }

    @Override
    public void dispatch() {
        ((PlayControllerImplementation) this.acceptorController).redoable();
    }
}
