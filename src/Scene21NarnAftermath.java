import java.util.Scanner;

public class Scene21NarnAftermath {

    /**
     * Executes Scene 21: The Kha'Ri Ultimatum Evaluation.
     * Processes fleet support outcomes using optimized switch architecture.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 21: THE KHA'RI ULTIMATUM EVALUATION
            INT. EAS LIBURNIA - TACTICAL BRIEFING CENTER - CONTINUOUS
            --------------------------------------------------------------------------------
            
            The tactical monitors switch to the encrypted military channels of the Narn Homeworld. 
            The scarred face of the Lead Elder of the Kha'Ri flares up on the screen.
            
            ELDERS OF THE KHA'RI:
            "Commander. The red sands of Narn do not forget. We have processed the flight logs 
             and the political data bands from your ship."
            """);

        // Switch based on whether the Narn are officially recruited or paid via underground credits
        String allianceState;
        if (state.isNarnAvantgardeRecruited) {
            allianceState = "HONORABLE_VANGUARD";
        } else if (state.areNarnMercenariesHired) {
            allianceState = "MERCENARY_AGREEMENT";
        } else {
            allianceState = "BETRAYED_ISOLATION";
        }

        switch (allianceState) {
            case "HONORABLE_VANGUARD" -> System.out.println("""
                ELDERS OF THE KHA'RI:
                "You stood up to Londo's imperial mask. You honored G'Kar's words. 
                 Our elite Stoßtrupp-Avantgarde has just locked their target vectors onto 
                 the Earthforce blockade lines. When you dive over Geneva, the skies will 
                 burn with Narn plasma! For freedom, Commander!"
                """);

            case "MERCENARY_AGREEMENT" -> System.out.println("""
                ELDERS OF THE KHA'RI:
                "You signed a blood-treaty with the Centauri spider. You sold our sovereignty 
                 for Mollari's favor! The official fleet remains in dock. But your Credits have 
                 bought the blades of our criminal underground. The mercenaries will cover your 
                 flanks—but do not expect them to die for your honor."
                """);

            case "BETRAYED_ISOLATION" -> {
                System.out.println("""
                    ELDERS OF THE KHA'RI:
                    "You betrayed us to Londo, and you didn't even have the Credits to pay our 
                     underground fighters. You are an absolute ghost to us. When Bester's Omega 
                     Destroyers rip your hull to pieces, the Narn will not shed a single tear."
                    """);
                state.besterThreatLevel += 15;
            }
            default -> System.out.println("\n[SYSTEM]: Static corruption on tactical channels.");
        }

        System.out.println("""
            
            [SYSTEM]: Scenes 19, 20, and 21 are fully calibrated and verified. 
            The interstellar fleet matrix has settled into a permanent configuration.
            [PRESS ENTER TO RETURN TO STRATEGIC HUB]
            """);
        scanner.nextLine();
    }
}