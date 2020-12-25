package java15.jep360;

import java15.jep360.states.DoomsdayMachineState;
import java15.jep360.states.DoomsdayMachineEnabledState;

public class DoomsdayMachine {

    private DoomsdayMachineState state;

    public DoomsdayMachine() {
        this.state = new DoomsdayMachineEnabledState();
    }

    public String reportState() {
        return state.reportState();
    }

    public void startCountdown() {
        state = state.startCountdown();
    }
        
    public void countDown() {
        state = state.countDown();
    }
            
    public void abortCountDown() {
        state = state.abortCountDown();
    }

    public void destroyWorld() {
        state = state.destroyWorld();
    }

	public void disableMachine() {
        state = state.disableMachine();
	}
    
}
