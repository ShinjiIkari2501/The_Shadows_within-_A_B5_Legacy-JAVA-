import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BabylonState state = new BabylonState();
        Scanner scanner = new Scanner(System.in);

        // 1. DER PROLOG STARTET JETZT DIREKT ZUM SYSTEMSTART
        System.out.println("======================================================");
        System.out.println("=== THE SHADOWS WITHIN - OPERATION: TIMELINE START ===");
        System.out.println("======================================================");

        // Startet sofort deine Prolog-Klasse (Die am Ende ihr "Press Enter" verlangt)
        Scene1Prologue.execute(scanner);

        // 2. ERST JETZT ERFOLGT DIE STRATEGISCHE CHARAKTERWAHL
        System.out.println("""
            ======================================================
            === CHARACTER CREATION                             ===
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

        // Verarbeitet deine moderne Switch-Expression für die Werte
        switch (origin) {
            case "1" -> {
                state.characterOrigin = "Intelligence";
                state.analysisFocus = 95;
                System.out.println("\n[SYSTEM]: Class selected: Special Operative. Analysis focus optimized.");
            }
            case "2" -> {
                state.characterOrigin = "Underworld";
                state.credits += 30000;
                System.out.println("\n[SYSTEM]: Class selected: Smuggler. Starting stash increased.");
            }
            default -> {
                System.out.println("\n[WARNING]: Unknown input. Defaulting to standard Ranger Agent protocols.");
                state.characterOrigin = "Intelligence";
            }
        }

        System.out.println("\n[SYSTEM]: Character Matrix synchronized. Press Enter to ignite next scene...");
        scanner.nextLine();

        // --- HIER GEHT DEINE LINEARE CHRONOLOGISCHE ENGINE REIBUNGSLOS WEITER ---
        // (Scene1Prologue haben wir oben schon aufgerufen, also starten wir hier mit Scene2!)
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

        // Rest der Main.java bleibt absolut unberührt (Scene15Hub und Finale)...


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
