import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Falls PHP keine Argumente schickt, zeigen wir das Setup
        if (args.length == 0) {
            printInitialSetup();
            return;
        }

        BabylonState state = new BabylonState();
        String currentScene = args[0]; // PHP übergibt uns die Szene (z.B. "SCENE_2", "SCENE_15")

        // Parameter für Entscheidungen parsen, falls übergeben
        if (args.length > 1) state.characterOrigin = args[1];
        String playerChoice = (args.length > 2) ? args[2] : "";

        // DER UNZERSTÖRBARE WEGWEISER: Springt direkt in deine originalen Klassen!
        // Da wir im Web-Modus sind, übergeben wir 'null' statt eines Scanners.
        switch (currentScene) {
            case "CREATION" -> printInitialSetup();
            case "PROLOGUE" -> Scene1Prologue.execute(null); 
            case "SCENE_2"  -> Scene2Spark.execute(state, null);
            case "SCENE_3"  -> Scene3Silence.execute(null);
            case "SCENE_4"  -> Scene4Negotiation.execute(state, null);
            case "SCENE_5"  -> Scene5Intrusion.execute(state, null);
            case "SCENE_6"  -> Scene6Bridge.execute(state, null);
            case "SCENE_7"  -> Scene7Dialogue.execute(state, null);
            case "SCENE_8"  -> Scene8Minbar.execute(state, null);
            case "SCENE_9"  -> Scene9Ashes.execute(state, null);
            case "SCENE_10" -> Scene10Ambush.execute(state, null);
            case "SCENE_11" -> Scene11Hangar.execute(state, null);
            case "SCENE_12" -> Scene12Epsilon.execute(state, null);
            case "SCENE_13" -> Scene13Draal.execute(state, null);
            case "SCENE_14" -> Scene14Medlab.execute(state, null);
            case "SCENE_15" -> Scene15Hub.execute(state, null);
            
            // --- DIE VOLLE CHRONOLOGISCHE VERKNÜPFUNG (Szenen 16 bis 25) ---
            case "SCENE_16" -> Scene16Sector.execute(state, null);
            case "SCENE_17" -> Scene17Hyperspace.execute(state, null);
            case "SCENE_18" -> Scene18Encounter.execute(state, null);
            case "SCENE_19" -> Scene19Outpost.execute(state, null);
            case "SCENE_20" -> Scene20Infiltration.execute(state, null);
            case "SCENE_21" -> Scene21DataCore.execute(state, null);
            case "SCENE_22" -> Scene22Escape.execute(state, null);
            case "SCENE_23" -> Scene23Shadows.execute(state, null);
            case "SCENE_24" -> Scene24Alliance.execute(state, null);
            case "SCENE_25" -> Scene25Briefing.execute(state, null);

            // --- ACT V GENEVA SHOWDOWN CORRIDOR (Szenen 26 bis 32) ---
            case "REUNION"  -> Scene26Reunion.execute(state, null);
            case "GENEVA"   -> Scene27GenevaApproach.execute(state, null);
            case "CEILING"  -> Scene29GlassCeiling.execute(state, null);
            case "BATTLE"   -> Scene30FinalBattle.execute(state, null);
            case "CONCLUSION"-> Scene31FinalBattleConclusion.execute(state, null);
            case "EPILOGUE" -> Scene32Epilogue.execute(state, null);

            default -> System.out.println("[SYSTEM ERROR]: Unbekannter Sektor-Vektor.");
        }
    }

    private static void printInitialSetup() {
        System.out.println("""
            ======================================================
            === THE SHADOWS WITHIN - INITIAL SETUP             ===
            ======================================================
            SELECT YOUR BACKGROUND SYSTEM:
            
            1 = Intelligence (Ex-Agent)
            2 = Underworld (Smuggler)
            """);
    }
}
