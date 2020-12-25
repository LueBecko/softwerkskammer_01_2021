package java15.jep360;

import java.util.Arrays;

import java15.jep360.states.DoomsdayMachineState;

/**
 * <h1>JEP 360: Sealed Classes (Preview)</h1>
 * 
 * <h2>Summary</h2>
 * Enhance the Java programming language with sealed classes and interfaces.
 * Sealed classes and interfaces restrict which other classes or interfaces may
 * extend or implement them.
 */
public class JEP360 {
    
    public static void main(String[] args) {
        playDoomsdayMachine();

        showReflectionProperties();

        createAnonymousSubClass();
    }

    private static void createAnonymousSubClass() {

        final DoomsdayMachineState newState = new DoomsdayMachineState(){

            @Override
            public String reportState() {
                return "muhahahahahaha";
            }
            
        };

    }

    private static void showReflectionProperties() {
        System.out.println();
        System.out.println("DoomsdayState-Properties");
        System.out.println("IsSealed: " + DoomsdayMachineState.class.isSealed());
        System.out.println("permittedSubClasses: ");
        Arrays.asList(DoomsdayMachineState.class.permittedSubclasses())
            .forEach(subClass -> System.out.println(" * " + subClass.displayName()));
    }

    private static void playDoomsdayMachine() {
        final DoomsdayMachine doomsdayMachine = new DoomsdayMachine();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.startCountdown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.abortCountDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.startCountdown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.countDown();

        System.out.println("Current machine state: " +doomsdayMachine.reportState());
        doomsdayMachine.disableMachine();
    }

}
