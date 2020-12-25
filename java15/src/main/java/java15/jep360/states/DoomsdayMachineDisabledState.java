package java15.jep360.states;

public final class DoomsdayMachineDisabledState implements DoomsdayMachineState {

    @Override
    public String reportState() {
        return "Doomsday machine was destroyed. No harm can be done :)";
    }
    
}
