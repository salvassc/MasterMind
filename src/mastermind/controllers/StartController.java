package mastermind.controllers;

import mastermind.models.Session;

public abstract class StartController extends AcceptorController {

    public StartController(Session session) {
        super(session);
    }

    @Override
    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }
    
    public abstract void start();
    
    public abstract void start(String title);
    
    public abstract String[] getGamesNames();

}
