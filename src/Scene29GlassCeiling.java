import java.util.Scanner;

public class Scene29GlassCeiling {

    /**
     * Executes Scene 29: The Glass Ceiling Bursts.
     * Evaluates tactical insertion risk using a clean switch statement.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 29: THE GLASS CEILING BURSTS
            INT. PSI-CORPS HEADQUARTERS - ENTSPANNUNGSBEREICH - NIGHT
            --------------------------------------------------------------------------------
            
            The Liburnia screamingly approaches the central biocrystalline tower of the Corps. 
            With an ear-splitting, thunderous roar, the armored hull slams directly through 
            the colossal structural glass roof of the ENTSPANNUNGSBEREICH! 
            
            A crystalline rain of a million razor-sharp shards explodes into the luxury lounge. 
            Alarms scream in high-pitched frequencies as the boarding ramps slam down onto the 
            shattered marble floors. Dust, smoke, and venting hydraulic steam fill the hall.
            
            You, General Susan Ivanova, and the elite ground teams drop from the ramps, 
            weapons raised. Psi-Corps security guards are rushing forward from the side corridors, 
            blazing heavy PPG fire into the smoke.
            
            IVANOVA
            (firing a hochenergetischer plasma bolt, her voice cutting through the noise)
            "Secure the perimeter! We need to lock down the main stairwells from top to bottom, 
             otherwise they will pin us down in this lounge! Commander, we must coordinate 
             the breach strategy right now!"
            
            CHOOSE YOUR INFILTRATION VECTOR FOR THE STAIRWELLS:
            1 = Forceful Breach: Charge the central elevator shafts using heavy tactical cover fire.
            2 = Flanking Maneuver: Split the squad into the side ventilation grids for a silent lock.
            """);

        System.out.print("Your infiltration choice: ");
        String tacticalChoice = scanner.nextLine().strip();

        // MODERN SWITCH CONTROL HANDLING THE TACTICAL CEILING ASSAULT
        switch (tacticalChoice) {
            case "1" -> {
                System.out.println("""
                    
                    [CHOICE 1 - FORCEFUL BREACH]: You order a direct, aggressive push into the center! 
                    The suppressive fire from your team shatters the inner security barriers, forcing the 
                    guards into a chaotic retreat down the steps. However, an automated roof turret scores 
                    a lucky hit against your flank before Moka can disable the power line.
                    """);
                state.playerHP -= 10;
                System.out.println("Damage Suffered: -10 HP. Current Health: " + state.playerHP + "/100");
            }
            case "2" -> {
                System.out.println("""
                    
                    [CHOICE 2 - FLANKING MANEUVER]: You slip your primary force through the side maintenance 
                    grids. The unexpected entry completely blinds the security teams waiting at the main doors. 
                    You neutralize the defensive cell silently, securing the entire sector without drawing 
                    heavy automated fire.
                    """);
                state.analysisFocus += 5;
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your lack of clear direction causes confusion under fire! The squad hesitates 
                    on the open platform, absorbing a heavy barrage of security plasma bolts before Ivanova 
                    manually forces the line forward.
                    """);
                state.playerHP -= 20;
                System.out.println("Damage Suffered: -20 HP. Current Health: " + state.playerHP + "/100");
            }
        }

        System.out.println("""
            
            The sector is secure, but the heavy steel doors leading to the deep laboratory corridors 
            are locking down automatically. Ivanova shoves her empty power clip out of her weapon, 
            locking a fresh hochenergetischer pack into place.
            
            IVANOVA: "The main stairs are locked. The road into the inner sanctum lies straight ahead, 
                     Commander. Let's find Bester and end this nightmare once and for all!"
                     
            [PRESS ENTER FOR SCENE 30]
            """);
        scanner.nextLine();
    }
}