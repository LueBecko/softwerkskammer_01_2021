package java15.jep360.states;

public final class DoomsdayMachineEnabledState implements DoomsdayMachineState {
    @Override
    public DoomsdayMachineState startCountdown() {
        return new DoomsdayMachineCountdownState(10);
    }

    @Override
    public String reportState() {
        return "Machine Running; Doomsday not initiated!";
    }
    

    @Override
    public DoomsdayMachineState disableMachine() {
        return new DoomsdayMachineDisabledState();
    }
}
