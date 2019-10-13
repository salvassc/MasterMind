package mastermind.controllers;

import mastermind.models.Session;
import mastermind.models.StateValue;


public abstract class Controller {

    protected Session session;

    Controller(Session session) {
        this.session = session;
    }
    
    public StateValue getValueState() {
        return this.session.getValueState();
    }
    
    public int getWitdh(){
        return this.session.getWidth();
    }
    
    public String getNameFile(){
        return this.session.getName();
    }
    
    public void setNameFile(String name){
        this.session.setName(name);
    }

}
