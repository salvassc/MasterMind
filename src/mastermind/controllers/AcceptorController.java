package mastermind.controllers;

import mastermind.models.Session;


public abstract class AcceptorController extends Controller{

    public AcceptorController(Session session) {
        super(session);
    }
    
    public abstract void accept(ControllersVisitor controllersVisitor);

    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setName(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
