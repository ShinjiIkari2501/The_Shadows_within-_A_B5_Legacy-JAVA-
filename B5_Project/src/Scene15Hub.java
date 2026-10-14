import java.util.Scanner;

public class Scene15Hub {

    /**
     * Executes Scene 15: The Free Vector (Missions-Hub).
     * Acts as the centralized interactive node for Act III, using a complete
     * switch-case routing tree to manage interstellar travel.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        state.shipObtained = true; // Ensures navigation protocols are active

        // The hub keeps looping until the player triggers the final Earth approach
        while (!state.currentScreen.equals("GAME_OVER") && !state.currentScreen.equals("FINALE")) {
            System.out.println("""
                
                ======================================================
                === NAVIGATION SYSTEM: EAS %s ===
                ======================================================
                CURRENT SUB-SPACE FEED: %s
                ------------------------------------------------------
                SELECT YOUR NEXT HYPERSPACE VECTOR:
                """.formatted(state.shipName.toUpperCase(), state.getCurrentISNNewsfeed()));

            // Display vectors dynamically based on their blockade status
            if (state.locationMap.get("B5").isBlocked()) {
                System.out.println("1 = [LOCKED - PSI CORPS BLOCKADE] Sector Babylon 5");
            } else {
                System.out.println("1 = Sector Babylon 5 (Medlab Base)");
            }

            System.out.println("2 = Centauri Prime (Imperial Palace)");
            System.out.println("3 = Narn Homeworld (Military Citadel)");
            System.out.println("4 = Mars Sector (Tharsis Crater Lab Infiltration)");
            System.out.println("5 = Lyta's Refuge (Lawless Asteroid Bar)");

            // Unlocks Option 8 only after the Mars Section 13 data is copied (Progress = 999)
            if (state.controlDecryptionProgress == 999) {
                System.out.println("8 = [FINAL APPROACH] PLANET EARTH (INITIATE STRATOSPHERIC DIVE)");
            }

            // --- ALLIANCE MATRIX CONVERGENCE CHRONOLOGY CHECK (Scenes 19, 20 & 21) ---
            if (state.locationMap.get("CENTAURI").isVisited() && state.locationMap.get("NARN").isVisited()
                    && !state.visitedLocations.get("Earth")) {

                // 1. Scene 19 triggers (The logistics link)
                Scene19Transit.execute(state, scanner);

                // 2. Scene 20 triggers immediately after (The Centauri outcome)
                Scene20CentauriAftermath.execute(state, scanner);

                // 3. Scene 21 triggers as the final check of this corridor (The Narn outcome)
                Scene21NarnAftermath.execute(state, scanner);

                // Activates one-time flag protection to prevent endless loops
                state.visitedLocations.put("Earth", true);
            }

            System.out.print("\nEnter vector option (or type 'exit' to shut down): ");
            String input = scanner.nextLine().strip();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("\n[SYSTEM]: Systems deactivated. See you in hyperspace, Commander.");
                state.currentScreen = "GAME_OVER";
                break;
            }

            // CLEAN AND MEAN CORE HYPERDRIVE SWITCH ROUTER
            switch (input) {
                case "1" -> {
                    switch (state.locationMap.get("B5").isBlocked() ? "LOCKED" : "OPEN") {
                        case "LOCKED" -> System.out.println("""
                            
                            [SABOTAGE WARNING]: Sha'In screams over the intercom: 
                            'Negative, Commander! Three heavy Omega Destroyers are blocking the B5 jump gate! 
                             If we drop out of hyperspace there, they will rip the Liburnia to shreds instantly!'
                            """);
                        default -> {
                            System.out.println("\n[TRANSIT]: Entering Sector Babylon 5...");
                            state.locationMap.get("B5").setVisited(true);
                            Scene14Medlab.execute(state, scanner);
                        }
                    }
                }
                case "2" -> {
                    // SCENE 18-21 TRIGGER: Fires exactly once on your first alien transit flight!
                    switch ((!state.locationMap.get("CENTAURI").isVisited() && !state.locationMap.get("NARN").isVisited()) ? "TRIGGER" : "SKIP") {
                        case "TRIGGER" -> Scene18Wreck.execute(state, scanner);
                        default -> {}
                    }
                    System.out.println("\n[TRANSIT]: Entering Centauri Prime...");
                    state.locationMap.get("CENTAURI").setVisited(true);
                    Scene16Centauri.execute(state, scanner);
                }
                case "3" -> {
                    // SCENE 18-21 TRIGGER: Identical check for Narn if you decide to visit Narn first!
                    switch ((!state.locationMap.get("CENTAURI").isVisited() && !state.locationMap.get("NARN").isVisited()) ? "TRIGGER" : "SKIP") {
                        case "TRIGGER" -> Scene18Wreck.execute(state, scanner);
                        default -> {}
                    }
                    System.out.println("\n[TRANSIT]: Entering Narn Homeworld...");
                    state.locationMap.get("NARN").setVisited(true);
                    Scene17Narn.execute(state, scanner);
                }
                case "4" -> {
                    System.out.println("\n[TRANSIT]: Entering Mars Sector...");
                    state.locationMap.get("MARS").setVisited(true);

                    // Fires the full Mars crater hack and escape scenario
                    Scene24MarsLab.execute(state, scanner);
                }
                case "5" -> {
                    System.out.println("\n[TRANSIT]: Entering Lyta's Refuge...");
                    state.locationMap.get("LYTA").setVisited(true);
                    Scene22Lyta.execute(state, scanner);
                }
                case "8" -> {
                    switch (state.controlDecryptionProgress == 999 ? "UNLOCKED" : "LOCKED") {
                        case "UNLOCKED" -> {
                            state.currentScreen = "FINALE";
                            System.out.println("\n[CRITICAL]: Initiating stratospheric dive over Geneva! Breaking hyperspace now!");
                        }
                        default -> System.out.println("\n[ERROR]: Coordinates locked. Earth encryption parameters unreadable.");
                    }
                }
                default -> System.out.println("\n[WARNING]: Unknown hyperspace vector. Course correction required.");
            }
        }
    }
}
