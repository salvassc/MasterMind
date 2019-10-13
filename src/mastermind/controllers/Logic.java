package mastermind.controllers;

import java.util.HashMap;
import java.util.Map;
import mastermind.models.Session;
import mastermind.models.StateValue;

public class Logic {
	
    protected Session session;
    public Map<StateValue, AcceptorController> acceptorcontrollers;

    public Logic() {
        this.acceptorcontrollers = new HashMap<StateValue, AcceptorController>();
    }

    public AcceptorController getController() {
        return this.acceptorcontrollers.get(this.session.getValueState());
    }
	
}
