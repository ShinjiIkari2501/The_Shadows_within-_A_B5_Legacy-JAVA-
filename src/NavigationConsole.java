import java.util.Scanner;

public class NavigationConsole {

    /**
     * Triggers the dangerous hyperspace engine failure and calculates player damage
     * based on Scene 6's ship matrix calibration path.
     */
    private static void handleReactorEmergency(BabylonState state) {
        System.out.println("""
            
            ------------------------------------------------------
            !!! HYPERSPACE EMERGENCY: RAIDER AMBUSH !!!
            ------------------------------------------------------
            A plasma bolt has pierced the primary distribution line!
            The engine room is burning. You must manually override the valve!
            """);

        // Check Scene 6 engine calibration choice (Interactive Weggabelung 4)
        if (state.shipCalibrationPath == 1) {
            System.out.println("""
                
                [CONSEQUENCE]: Rigid Earthforce protocols react too slowly.
                You spend agonizing minutes in the searing heat before the valve clicks.
                """);
            state.playerHP -= 30;
            System.out.println("Damage Suffered: -30 HP. Current Health: " + state.playerHP + "/100");
        }
        else if (state.shipCalibrationPath == 2) {
            System.out.println("""
                
                [CONSEQUENCE]: The cockpit displays shift to alien Minbari glyphs!
                Confused by the interface, you pull the wrong lever before finding the valve.
                """);
            state.playerHP -= 25;
            System.out.println("Damage Suffered: -25 HP. Current Health: " + state.playerHP + "/100");
        }
        else {
            System.out.println("""
                
                [TRIUMPH]: Perfect Hybrid Calibration active!
                The ship automatically dampens the plasma leak to shield your path.
                You seal the breach in record time with precise, effortless movements.
                """);
            state.playerHP -= 10;
            System.out.println("Damage Suffered: -10 HP. Current Health: " + state.playerHP + "/100");
        }

        System.out.println("""
            
            [TRANSIT]: Severely scorched but alive, you crawl back to the bridge.
            The Liburnia leaves the Raiders in the hyperspace dust.
            """);
    }

    /**
     * Renders the primary navigation menu layout using optimized Java Text Blocks.
     */
    public static void displayOptions(BabylonState state) {
        if (!state.shipObtained) return;

        System.out.println("""
            
            ======================================================
            === NAVIGATION SYSTEM: EAS %s ===
            ======================================================
            CURRENT SUB-SPACE FEED: %s
            ------------------------------------------------------
            SELECT YOUR NEXT HYPERSPACE VECTOR:
            """.formatted(state.shipName.toUpperCase(), state.getCurrentISNNewsfeed()));

        printLocationOption(state, "B5", "1");
        printLocationOption(state, "CENTAURI", "2");
        printLocationOption(state, "NARN", "3");
        printLocationOption(state, "MARS", "4");
        printLocationOption(state, "LYTA", "5");

        // Show final stratospheric approaching matrix if Mars data is secure
        if (state.controlDecryptionProgress == 999) {
            System.out.println("8 = [FINAL APPROACH] PLANET EARTH (INITIATE GENEVA DROP)");
        }
    }

    private static void printLocationOption(BabylonState state, String key, String selectionId) {
        Location loc = state.locationMap.get(key);
        if (loc.isBlocked()) {
            System.out.println(selectionId + " = [LOCKED - PSI CORPS BLOCKADE] " + loc.getDisplayName());
        } else {
            System.out.println(selectionId + " = " + loc.getDisplayName());
        }
    }

    /**
     * Validates hyperspace vectors and interceptive point-of-no-return blockades.
     */
    public static void travelTo(BabylonState state, String input, Scanner scanner) {
        if (input.equals("8") && state.controlDecryptionProgress == 999) {
            state.currentScreen = "FINALE";
            return;
        }

        String targetKey = transformInputToKey(input);
        if (targetKey == null) {
            System.out.println("\nUnknown hyperspace vector. Course correction required.");
            return;
        }

        Location loc = state.locationMap.get(targetKey);
        if (loc.isBlocked()) {
            System.out.println("\n[SABOTAGE WARNING]: Sha'In screams: 'Negative, Commander! The sector is completely blocked!'");
            return;
        }

        // Trigger ambush event before entering the first alien sector
        if ((targetKey.equals("NARN") || targetKey.equals("CENTAURI")) && !state.locationMap.get("B5").isVisited()) {
            handleReactorEmergency(state);
            state.locationMap.get("B5").setVisited(true);
        }

        loc.setVisited(true);
        executeTransitEvent(state, targetKey, scanner);
    }

    private static String transformInputToKey(String input) {
        return switch (input) {
            case "1" -> "B5";
            case "2" -> "CENTAURI";
            case "3" -> "NARN";
            case "4" -> "MARS";
            case "5" -> "LYTA";
            default -> null;
        };
    }

    private static void executeTransitEvent(BabylonState state, String key, Scanner scanner) {
        System.out.println("\n[TRANSIT]: Entering " + state.locationMap.get(key).getDisplayName() + "...");

        switch (key) {
            case "B5":
                Scene14Medlab.execute(state, scanner);
                break;
            case "CENTAURI":
                handleCentauriPrime(state, scanner);
                break;
            case "NARN":
                handleNarnHomeworld(state, scanner);
                break;
            case "MARS":
                handleMarsInfiltration(state);
                break;
            case "LYTA":
                handleLytasRefuge(state, scanner);
                break;
        }
    }

    private static void handleCentauriPrime(BabylonState state, Scanner scanner) {
        System.out.println("""
            
            [DIPLOMACY]: Emperor Londo Mollari demands colonial authority over Narn sectors in exchange for heavy cruisers.
            1 = Accept Londo's aggressive military pact.
            2 = Reject Londo and accept Vir Cotto's secret humanitarian rescue fleet option.
            """);
        System.out.print("Your choice: ");
        String choice = scanner.nextLine().strip();

        if (choice.equals("1")) {
            state.relationships.put("Ivanova_Earthfleet", state.relationships.get("Ivanova_Earthfleet") - 20);
            state.drakhInfluence += 25;
            state.besterThreatLevel += 15;
            System.out.println("\n[CONSEQUENCE]: Imperial pact signed. Cruisers secured, but Drakh presence intensifies.");
        } else {
            state.drakhInfluence -= 30;
            System.out.println("\n[CONSEQUENCE]: Secret agreement with Vir Cotto established. Drakh influence reduced.");
        }
    }

    private static void handleNarnHomeworld(BabylonState state, Scanner scanner) {
        System.out.println("\n[DIPLOMACY]: Arriving at the Military Citadel of the newly restored Kha'Ri.");

        if (state.drakhInfluence > 60) {
            System.out.println("""
                
                [CRITICAL ALERT]: The Kha'Ri discovered your pact with Londo! They refuse official military aid!
                You must look into the criminal underground to hire desperate mercenaries for 20,000 Credits.
                """);

            if (state.credits >= 20000) {
                System.out.println("""
                    1 = Spend 20,000 Credits to hire kriminelle Narn Mercenaries.
                    2 = Refuse (Warning: No Narn support for the final battle!).
                    """);
                System.out.print("Your choice: ");
                String choice = scanner.nextLine().strip();

                if (choice.equals("1")) {
                    state.credits -= 20000;
                    state.areNarnMercenariesHired = true;
                    System.out.println("\n[CONSEQUENCE]: Mercenaries hired. Bank account reduced.");
                } else {
                    System.out.println("\n[CONSEQUENCE]: You left Narn without any combat support.");
                }
            } else {
                System.out.println("[FAILED]: Insufficient funds! You cannot afford the mercenaries. The Narn abandon your cause.");
            }
        } else {
            state.isNarnAvantgardeRecruited = true;
            state.besterThreatLevel -= 20;
            System.out.println("""
                
                [TRIUMPH]: The Kha'Ri votes on its historic first decree!
                The Narn fleet is mobilized to aid Earth!
                """);
        }
    }

    private static void handleMarsInfiltration(BabylonState state) {
        System.out.println("""
            
            [MISSION]: Securing Section 13 data logs from the Tharsis Crater lab with Garibaldi's help.
            Talia's cell is empty—her location remains a terrifying mystery.
            """);
        state.controlDecryptionProgress = 999;

        // POINT OF NO RETURN ACTIVATION:
        state.locationMap.get("B5").setBlocked(true);
        System.out.println("\n[CRITICAL]: Bester locked down the Babylon 5 sector in blind rage! B5 is no longer reachable.");
    }

    private static void handleLytasRefuge(BabylonState state, Scanner scanner) {
        System.out.println("\n[DIPLOMACY]: Confronting Lyta Alexander in a lawless asteroid bar. Her Vorlon aura glows.");

        if (state.controlDecryptionProgress == 999 && state.alignmentScore >= 75) {
            System.out.println("""
                Using the Mars data logs, you convince her that Talia is an innocent victim, breaking her blind rage.
                1 = Recruit Lyta onto the path of the Resonance-Ende 7.
                """);
            System.out.print("Your choice: ");
            if (scanner.nextLine().strip().equals("1")) {
                state.lytaRecruited = true;
                System.out.println("\n[TRUE ENDING UNLOCKED]: Lyta is on board to save Talia and burn Bester's synthetic net.");
            }
        } else if (state.alignmentScore <= 40) {
            System.out.println("""
                Lyta senses your ruthless anger and joins your path of raw vengeance.
                [PATH FREED]: Lyta joins to completely obliterate the Psi-Corps HQ.
                """);
            state.lytaRecruited = true;
        } else {
            System.out.println("[FAILED]: Lyta senses hesitation, denounces the Alliance, and disappears into the shadows.");
        }
    }
}
