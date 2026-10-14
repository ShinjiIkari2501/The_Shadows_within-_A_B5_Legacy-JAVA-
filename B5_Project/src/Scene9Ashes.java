import java.util.Scanner;

public class Scene9Ashes {

    /**
     * Executes Scene 9: The Ashes of the Past, using a clean switch expression
     * to evaluate the scanning capabilities of the Commander without any if-else blocks.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 9: THE ASHES OF THE PAST
            EXT. OUTPOST - DEAD SECTOR - ORBIT
            --------------------------------------------------------------------------------
            
            The cloaked Liburnia glides like a silent ghost in front of an ash-gray, dying 
            planet. The atmosphere is traversed by toxic, yellowish sulfur bands. Below stretch 
            the needle-like, petrified ruins of the outpost. It is silent, lifeless and full of 
            eerie secrets in the dust.
            
            INT. EAS LIBURNIA - COMMAND DECK
            
            The air temperature drops suddenly. Golden geometric equations cascade along the walls. 
            From the shadows steps the Technomage Meldor.
            
            SHA'IN
            (startled)
            "How did you get on board? Our internal sensors didn't register any teleport!"
            
            MELDOR
            "Sensors look for metal and wires, child. They do not look for the echo of the will.
             The Psi-Corps did not find this place by accident. They use the dark relics left behind 
             on this world for their purposes. The old servants of the Shadows have experimented 
             here in secret... and strangely enough, traces of my missing order brothers are also found... 
             what does that mean?"
            
            The Commander steps decisively to the sensor terminal to investigate the eerie remark 
            of the Mage and starts a deep scan of the planet's surface.
            
            [SYSTEM ANALYSIS INBOUND...]
            """);

        // Convert the capability check into an expression for the switch block
        String scanResult = (state.analysisFocus >= 90) ? "SUCCESS" : "FAILURE";

        // HIGH-PERFORMANCE BOOLEAN-DRIVEN SWITCH PATTERN
        switch (scanResult) {
            case "SUCCESS" -> {
                System.out.println("""
                    
                    [SUCCESS - HIGH ANALYSIS CAPABILITY]: The Commander's fingers fly over the hybrid terminal 
                    while optimally calibrating the scan filters. He succeeds in isolating the organic radiation 
                    of the ruins. On the screen, ancient laboratory logbooks of the Psi-Corps flicker. 
                    He comes across the trail of missing Technomages and extracts an intact, deeply pulsing 
                    blue biocrystal fragment from the core matrix.
                    
                    SHA'IN: 'That is... fascinating. The organic structure of this crystal stores data like 
                             a living cell. If we take this with us and analyze it on the station, we will 
                             decipher Bester's secret.'
                    
                    The Commander secures the unstable fragment safely in the containment field of his inventory.
                    """);
                state.controlDecryptionProgress += 100;
            }
            case "FAILURE" -> {
                System.out.println("""
                    
                    [FAILURE - ABILITY TOO LOW]: The scan fails due to the dense, biological radiation of the planet. 
                    The terminal overheats and sprays sparks. An electrostatic discharge shoots out of the console 
                    and hits the Commander painfully on the hand!
                    
                    SHA'IN: 'Attention! The bio-matrix is fighting back! The energy coupling is collapsing!'
                    
                    Despite the feedback, the Commander succeeds in ripping a loose, incomplete fragment of the 
                    glowing crystal from the holder with safety pliers before the relay station finally implodes. 
                    The data is heavily corrupted, but the physical sample is saved.
                    """);
                state.playerHP -= 15;
                System.out.println("Damage Suffered: -15 HP. Current Health: " + state.playerHP + "/100");
            }
            default -> System.out.println("\n[SYSTEM ERROR]: Sensor calibration matrix corrupted.");
        }

        System.out.println("""
            
            MELDOR: 'To hear what these stones hide, this ship is not enough. We must set course for 
                    the Babylon 5 system and travel down into the bowels of Epsilon III. Only the 
                    Great Machine can tear this veil.'
            
            [PRESS ENTER FOR SCENE 10]
            """);
        scanner.nextLine();
    }
}