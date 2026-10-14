import java.util.Scanner;

public class Scene26Reunion {

    /**
     * Executes Scene 26: The Reunion in Hyperspace.
     * Utilizes a clean switch statement to process the tactical alliance briefing.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 26: THE REUNION IN HYPERSPACE
            INT. EAS LIBURNIA - MESS HALL / REBEL FLEET MEETING - NIGHT
            --------------------------------------------------------------------------------
            
            The Liburnia slips into the dense, purple ion-shrouds of the hidden nebula, 
            successfully docking with General Susan Ivanova's rogue rebel fleet. 
            
            GENERAL SUSAN IVANOVA and DR. STEPHEN FRANKLIN step aboard the prototype, their 
            faces hardened by weeks of underground warfare. But before the strategic briefing 
            can even begin, the heavy mess hall hatch slams open with a deafening bang!
            
            MICHAEL GARIBALDI charges into the room, holding a massive, sizzling, steaming pan 
            high in the air! The intense, rich aroma of genuine traditional Earth meat and 
            spices completely floods the sterile military deck. He raided the hidden Mars logistics 
            depots and cooked a massive traditional meal for the entire crew.
            
            GARIBALDI:
            "If I had to look at another plate of dried Minbari vegetables or nutrient paste 
             for one more minute, I swear to God I would have spaced myself right into the stream! 
             Sit down, eat up. The fleet is warm, and we've got a lot of ground to cover."
            
            Gathered around the table, the old command staff breaks bread together. For the first 
            time in cycles, the crushing weight of the war lifts. You toast to the memory of 
            MARCUS COLE with tears, silent toasts, and roaring laughter, remembering his terrible, 
            stubborn Ranger poetry and pure unyielding loyalty. The ice breaks entirely.
            
            IVANOVA
            (sets her glass down, her eyes turning into pure, focused flint)
            "He was a heroischer, noble fool... and I am completely done mourning him, Commander. 
             We honor his sacrifice by finishing this fight. My ships are locked onto our vector. 
             I am personally leading the orbital drop and the ground assault. We are going to hammer 
             Bester's net into absolute dust. What is our fleet availability status?"
            
            CHOOSE YOUR STRATEGIC ASSASSIN-BRIEFING OVERVIEW:
            1 = Report Fleet Assets: Present the compiled political data logs of your allies.
            2 = Skip Briefing: Move straight to the tactical assault deployment grids.
            """);

        System.out.print("Your briefing choice: ");
        String briefingInput = scanner.nextLine().strip();

        // CLEAN SWITCH BLOCK INSTEAD OF IF-ELSE FOR CHRONOLOGICAL CONTINUITY
        switch (briefingInput) {
            case "1" -> {
                System.out.println("""
                    
                    [TACTICAL REVIEW]: You project the dynamic holo-map of the fleet onto the table. 
                    The switch matrices process your background accomplishments. 
                    Ivanova nods with grim satisfaction as she analyzes the structural data 
                    of your recruited reinforcements.
                    """);
                state.analysisFocus += 5; // Analytical optimization bonus
            }
            default -> System.out.println("""
                
                [TACTICAL URGENCY]: You bypass the extensive database review. 
                Ivanova immediately brings up the schematics of the Psi-Corps headquarters 
                in Geneva, focusing entirely on the structural vulnerabilities of the target.
                """);
        }

        System.out.println("""
            
            IVANOVA: "The transponder fakes are calibrated. The fleets are spinning up their reactors. 
                     Next stop... Planet Earth. Lock your harnesses, crew. It's time to go home."
                     
            [SYSTEM]: Hyperspace convergence complete. Approaching the atmosphere of Earth...
            [PRESS ENTER FOR SCENE 27]
            """);
        scanner.nextLine();
    }
}