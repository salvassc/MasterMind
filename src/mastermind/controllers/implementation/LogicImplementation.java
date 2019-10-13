package mastermind.controllers.implementation;

import mastermind.controllers.Logic;
import mastermind.models.SessionImplementation;
import mastermind.models.StateValue;


public class LogicImplementation extends Logic{
    
    protected StartControllerImplementation startControllerImplementation;
    protected PlayControllerImplementation playControllerImplementation;
    protected ResumeControllerImplementation resumeControllerImplementation;
    protected SaveControllerImplementation saveControllerImplementation;
    
    public LogicImplementation() {
        this.session = new SessionImplementation();
        this.startControllerImplementation = new StartControllerImplementation(session);
        this.playControllerImplementation = new PlayControllerImplementation(session);
        this.saveControllerImplementation = new SaveControllerImplementation(session);
        this.resumeControllerImplementation = new ResumeControllerImplementation(session);
        this.acceptorcontrollers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.acceptorcontrollers.put(StateValue.IN_GAME, this.playControllerImplementation);
        this.acceptorcontrollers.put(StateValue.SAVING, this.saveControllerImplementation);
        this.acceptorcontrollers.put(StateValue.FINAL, this.resumeControllerImplementation);
        this.acceptorcontrollers.put(StateValue.EXIT, null);
    }
}
