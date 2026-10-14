import java.util.Scanner;

public class Scene11Hangar {

    /**
     * Executes Scene 11: The Arrival in Hangar 7, using a clean switch block
     * to evaluate the player's physical condition after the ambush.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 11: THE ARRIVAL IN HANGAR 7
            INT. BABYLON 5 - HANGAR 7 - ORBITAL TIME
            --------------------------------------------------------------------------------
            
            Thick, white cooling steam hisses from the torn vents of the Liburnia as the engines 
            cough and finally die out. The hangar crew rushes forward with extinguishing equipment. 
            The boarding ramp slides down with a groaning metallic screech.
            
            The Commander steps onto the platform—marked by soot, burns, and the murderous combat 
            in the engine room. Sha'In follows him, her jumpsuit covered in reactor oil, her face 
            pale with sheer exhaustion.
            
            CAPTAIN ELIZABETH LOCHLEY awaits them at the foot of the ramp, flanked by ZACK ALLAN 
            and two heavily armed security guards. Her gaze wanders from the smoking impacts on the 
            hull directly into the eyes of the Commander.
            
            LOCHLEY
            "You look like you've flown straight through hell, Commander."
            
            COMMANDER
            "The Raiders had our signature, Captain. Someone knew exactly on which route we were 
             returning from the Shadow borderlands. We managed to salvage a physical sample from the 
             Drakh ruins, but the encryption is extremely unstable."
            """);

        // Convert the player's health condition into an expression for the switch block
        String condition = (state.playerHP >= 75) ? "GOOD" : "INJURED";

        // MODERN SWITCH CONTROL MANAGING HEALTH OUTPUTS
        switch (condition) {
            case "GOOD" -> System.out.println("""
                LOCHLEY
                "Your vitals seem steady enough. You handled that prototype better than we hoped.
                 But the clock is ticking against us."
                """);
            case "INJURED" -> System.out.println("""
                LOCHLEY
                "You are bleeding and heavily scorched. I'm ordering an immediate injection of 
                 synthetic cellular regenerators to your system before you collapse."
                """);
            default -> System.out.println("\n[SYSTEM]: Medical scanners logging baseline diagnostics.");
        }

        System.out.println("""
            LOCHLEY
            "We will repair your ship, but time is a luxury we don't have. President Sheridan 
             sent the confirmation from Minbar. He talked to Draal. The Great Machine inside the 
             planet is ready, and they are already expecting you down there. There is a covert 
             access path via the sub-military maintenance shuttles. Zack will bring you down."
            
            Zack Allan steps forward and hands the Commander the launch clearance codes for a small, 
            unobtrusive transport pod.
            
            ZACK ALLAN
            "Watch your back down there. The Great Machine... it's a strange place. 
             And its caretaker is not the only one walking around the cores."
            
            [PRESS ENTER FOR SCENE 12]
            """);
        scanner.nextLine();
    }
}