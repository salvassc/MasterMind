package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.console.StartView;

public class StartController extends Controller {

    public StartController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        new StartView().write();
        this.session.next();
        
    }

}
