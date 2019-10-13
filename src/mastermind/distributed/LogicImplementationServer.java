package mastermind.distributed;

import mastermind.controllers.implementation.LogicImplementation;
import mastermind.distributed.dispatchers.DispatcherPrototype;
import mastermind.distributed.dispatchers.ExistsDispatcher;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.GetTitleDispatcher;
import mastermind.distributed.dispatchers.HasNameDispatcher;
import mastermind.distributed.dispatchers.NextDispatcher;
import mastermind.distributed.dispatchers.ProposeCombinationDispatcher;
import mastermind.distributed.dispatchers.RedoDispatcher;
import mastermind.distributed.dispatchers.RedoableDispatcher;
import mastermind.distributed.dispatchers.ResumeDispatcher;
import mastermind.distributed.dispatchers.SaveDispatcher;
import mastermind.distributed.dispatchers.SaveNamedDispatcher;
import mastermind.distributed.dispatchers.SetTitleDispatcher;
import mastermind.distributed.dispatchers.StartDispatcher;
import mastermind.distributed.dispatchers.StartNameDispatcher;
import mastermind.distributed.dispatchers.StateDispatcher;
import mastermind.distributed.dispatchers.TitlesDispatcher;
import mastermind.distributed.dispatchers.UndoDispatcher;
import mastermind.distributed.dispatchers.UndoableDispatcher;

public class LogicImplementationServer extends LogicImplementation{
    
    public void createDispatchers(DispatcherPrototype dispatcherPrototype){
        dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.PROPOSECOMBINATION, new ProposeCombinationDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
        dispatcherPrototype.add(FrameType.STARTNAME, new StartNameDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.TITLES, new TitlesDispatcher(this.startControllerImplementation));
        dispatcherPrototype.add(FrameType.NEXT, new NextDispatcher(this.playControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVE, new SaveDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SAVEDNAMED, new SaveNamedDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.HASNAME, new HasNameDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.EXISTS, new ExistsDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.GETTITLE, new GetTitleDispatcher(this.saveControllerImplementation));
        dispatcherPrototype.add(FrameType.SETTITLE, new SetTitleDispatcher(this.saveControllerImplementation));
        
    }
    
}
