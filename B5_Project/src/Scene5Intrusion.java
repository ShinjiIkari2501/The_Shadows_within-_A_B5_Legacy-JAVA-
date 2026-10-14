import java.util.Scanner;

public class Scene5Intrusion {

    /**
     * Executes Scene 5: The Intrusion into Sector 14, using optimized nested
     * switch statements to evaluate the infiltration vectors.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 5: THE INTRUSION INTO SECTOR 14
            INT. PIRATE BASE - SECTOR 14 - REPRODUCTION
            --------------------------------------------------------------------------------
            
            A small escort ship drops the Commander off. Through a decommissioned waste chute, 
            he infiltrates the interior of a wrecked warship that serves as a base for the Raiders. 
            In front of a high-frequency energy cell, two heavily armed mercenaries patrol. 
            In the cell sits SHA'IN – an Ipsha master constructor, exhausted but with an unbroken, 
            proud gaze.
            
            🔀 INTERACTIVE WEGGABELUNG 3: THE LIBERATION
            1 = Choice 1 [Tactical attack - Fire your PPG openly]
            2 = Choice 2 [Silent neutralization - Drop from the ceiling pipes]
            3 = Choice 3 [A distraction maneuver - Fuses down the corridor]
            4 = Choice 4 [Class-specific tactical strike / Bribery]
            """);

        System.out.print("Your choice: ");
        String choice = scanner.nextLine().strip();
        String status = "Undetected";

        // HIGH-PERFORMANCE SWITCH ARCHITECTURE REPLACING ALL IF-ELSE SEGMENTS
        switch (choice) {
            case "1" -> {
                System.out.println("""
                    
                    [CHOICE 1]: The Commander draws his PPG and shoots down the guards in an open fire fight. 
                    The loud noise echoes heavily through the steel corridors.
                    """);
                status = "Alarm";
            }
            case "2" -> System.out.println("""
                
                [CHOICE 2]: The Commander drops silently from the ceiling pipes and knocks out the guards 
                one after another before they can even react.
                """);
            case "3" -> System.out.println("""
                
                [CHOICE 3]: A heavy fusion coupling flies down the corridor. The guards investigate 
                the metallic clatter, while the Commander deactivates the cell and pulls Sha'In out.
                """);
            case "4" -> {
                // Secondary nested switch handling class-specific mechanics cleanly
                switch (state.characterOrigin) {
                    case "Intelligence" -> System.out.println("""
                        
                        [CHOICE 4 - AGENT BLUFF]: A cold bluff with forged Alliance documents intimidates 
                        the mercenaries. They open the cell completely voluntarily, fearing a diplomatic fallout.
                        """);
                    case "Underworld" -> {
                        System.out.println("""
                            
                            [CHOICE 4 - SMUGGLER BRIBERY]: The Commander pays the mercenaries a tribute of 15,000 Credits. 
                            They greedily pocket the cash, turn around, and walk away.
                            """);
                        state.credits -= 15000;
                        System.out.println("Credits spent: -15,000. Remaining balance: " + state.credits);
                    }
                    default -> {
                        System.out.println("""
                            
                            [FAILED]: Your background protocols fail to match local networks. 
                            The mercenaries spot you, forcing a brutal close-quarters brawl!
                            """);
                        state.playerHP -= 15;
                        status = "Alarm";
                    }
                }
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your hesitation alarms the base sensors! 
                    You must drag Sha'In out immediately as enemy forces seal the corridor!
                    """);
                status = "Alarm";
            }
        }

        System.out.println("\n[TRANSIT]: Heading back to the hidden hangar...");

        // Final transit logic checking the escape results
        switch (status) {
            case "Alarm" -> {
                System.out.println("""
                    The entire base is boiling! On the way up, the Commander and Sha'In must fight their way 
                    through two heavy blast doors and enemy crossfire. Sha'In panics in the background—
                    she is absolutely no fighter.
                    """);
                state.playerHP -= 10;
                System.out.println("Damage Suffered: -10 HP. Current Health: " + state.playerHP + "/100");
            }
            default -> System.out.println("""
                The base notices nothing. The two glide silently through the maintenance shafts 
                directly into the secret main hangar.
                """);
        }

        System.out.println("[PRESS ENTER FOR SCENE 6]");
        scanner.nextLine();
    }
}