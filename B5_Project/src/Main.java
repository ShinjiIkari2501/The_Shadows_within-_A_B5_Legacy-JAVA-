import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BabylonState state = new BabylonState();
        Scanner scanner = new Scanner(System.in);

        // Renders the character selection setup inside a clean text block
        System.out.println("""
            ======================================================
            === THE SHADOWS WITHIN - INITIAL SETUP             ===
            ======================================================
            SELECT YOUR BACKGROUND SYSTEM:
            
            1 = Intelligence (Ex-Agent)
                -> High Analysis Focus (95)
                -> Tactical hacking advantages
                
            2 = Underworld (Smuggler)
                -> Starting stash increased (+30,000 Credits)
                -> Underground bribery opportunities
            """);

        System.out.print("Your choice: ");
        String origin = scanner.nextLine().strip();

        // MODERN SWITCH EXPRESSION INSTEAD OF CONDITIONAL CODES
        switch (origin) {
            case "1" -> {
                state.characterOrigin = "Intelligence";
                state.analysisFocus = 95;
                System.out.println("\n[SYSTEM]: Class selected: Special Operative. Analysis focus optimized.");
            }
            case "2" -> {
                state.characterOrigin = "Underworld";
                state.credits += 30000; // Extra smuggling budget resources
                System.out.println("\n[SYSTEM]: Class selected: Smuggler. Starting stash increased.");
            }
            default -> {
                System.out.println("\n[WARNING]: Unknown input. Defaulting to standard Ranger Agent protocols.");
                state.characterOrigin = "Intelligence";
            }
        }

        System.out.println("\n[SYSTEM]: Ready to boot timeline. Press Enter to ignite prologue...");
        scanner.nextLine();

        // --- LINEAR CHRONOLOGICAL ENGINE STARTER ---
        Scene1Prologue.execute(scanner);
        Scene2Spark.execute(state, scanner);
        Scene3Silence.execute(scanner);
        Scene4Negotiation.execute(state, scanner);
        Scene5Intrusion.execute(state, scanner);
        Scene6Bridge.execute(state, scanner);
        Scene7Dialogue.execute(state, scanner);
        Scene8Minbar.execute(state, scanner);
        Scene9Ashes.execute(state, scanner);
        Scene10Ambush.execute(state, scanner);
        Scene11Hangar.execute(state, scanner);
        Scene12Epsilon.execute(state, scanner);
        Scene13Draal.execute(state, scanner);
        Scene14Medlab.execute(state, scanner);

        // --- THE STRATEGIC TRAVEL NODE ---
        Scene15Hub.execute(state, scanner);

        // --- THE ACT V GENEVA SHOWDOWN CORRIDOR ---
        switch (state.currentScreen) {
            case "FINALE" -> {
                // Act IV Reunion & Act V Final Assault Execution
                Scene26Reunion.execute(state, scanner);
                Scene27GenevaApproach.execute(state, scanner);
                Scene29GlassCeiling.execute(state, scanner);
                Scene30FinalBattle.execute(state, scanner);
                Scene31FinalBattleConclusion.execute(state, scanner);
                Scene32Epilogue.execute(state, scanner);
            }
            default -> System.out.println("\n[SYSTEM]: Engine shut down regular or game over scenario reached.");
        }

        scanner.close();
    }
}
