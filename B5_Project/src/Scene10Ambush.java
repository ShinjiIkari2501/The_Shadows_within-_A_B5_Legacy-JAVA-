import java.util.Scanner;

public class Scene10Ambush {

    /**
     * Executes Scene 10: The Interstellar Ambush, using a clean switch statement
     * to dynamically calculate damage based on previous calibration choices.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 10: THE INTERSTELLAR AMBUSH
            INT. EAS LIBURNIA - HYPERSPACE TRAVEL - TRANSIT TO B5
            --------------------------------------------------------------------------------
            
            The Liburnia chases with maximum thrust through the swirling hyperspace vortex 
            towards the Epsilon sector. You are flying back to investigate the data of the 
            recovered Drakh crystal.
            
            Suddenly, the entire ship shakes under a brutal, bone-shattering impact! Red warning 
            lights flood the bridge, and the howling of the decompression sirens sets in.
            
            SHA'IN
            (thrown against her console)
            "Ambush! Three heavy Raider fighters fell directly on us from the shadows of an 
             unstable gravitational shear wave! They lurked in the dead angle of the stream and 
             intercepted our engine resonance! A plasma bolt pierced our primary distribution – 
             the main plasma line in the engine room is leaking! If we don't contain the pressure 
             manually, the core will explode right in hyperspace!"
            
            MELDOR
            (calm, remaining in the shadows)
            "A test of the flesh. Go, Commander. Show the machine what steel you are made of."
            
            You hesitate for no second. You sprint from the bridge down into the blazing heat of 
            the reactor section. The Minbari crystals on the walls pulse in a panicked, dying red. 
            You must advance directly to the glowing valve to force the manual override.
            
            [PROCESSING ENGINE EMERGENCY OVERRIDE...]
            """);

        // CLEAN AND MODERN SWITCH EXPRESSION INSTEAD OF MESSY IF-ELSE
        switch (state.shipCalibrationPath) {
            case 1 -> {
                System.out.println("""
                    [CONSEQUENCE - BINARY COMPRESSION PATH]: 
                    The systems react stubbornly and slowly because they must follow the rigid 
                    Earthforce safety cycles. You stand agonizingly long in the murderous heat 
                    before the valve finally clicks. The plasma burns your arms and sears your face.
                    """);
                state.playerHP -= 30;
                System.out.println("Damage Suffered: -30 HP. Current Health: " + state.playerHP + "/100");
            }
            case 2 -> {
                System.out.println("""
                    [CONSEQUENCE - ORGANIC MINBARI STREAM PATH]: 
                    The reactor runs with maximum energy, but the warning displays in the engine room 
                    pulse in the three-dimensional light patterns of the Minbari. For your human eyes, 
                    it is pure chaos! You reach for the wrong switch in the hectic rush, triggering 
                    a small plasma explosion before feeling out the correct valve.
                    """);
                state.playerHP -= 25;
                System.out.println("Damage Suffered: -25 HP. Current Health: " + state.playerHP + "/100");
            }
            case 3 -> {
                System.out.println("""
                    [TRIUMPH - PERFECT HYBRID PATH]: 
                    Thanks to the perfect hybrid protocol, the systems harmonize flawlessly. 
                    The ship responds lightning-fast to the manual override. The Minbari crystals 
                    automatically throttle the plasma flow in your blind spot to protect you. 
                    With precise movements, you seal the leak in record time.
                    """);
                state.playerHP -= 10;
                System.out.println("Damage Suffered: -10 HP. Current Health: " + state.playerHP + "/100");
            }
            default -> {
                System.out.println("\n[ERROR]: Ship systems uncalibrated. Reactor emergency feedback suffered.");
                state.playerHP -= 35;
            }
        }

        System.out.println("""
            
            Completely exhausted, smoking and marked by burns, you drag yourself back to the bridge. 
            The majestic silhouette of BABYLON 5 and the bluish shimmering planet EPSILON III 
            materialize in front of the main viewport. The engines of the Liburnia stutter 
            as the ship touches down in Hangar 7.
            
            [PRESS ENTER FOR SCENE 11]
            """);
        scanner.nextLine();
    }
}