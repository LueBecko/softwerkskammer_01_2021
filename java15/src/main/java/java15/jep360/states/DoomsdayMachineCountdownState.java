package java15.jep360.states;

public final class DoomsdayMachineCountdownState implements DoomsdayMachineState {
    private final int count;

    DoomsdayMachineCountdownState(int count) {
        this.count = count;
    }

    @Override
    public DoomsdayMachineState countDown() {
        if (count == 0) {
            return new DoomsdayMachineDestroyedState();
        } else {
            return new DoomsdayMachineCountdownState(count - 1);
        }
    }

    @Override
    public DoomsdayMachineState abortCountDown() {
        return new DoomsdayMachineEnabledState();
    }

    @Override
    public DoomsdayMachineState disableMachine() {
        return new DoomsdayMachineDisabledState();
    }

    @Override
    public String reportState() {
        return "Doomsday on countdown: " + count + " ticks left till destruction!";
    }
}
