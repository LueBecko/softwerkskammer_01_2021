package java15.jep360.states;

public interface DoomsdayMachineState {

// public sealed interface DoomsdayMachineState permits DoomsdayMachineCountdownState,
//     DoomsdayMachineDestroyedState, DoomsdayMachineDisabledState, DoomsdayMachineEnabledState {

    default DoomsdayMachineState startCountdown() {
        throw new IllegalStateException();
    }
        
    default DoomsdayMachineState countDown() {
        throw new IllegalStateException();
    }
            
    default DoomsdayMachineState abortCountDown() {
        throw new IllegalStateException();
    }

    default DoomsdayMachineState destroyWorld() {
        throw new IllegalStateException();
    }

    default DoomsdayMachineState disableMachine() {
        throw new IllegalStateException();
    }

    String reportState();

}
