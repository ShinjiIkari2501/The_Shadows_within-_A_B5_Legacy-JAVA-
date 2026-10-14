import java.util.Scanner;

public class Scene2Spark {

    /**
     * Executes Scene 2: The Spark in the Dark, utilizing a clean switch-case
     * block to evaluate the branching paths in the Brown Sector.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 2: THE SPARK IN THE DARK
            INT. BABYLON 5 - MAINTENANCE CORRIDORS (BROWN SECTOR) - NIGHT
            --------------------------------------------------------------------------------
            
            The air tastes of recycled oxygen, cheap synthetic coffee and the stale heat of 
            unmonitored freighter valves. The COMMANDER (Ranger special agent) moves like a ghost 
            through the dusty gray of the lower levels. Every shadowy corner is mapped out in 
            his mind. It is the only way he survived after losing his old intelligence partner 
            from black-ops days – Marcus Cole.
            
            Suddenly, a heavy maintenance hatch slams open. A man in the torn, blood-stained 
            robes of a Ranger breaks through and collapses directly in front of the Commander. 
            Far back in the corridor, the eerie, bluish searchlights of Psi-Corps bloodhounds 
            cut through the iron fog. The hum of bioscanners approaches unyieldingly.
            
            THE RANGER
            (gasping, dark blood welling on his lips)
            "Take it... Bring it... personally to the command staff... Trust no one... 
             The sleepers are awaking... We die... for the One..."
            
            With a final rattle, the Ranger dies. His hand opens, releasing an Anla'shok medallion 
            and an icy, pulsing data crystal. The light of the Psi security guards is already 
            breaking around the corner.
            
            CHOOSE YOUR ESCAPE PATH:
            1 = PATH 1 [Activate the cloaking device]
            2 = PATH 2 [Flee into the ventilation shafts]
            3 = PATH 3 [Trigger class-specific reaction]
            """);

        System.out.print("Your choice: ");
        String choice = scanner.nextLine().strip();

        // MODERN SWITCH CONTROL BLOCK REPLACING ALL IF-ELSE SYSTEM CONDITIONAL CODES
        switch (choice) {
            case "1" -> System.out.println("""
                
                [PATH 1]: The Commander activates his illegal, modified Chameleon Net. 
                The blue lights of the telepath agents glide right over the bare metal wall. 
                They see nothing but empty steel, curse quietly and move on in a hurry. 
                The Commander escapes silently under the protection of the shadows.
                """);

            case "2" -> {
                System.out.println("""
                    
                    [PATH 2]: The Commander sprints to the open grates. The bioscanners lock onto 
                    his heat signature instantly. A guard from the Black Omega squadron opens fire 
                    immediately with a heavy PPG. A high-energy plasma bolt sears the Commander's jacket 
                    and burns painfully into his shoulder. He slides bleeding down a scrap chute to safety.
                    """);
                state.playerHP -= 25;
                System.out.println("Damage Suffered: -25 HP. Current Health: " + state.playerHP + "/100");
            }

            case "3" -> {
                // Secondary nested switch based on character origin type
                switch (state.characterOrigin) {
                    case "Intelligence" -> System.out.println("""
                        
                        [PATH 3 - EX-INTELLIGENCE AGENT]: The Commander types ancient, classified 
                        Black Watch security overrides into a nearby sub-terminal. The pursuers' 
                        scanners suffer a massive system crash, forcing them to boot-blind and retreat.
                        """);

                    case "Underworld" -> {
                        System.out.println("""
                            
                            [PATH 3 - SMUGGLER]: The Commander tosses a pouch containing 5,000 Credits 
                            to a nearby lurker crouching in the shadows. The lurker runs screaming into the 
                            opposite corridor, successfully baiting the Psi-Corps patrol away from the track.
                            """);
                        state.credits -= 5000;
                        System.out.println("Credits spent: -5,000. Remaining balance: " + state.credits);
                    }

                    default -> System.out.println("\n[SYSTEM]: No specific background features triggered.");
                }
            }

            default -> System.out.println("""
                
                [WARNING]: Hesitation is deadly! You freeze for a second, drawing heavy fire. 
                You are forced to blind-dive into the disposal conduits to survive.
                """);
        }

        System.out.println("[PRESS ENTER FOR SCENE 3]");
        scanner.nextLine();
    }
}