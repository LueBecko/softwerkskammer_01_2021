package java15.jep360.states;

public final class DoomsdayMachineDestroyedState implements DoomsdayMachineState {

    @Override
    public String reportState() {
        return "The world was destroyed. All hopes are lost";
    }
    
}
