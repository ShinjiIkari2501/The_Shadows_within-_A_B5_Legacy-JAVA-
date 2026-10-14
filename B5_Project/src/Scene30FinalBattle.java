import java.util.Scanner;

public class Scene30FinalBattle {

    /**
     * Executes Scene 30: The Inner Sanctum.
     * Utilizes a clean switch statement to process the final confrontation with Alfred Bester.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 30: THE INNER SANCTUM
            INT. PSI-CORPS HEADQUARTERS - BESTER'S MATRIX CHAMBER - CONTINUOUS
            --------------------------------------------------------------------------------
            
            The heavy biocrystalline doors blow apart under a perfectly placed thermal charge. 
            Dust and ozone flood the inner sanctum. As the smoke clears, you step into a massive, 
            glowing chamber domed by pulsating alien hardware.
            
            And out of absolute nowhere, you find her: TALIA WINTERS is trapped in the center! 
            Her body is suspended in stasis wires, cybernetic cables feeding directly into her 
            synapses. She is breathing, but her mind is completely woven into the worldwide sleeper net.
            
            ALFRED BESTER stands calmly before the main control matrix, his black gloves folded behind 
            his back, his thumb resting lightly on a small, matte-black master detonator.
            
            BESTER
            "One wrong move, Commander, and I fry the synapses of every single sleeper mind on this planet. 
             You came a long way just to witness the end of your species."
            
            GENERAL SUSAN IVANOVA steps to your side, her PPG rifle raised, aimed dead-center 
            at Bester's forehead. Her voice is ice.
            
            IVANOVA
            "This is for Marcus, Bester. And the only one leaving this room in the dust... is you."
            
            CHOOSE YOUR FINAL COMPILER-STRIKE:
            1 = Activate Meldor's technomage phantomschwarm-override.
            2 = Engage Bester in raw, physical hand-to-hand combat.
            """);

        System.out.print("Your strike choice: ");
        String strikeChoice = scanner.nextLine().strip();

        // THE FINAL COMBAT SWITCH BLOCK FOR SCENE 30
        switch (strikeChoice) {
            case "2" -> {
                System.out.println("""
                    
                    [CHOICE 2 - PHYSICAL ENGAGEMENT]: You lung forward, tackling Bester before 
                    he can fully press down the trigger! A bloody, desperate hand-to-hand struggle entbrennt 
                    on the shattered floor. You take heavy physical hits from his personal guard relays 
                    before slamming the detonator out of his hand.
                    """);
                state.playerHP -= 35;
                System.out.println("Damage Suffered: -35 HP. Current Health: " + state.playerHP + "/100");
            }
            case "1" -> System.out.println("""
                
                [CHOICE 1 - TECHNOMAGE OVERRIDE]: You raise your hand, signaling Meldor. 
                With a swift strike of his staff, a swarm of golden geometric phantomschwarm-code 
                floods the consoles. The resonance grid completely isolates Bester's detonator frequencies 
                in subspace, rendering his trigger useless before he can squeeze his thumb!
                """);
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your hesitation allows Bester to trigger a partial security flare! 
                    The terminal sprays electrical arcs across the platform, burning your hands 
                    before Ivanova can shoot the transmission weapon out of his grip.
                    """);
                state.playerHP -= 20;
                System.out.println("Damage Suffered: -20 HP. Current Health: " + state.playerHP + "/100");
            }
        }

        System.out.println("""
            
            Bester falls back against the crumbling terminal, cornered, his control matrix broken. 
            The cybernetic stasis lines around Talia Winters begin to spark and disconnect. 
            The system is open for the final evaluation of the timeline.
            
            [PRESS ENTER FOR SCENE 31]
            """);
        scanner.nextLine();
    }
}