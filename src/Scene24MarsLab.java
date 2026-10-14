import java.util.Scanner;

public class Scene24MarsLab {

    /**
     * Executes Scene 24 and 25: The Infiltration of the Tharsis Crater Lab
     * and the emergency escape back to the Liburnia.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 24: THE COUPE IN SECTOR 13
            INT. MARS - THARSIS CRATER LAB - EXPERIMENTAL SECURITY SECTOR
            --------------------------------------------------------------------------------
            
            Alarms are blaring in low crimson frequencies. Armed with Garibaldi's codes, 
            the Commander overrides the primary biometric security vault. The frozen, 
            heavy steel blast doors groan open, revealing the central mainframe of Section 13.
            
            Biocrystalline data tubes pulse in an eerie, synthetic white. Sha'In instantly 
            connects the Liburnia's sub-space splitter to the terminal while Meldor stands guard, 
            his staff humming with protective barriers.
            
            COMMANDER:
            "Extracting the Section 13 core files now. We are copying the entire worldwide 
             sleeper net architecture."
            
            As the progress bar on the screen hits 100%, a sudden realization hits the team. 
            The central medical isolation tank is empty—Talia Winters' biometric data tracks 
            confirm she was recently moved.
            
            SHA'IN:
            "Commander! Talia is not here! Bester anticipated our move. They have transported her 
             directly to the main inner sanctum in Geneva! She is being used as the primary 
             biological switching unit for the entire global neural net!"
            
            Suddenly, heavy automatic PPG fire rips through the laboratory doors! A squad of 
            the elite Black Omega Security guards has pinned you down. 
            
            CHOOSE YOUR TACTICAL EXIT STRATEGY:
            1 = Choice 1 [Suppressive fire: Cover Garibaldi while slicing the laboratory doors]
            2 = Choice 2 [Technomage smoke: Let Meldor vanish the squad in a distortion grid]
            """);

        System.out.print("Your combat choice: ");
        String combatChoice = scanner.nextLine().strip();

        switch (combatChoice) {
            case "1" -> {
                System.out.println("""
                    
                    [CHOICE 1 - FIRE FIGHT]: You draw your PPG and exchange heavy suppressive fire 
                    with the Black Omega guards. A stray plasma bolt grazes your side, but you buy 
                    Garibaldi enough time to detonate the structural wall supports.
                    """);
                state.playerHP -= 15;
                System.out.println("Damage Suffered: -15 HP. Current Health: " + state.playerHP + "/100");
            }
            default -> System.out.println("""
                
                [CHOICE 2 - MELDOR'S OVERRIDE]: Meldor taps his staff onto the steel grid. A massive, 
                blinding cloud of geometric code-smoke fills the entire laboratory, completely blinding 
                the guards' visor scanners. You slip away uninjured into the cargo elevator.
                """);
        }

        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 25: THE ESCAPE FROM THARSIS
            INT. EAS LIBURNIA - BRIGDE - CONTINUOUS
            --------------------------------------------------------------------------------
            
            You burst onto the bridge of the Liburnia, the stolen Mars files securely locked into the 
            mainframe. Outside, the automated automated laser batteries of the Martian base are 
            targeting your hull.
            
            SHA'IN:
            "The hangar doors are sealed! I need to override the primary thruster limiters!"
            
            [PROCESSING ENGINE RESPONSE TIME VIA SWITCH...]
            """);

        // EVALUATE ENGINE COUPLING BASED ON SCENE 6 CALIBRATION VIA SWITCH
        switch (state.shipCalibrationPath) {
            case 3 -> {
                System.out.println("""
                    [TRIUMPH - PERFECT HYBRID BONUS]: 
                    The perfect Earth-Minbari fusion response is immediate! The Liburnia's engines 
                    ignite flawlessly in a brilliant silver-blue arc, vaporizing the hangar locks 
                    and punching into the Martian sky before the defense lasers can track your signature.
                    """);
            }
            default -> {
                System.out.println("""
                    [CONSEQUENCE - COMPRESSED LOGIC]: 
                    The hybrid engine hesitates for an agonizing second, struggling with the binary 
                    translation loops. A defensive heavy laser blast strikes the primary shield grid, 
                    shaking the bridge violently before the Liburnia finally bursts into the upper atmosphere.
                    """);
                state.playerHP -= 10;
                System.out.println("Shield feedback damage suffered: -10 HP. Current Health: " + state.playerHP + "/100");
            }
        }

        System.out.println("""
            
            [SYSTEM ALERT]: Mars Sector extraction successful. Data matrix fully updated.
            [UNLOCKED]: The full Section 13 parameters are available. Vektor 8 (Earth) is ready.
            [PRESS ENTER TO RETURN TO STRATEGIC NAVIGATION CORRIDOR]
            """);

        // Finalize progression inside the scene file
        state.controlDecryptionProgress = 999;
        state.locationMap.get("B5").setBlocked(true); // Triggers the point of no return blockade!
        scanner.nextLine();
    }
}