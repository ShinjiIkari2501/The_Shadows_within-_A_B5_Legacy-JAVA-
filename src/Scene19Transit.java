import java.util.Scanner;

public class Scene19Transit {

    /**
     * Executes Scenes 19 to 21: The consolidation of the interstellar fleet.
     * Evaluates your dynamic travel choices using a clean switch statement.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENES 19-21: THE ALLIANCE MATRIX CONVERGENCE
            INT. EAS LIBURNIA - STRATEGIC COMMAND HUB - HYPERSPACE TRANSIT
            --------------------------------------------------------------------------------
            
            The tactical holo-grid on the Liburnia's bridge pulses in a steady rhythm as the 
            prototype coordinates your diplomatic achievements. Sha'In monitors the sub-space 
            networks while Meldor cross-references the decrypted coordinates from the dead sector.
            
            The factions of the old alliance are reacting to your presence in the sector. 
            The board computer processes your diplomatic footprint.
            """);

        // We convert the state of your recruited fleets into a specific scenario string for the switch
        String campaignRoute;
        if (state.isNarnAvantgardeRecruited && state.drakhInfluence < 50) {
            campaignRoute = "PURE_LIGHT_PATH";
        } else if (state.areNarnMercenariesHired) {
            campaignRoute = "MERCENARY_COMPROMISE";
        } else {
            campaignRoute = "ISOLATED_CAMPAIGN";
        }

        // HIGH-PERFORMANCE SWITCH BLOCK DEFINING THE AFTERMATH OF SCENES 19-21
        switch (campaignRoute) {
            case "PURE_LIGHT_PATH" -> {
                System.out.println("""
                    [SCENE 19-21 OUTCOME - THE PATH OF LIGHT]:
                    The data streams show a perfect convergence. By refusing Londo's aggressive terms 
                    and securing the official Narn Vanguard, the structural integrity of the Alliance 
                    remains clean. Drakh influence is actively dropping across the sectors.
                    
                    SHA'IN: 'The fleet networks are perfectly synchronized, Commander. Our strategic 
                             flanks are secured by loyal, honorable warriors.'
                    """);
                state.besterThreatLevel -= 10;
            }
            case "MERCENARY_COMPROMISE" -> {
                System.out.println("""
                    [SCENE 19-21 OUTCOME - THE MERCENARY COMPROMISE]:
                    The tactical grid shows a fragmented line. Because you signed the imperial pact 
                    with Londo Prime first, the official Narn fleet abandoned you. Your flanks are now 
                    covered by paid, unpredictable underground mercenaries. 
                    
                    MELDOR: 'Gold and credits can buy blades, Commander, but they cannot buy the true 
                            loyalty of the soul. The shadows over Centauri Prime are growing deeper.'
                    """);
                state.besterThreatLevel += 10;
            }
            case "ISOLATED_CAMPAIGN" -> {
                System.out.println("""
                    [SCENE 19-21 OUTCOME - THE ISOLATED CAMPAIGN]:
                    The tactical monitors display a highly critical sector environment. You left the 
                    Citadel empty-handed or ran out of credits for the mercenaries. Your fleet support 
                    matrix is dangerously compromised.
                    
                    KAREL: 'We are running on a skeleton crew and zero fleet backup, Commander. 
                            If we hit Bester's elite defense lines now, it's going to be a pure slaughter.'
                    """);
                state.besterThreatLevel += 25;
            }
        }

        System.out.println("""
            
            [SYSTEM]: Fleet consolidation matrix successfully evaluated. 
            The sub-space relays are stabilizing as the Liburnia approaches its next major crossroad.
            [PRESS ENTER TO RETURN TO MAIN ROUTING SYSTEM]
            """);
        scanner.nextLine();
    }
}