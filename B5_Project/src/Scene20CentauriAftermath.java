import java.util.Scanner;

public class Scene20CentauriAftermath {

    /**
     * Executes Scene 20: The Centauri Fleet Verification.
     * Evaluates Londo's reaction and the dark Drakh influence using a clean switch block.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 20: THE CENTAURI FLEET VERIFICATION
            INT. EAS LIBURNIA - BRIGDE SUBSPACE TRANSMISSION
            --------------------------------------------------------------------------------
            
            A high-priority sub-space channel from Centauri Prime cuts through the static. 
            The hologram of Emperor Londo Mollari materializes on the bridge. He holds a 
            glass of heavy, dark alcohol, but his eyes are completely empty of joy.
            
            LONDO MOLLARI (Hologram):
            "Commander... My intelligence cells report that your hybrid engine has been spotted 
             near the Narn borders. You are playing a very dangerous game with the alliance."
            """);

        // Convert Drakh state into discrete path variables for the switch expression
        String trackingStatus = (state.drakhInfluence >= 75) ? "PACT_SIGNED" : "COCKPIT_CLEAN";

        switch (trackingStatus) {
            case "PACT_SIGNED" -> {
                System.out.println("""
                    LONDO MOLLARI (Hologram):
                    "You signed our Imperial Pect, yes. The heavy battle cruisers are underway 
                     to your position. But do not think I will tolerate Narn scum crawling over 
                     the decks of your prototype. The eyes of my 'associates' are everywhere, Commander. 
                     Do not fail our contract."
                     
                    The hologram fades out. A dark, cold shadow feels like it is crawling over the 
                    Liburnia's primary core. The shadow of the Drakh is tracking you.
                    """);
                state.besterThreatLevel += 10;
            }
            case "COCKPIT_CLEAN" -> {
                System.out.println("""
                    LONDO MOLLARI (Hologram):
                    "You refused my generous offer, and yet you walk into the halls of our ancient 
                     enemies on Narn. You choose your paths poorly, Commander. The Centauri Republic 
                     will watch your stratospheric dive with... quiet detachment."
                     
                    The transmission cuts off sharply. Sha'In breathes a sigh of relief.
                    SHA'IN: 'Londo's eyes are blinded, but at least his shadow-networks are not 
                             embedded inside our engine grid.'
                    """);
                state.drakhInfluence -= 10;
            }
            default -> System.out.println("\n[SYSTEM]: Subspace relay frequency lost.");
        }

        System.out.println("""
            [SYSTEM]: Scene 20 complete. Ready to bridge onto the Narn evaluation matrix.
            [PRESS ENTER FOR SCENE 21]
            """);
        scanner.nextLine();
    }
}