package mastermind.distributed;

import mastermind.distributed.dispatchers.TCPIP;
import mastermind.controllers.Logic;
import mastermind.models.StateValue;

public class LogicProxy extends Logic {
    
    private TCPIP tcpip;
    
    public LogicProxy() {
        this.tcpip = TCPIP.createClientSocket();
        this.session = new SessionProxy(tcpip);
        this.acceptorcontrollers.put(StateValue.INITIAL, new StartControllerProxy(session, tcpip));
        this.acceptorcontrollers.put(StateValue.IN_GAME, new PlayControllerProxy(session, tcpip));
        this.acceptorcontrollers.put(StateValue.SAVING, new SaveControllerProxy(session, tcpip));
        this.acceptorcontrollers.put(StateValue.FINAL, new ResumeControllerProxy(session, tcpip));
        this.acceptorcontrollers.put(StateValue.EXIT, null);
    }
    
    public void close(){
        this.tcpip.close();
    }
    
}
