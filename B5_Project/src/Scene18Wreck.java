import java.util.Scanner;

public class Scene18Wreck {

    /**
     * Executes Scenes 18 to 21: The Stranded Alliance Wreck event during Hyperdrive Transit.
     * Uses a switch statement to process the physical rescue and adds 25,000 Credits to the treasury.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 18: THE STRANDED ALLIANCE WRECK
            INT. EAS LIBURNIA - RESPACE TRAVEL - TRANSIT VECTOR
            --------------------------------------------------------------------------------
            
            While maneuvering through the hyperdrive streams, Sha'In intercepts a faint, 
            distorted emergency signal. A drifting, lifeless ghost ship of the Interstellar 
            Alliance is caught in a gravitational shear wave. 
            
            Meldor steps forward, his staff pulsing in a nervous rhythm. He senses the presence 
            of a corrupted, ancient matrix inside the drifting steel hull. 
            
            The Commander logs the vector, docks the Liburnia, and leads the team inside the freezing, 
            creaking ruins of the abandoned cruiser to secure resources and clear the sector.
            
            Suddenly, a massive structural steel girder collapses directly above Sha'In!
            
            CHOOSE YOUR REACTION METHOD:
            1 = Dive shield: Throw yourself over Sha'In to absorb the impact with your body.
            2 = Tactical step: Push her away aggressively, risking a structural feedback rupture.
            """);

        System.out.print("Your reflex choice: ");
        String reaction = scanner.nextLine().strip();

        // HIGH-PERFORMANCE SWITCH BLOCK MANAGING THE ACCIDENT & CREDITS EXPANSION
        switch (reaction) {
            case "1" -> {
                System.out.println("""
                    
                    [TRIUMPH - CHOICE 1]: You dive forward without a second of hesitation, 
                    throwing your body over Sha'In. The heavy metal girder crashes onto your back, 
                    tearing your suit and inflicting painful structural burns. 
                    
                    But your heroism is absolute. Sha'In is completely unharmed, and Meldor watches 
                    you with profound, newfound respect. You won the unwavering loyalty of the Mage.
                    """);
                state.playerHP -= 20;
                state.alignmentScore += 15; // Rises towards the Path of Light
                System.out.println("Damage Suffered: -20 HP. Current Health: " + state.playerHP + "/100");
            }
            case "2" -> {
                System.out.println("""
                    
                    [CONSEQUENCE - CHOICE 2]: You push Sha'In out of the danger zone with brute force. 
                    She tumbles across the deck, escaping the crushing weight. However, the moving girder 
                    strikes a nearby live plasma relay, causing a minor explosion that scorches your hands.
                    """);
                state.playerHP -= 15;
                state.alignmentScore -= 10; // Drops towards Ruthless/Vengeance
                System.out.println("Damage Suffered: -15 HP. Current Health: " + state.playerHP + "/100");
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your split-second hesitation costs you dearly. The debris fractures, 
                    spraying sharp shrapnel across the chamber, hitting both you and Sha'In.
                    """);
                state.playerHP -= 25;
                System.out.println("Damage Suffered: -25 HP. Current Health: " + state.playerHP + "/100");
            }
        }

        System.out.println("""
            --------------------------------------------------------------------------------
            SCENES 19-21: THE PLUNDERING OF THE CORPS MATRIX
            INT. STRANDED CRUISE - SECURED BRIDGE TERMINAL - CONTINUOUS
            --------------------------------------------------------------------------------
            
            Sha'In recovers her footing and quickly interfaces with the core computer. 
            The ship was a secret logistics vessel. The Commander bypasses the broken encryption 
            grids of the main vault terminal, extracting a locked military reserve cache.
            
            [SYSTEM]: Overriding terminal defense protocols via automated switch vectors...
            """);

        // Use a clean switch expression to reward the player based on their background class
        switch (state.characterOrigin) {
            case "Intelligence" -> {
                state.credits += 25000;
                System.out.println("""
                    [INTELLIGENCE BONUS]: Bypassing the secure encrypted lockboxes with native 
                    Black Watch decryption algorithms. You extract the full alliance asset registry!
                    """);
            }
            default -> {
                state.credits += 25000;
                System.out.println("""
                    [UNDERWORLD BONUS]: Using specialized smuggling slicer tools to crack open 
                    the mechanical vault backup release. The cash drops out!
                    """);
            }
        }

        System.out.println("Kriegskasse Updated: +25,000 Credits! Total Treasury: " + state.credits);
        System.out.println("""
            
            [SYSTEM]: Alliance wreck cleared. All data and funds secured safely on the Liburnia. 
            The vortex re-ignites as you jump back onto your primary flight routing.
            [PRESS ENTER TO RETURN TO TRANSIT MENUE]
            """);
        scanner.nextLine();
    }
}