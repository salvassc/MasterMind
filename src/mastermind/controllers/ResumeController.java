package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.console.ResumeView;

public class ResumeController extends Controller {

    public ResumeController(Session session) {
        super(session);
    }

    @Override
    public void control() {
        if(new ResumeView().write())
            this.session.clear();
        else
            this.session.next();
    }

}
