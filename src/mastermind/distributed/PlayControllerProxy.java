package mastermind.distributed;

import java.util.List;
import mastermind.controllers.PlayController;
import mastermind.distributed.dispatchers.FrameType;
import mastermind.distributed.dispatchers.TCPIP;
import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.types.Error;

public class PlayControllerProxy extends PlayController {

    private TCPIP tcpip;
    
    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session);
        this.tcpip = tcpip;
    }

    @Override
    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    @Override
    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    @Override
    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isWinner() {
        this.tcpip.send(FrameType.WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public boolean isLooser() {
        this.tcpip.send(FrameType.LOOSER.name());
        return this.tcpip.receiveBoolean();
    }

    @Override
    public int getBlacks(int index) {
        this.tcpip.send(FrameType.BLACKS.name());
        this.tcpip.send(index);
        return this.tcpip.receiveInt();
    }

    @Override
    public int getWhites(int index) {
        this.tcpip.send(FrameType.WIDTH.name());
        this.tcpip.send(index);
        return this.tcpip.receiveInt();
    }

    @Override
    public List<Color> getColors(int position) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getAttempts() {
        this.tcpip.send(FrameType.ATTEMPS.name());
        return this.tcpip.receiveInt();
    }

    @Override
    public Error addProposedCombination(List<Color> colors) {
        this.tcpip.send(FrameType.PROPOSECOMBINATION.name());
        this.tcpip.send(colors.size());
        Error error = this.tcpip.receiveError();
        return error;
    }

    @Override
    public void next() {
        this.tcpip.send(FrameType.NEXT.name());
    }
    
}
