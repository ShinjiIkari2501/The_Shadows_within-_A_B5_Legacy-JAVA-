import java.util.Scanner;

public class Scene17Narn {

    /**
     * Executes the diplomatic encounters on the Narn Homeworld.
     * Utilizes a strategic switch block evaluating Centauri ballast variables.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 17-B: THE CITADEL OF RED SAND
            EXT. NARN HOMEWORLD - THE MILITÄR-ZITADELLE - DAY
            --------------------------------------------------------------------------------
            
            The Liburnia drops out of the burning crimson skies of Narn. You enter the heavy, 
            sand-scoured halls of the Central Military Citadel. 
            
            The Elders of the newly restored Kha'Ri gather around the stone tactical grid, 
            their eyes filled with the ancient pride of a liberated race.
            """);

        // Convert the dynamic Centauri aftermath into a fixed status string for our switch
        String dynamicNarnStatus = (state.drakhInfluence > 60) ? "BETRAYED_BY_LONDO" : "HONORABLE_ALLIED";

        switch (dynamicNarnStatus) {
            case "BETRAYED_BY_LONDO" -> {
                System.out.println("""
                    [CRITICAL OUTCOME - THE CENTAURI BALLAST]: 
                    The atmosphere inside the Citadel turns ice-cold. The Lead Elder steps forward, 
                    slamming his heavy battle blade directly into the red sand before your feet!
                    
                    ELDERS OF THE KHA'RI:
                    "You bring G'Kar's seal, yet you signed a treaty that sells our sectors back 
                     to Londo Mollari! You traded our sovereignty for Centauri fire power! 
                     The official Narn fleet will NEVER support a traitor!"
                    
                    [UNDERGROUND OPTION UNLOCKED]: 
                    The regular vanguard drops out. To save your tactical flanks, you must turn to the 
                    criminal underground and hire ruthless kriminelle mercenaries. They demand a flat 
                    payment of 20,000 Credits upfront.
                    """);

                // Sub-switch evaluating financial kriegskasse status
                String financialCheck = (state.credits >= 20000) ? "CAN_AFFORD" : "BROKE";

                switch (financialCheck) {
                    case "CAN_AFFORD" -> {
                        System.out.println("""
                            1 = Spend 20,000 Credits to hire the criminal Narn Mercenaries.
                            2 = Refuse (Warning: You will enter the final battle completely exposed!).
                            """);
                        System.out.print("Your financial choice: ");
                        String mercChoice = scanner.nextLine().strip();

                        switch (mercChoice) {
                            case "1" -> {
                                state.credits -= 20000;
                                state.areNarnMercenariesHired = true;
                                System.out.println("\n[CONSEQUENCE]: Transaction processed. The mercenaries sign the contract. Stash reduced.");
                            }
                            default -> System.out.println("\n[CONSEQUENCE]: You refused the terms. You leave Narn empty-handed.");
                        }
                    }
                    case "BROKE" -> {
                        System.out.println("""
                            [FAILED]: Insufficient funds! You do not have the 20,000 Credits from the 
                            Allianz-Wrack simulation in your kriegskasse. The mercenaries laugh and walk away. 
                            The Narn completely abandon your cause. (Threat Score Increases!).
                            """);
                        state.besterThreatLevel += 35;
                    }
                }
            }

            case "HONORABLE_ALLIED" -> {
                state.isNarnAvantgardeRecruited = true;
                state.besterThreatLevel -= 20;
                System.out.println("""
                    [TRIUMPH OUTCOME - THE PATH OF LIGHT]: 
                    A triumphant roar echoes through the red stone halls! The Elders look at you 
                    with profound, unyielding respect. They know you stood up to Londo's high-born arrogance.
                    
                    ELDERS OF THE KHA'RI:
                    "You protected our freedom in the galactic courts, Commander. The newly born Kha'Ri 
                     has just gathered for its historic first official session. Our very first decree 
                     is signed: The elite Narn Stoßtrupp-Avantgarde is mobilized to protect Earth!"
                    """);
            }
        }

        System.out.println("\n[SYSTEM]: Narn Homeworld operations completed. Returning to hyperspace grid.");
        System.out.println("[PRESS ENTER TO RETURN TO TRANSIT ENGINE]");
        scanner.nextLine();
    }
}