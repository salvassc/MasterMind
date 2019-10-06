package mastermind.controllers;

public interface ControllerVisitor {
    
    void visit(StartController startController);

    void visit(ProposedCombinationController proposedController);

    void visit(ResumeController resumeController);
}
