import java.util.Scanner;

public class Scene25MarsEscape {

    /**
     * Executes Scene 25: The Escape from Tharsis.
     * Evaluates engine performance based on Scene 6's language calibration path using a clean switch.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 25: THE ESCAPE FROM THARSIS
            INT. EAS LIBURNIA - COMMAND DECK / ABOVE MARS ATMOSPHERE - CONTINUOUS
            --------------------------------------------------------------------------------
            
            You burst onto the bridge of the Liburnia, the stolen Mars Section 13 files securely 
            locked into the mainframe. Outside, the entire Tharsis crater facility is waking up. 
            Automated orbital laser batteries are locking onto your exact hull signature.
            
            Heavy, high-energy defensive beams tear through the hangar structures, spraying 
            melted titanium and rock directly across your viewport. The ship is shaking violently.
            
            SHA'IN
            (screaming over the roar of the alarms, her hands flying over the terminal)
            "The hangar doors are sealed! The base commander has initiated an automated magnetic 
             clamp lock! I need to override the primary thruster limiters right now, but the 
             Minbari biocrystals are resisting our tactical human surge inputs!"
            
            COMMANDER
            "Force the bypass, Sha'In! Ignite the matrix!"
            
            [PROCESSING HYBRID PROPULSION CHRONOLOGY CORRIDOR...]
            """);

        // MODERN SWITCH BLOCK EVALUATING PREVIOUS LINGUISTIC CALIBRATION
        switch (state.shipCalibrationPath) {
            case 3 -> {
                System.out.println("""
                    [TRIUMPH - PERFECT HYBRID PATH BONUS]: 
                    The reaction of the Earth-Minbari fusion matrix is immediate and flawless! 
                    The silver-blue crystals flood the bulkheads with a harmonious, blinding light. 
                    The Liburnia's engines roar to life in an elegant, effortless surge of power, 
                    shattering the magnetic clamps instantly. The prototype shoots into the Martian sky 
                    like a streak of lightning, leaving the defense lasers completely out of range!
                    
                    SHA'IN: 'Systems stable! No heat friction! The hybrid protocol handled the surge perfectly!'
                    """);
            }
            case 2 -> {
                System.out.println("""
                    [CONSEQUENCE - ORGANIC MINBARI STREAM PATH]: 
                    The engines flare up with immense power, but the entire console shifts back into 
                    unreadable alien light glyphs. Karel struggles with the manual helm response because 
                    the navigational compass is fully warped into Minbari measurements. 
                    
                    The ship rips free from the hangar, but scrapes a heavy defense tower on its way out. 
                    The structural feedback grid overloads, sending a painful electronic sting through the console.
                    """);
                state.playerHP -= 15;
                System.out.println("Damage Suffered: -15 HP. Current Health: " + state.playerHP + "/100");
            }
            case 1 -> {
                System.out.println("""
                    [CONSEQUENCE - BINARY COMPRESSION PATH]: 
                    The hybrid engine hesitates for an agonizing, terrifying second! The system struggles 
                    to translate the fließenden crystalline energy bands into rigid, human binary commands. 
                    A heavy planetary defense laser strikes your primary shield grid dead-center! 
                    
                    The bridge vibrates violently, bulkheads buckle, and an explosive short-circuit 
                    blasts through the auxiliary terminals before the Liburnia finally punches its way out 
                    into the upper atmosphere.
                    """);
                state.playerHP -= 20;
                System.out.println("Damage Suffered: -20 HP. Current Health: " + state.playerHP + "/100");
            }
            default -> {
                System.out.println("\n[WARNING]: Engine array uncalibrated. Suffered severe emergency thrust damage.");
                state.playerHP -= 25;
            }
        }

        System.out.println("""
            
            The crimson, rust-colored surface of Mars rapidly shrinks into a tiny sphere behind you 
            as the Liburnia leaves the sector at maximum sub-space speed. The stolen database is safe, 
            but the final cost of the timeline has just begun to unfold.
            
            [PRESS ENTER FOR SCENE 26]
            """);
        scanner.nextLine();
    }
}