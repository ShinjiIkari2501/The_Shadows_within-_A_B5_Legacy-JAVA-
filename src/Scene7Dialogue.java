import java.util.Scanner;

public class Scene7Dialogue {

    /**
     * Executes Scene 7: The Interstellar Dialogue and Scene 7b: Life Aboard the Liburnia.
     * Utilizes a clean switch-case block to evaluate class-specific conversations.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 7: THE INTERSTELLAR DIALOGUE
            INT. EAS LIBURNIA - HYPERSPACE TRAVEL
            --------------------------------------------------------------------------------
            
            The ship glides calmly through the restless glow of hyperspace. 
            Sha'In looks up from her console, observing the Commander.
            """);

        // HIGH-PERFORMANCE SWITCH BLOCK INSTEAD OF CONDITIONAL CODES
        switch (state.characterOrigin) {
            case "Intelligence" -> System.out.println("""
                [INTELLIGENCE DIALOGUE]: Sha'In steps to the tactical table with visible respect.
                
                SHA'IN: 'Your files from the old Black Watch archives... My father was always afraid 
                         the military would turn this ship into a blunt weapon of destruction. 
                         But you look at the systems like an architect, don't you?'
                         
                COMMANDER: 'Weapons and shields are only as good as the protocol that guides them, 
                            Sha'In. Your father built a sanctuary, not a wrecking ball.'
                """);

            case "Underworld" -> System.out.println("""
                [UNDERWORLD DIALOGUE]: Sha'In crosses her arms, looking at the modified throttles.
                
                SHA'IN: 'You don't exactly go easy on the fusion injectors, Smuggler. 
                         No Earthforce regulation would allow this pressure on the lines.'
                         
                COMMANDER: 'Regulations don't keep you alive when the Corps is on your neck, kid. 
                            Your father didn't block these reserves—he hid them. He knew this ship 
                            would have to run damn fast one day.'
                """);

            default -> System.out.println("""
                [RANGER DIALOGUE]: Sha'In looks at your Ranger medallion with a quiet nod.
                
                SHA'IN: 'We are running on borrowed time, Commander. But this ship... it feels 
                         alive. Let's make sure my father's sacrifices weren't in vain.'
                """);
        }

        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 7b: THE LIFE ABOARD THE LIBURNIA
            INT. EAS LIBURNIA - HYPERSPACE TRANSIT (EXTENSION)
            --------------------------------------------------------------------------------
            
            The ship runs smoothly. The Commander utilizes the remaining time before arrival 
            to interact with the remaining crew.
            
            [THE HELMSMAN]: You meet KAREL, the helmsman, groaning and rubbing his neck.
            KAREL: 'I dedicated my life to the Rangers, Commander. I'll fly this hybrid through 
                    any asteroid field. But this Minbari architecture... My human back is killing me! 
                    These rigid team bunks are built into the wall at an exact 45-degree angle!'
            
            [THE CARGO BAY]: Down below, MOKA, the stumpy Drazi technician, slams a massive 
            sledgehammer onto a blocked energy coupling while Sha'In panics with her universal tool.
            
            SHA'IN: 'No, Moka! Don't hit it! That is a highly sensitive Biocrystal matrix!'
            
            MOKA: (growls deeply) 'Getting stuck is bad for ship. If it won't flow, you must 
                  break it, Ipsha! Raw power solves any grid!'
            
            [SYSTEM]: Hyperspace transit stable. Approaching Minbar orbit...
            [PRESS ENTER FOR SCENE 8]
            """);
        scanner.nextLine();
    }
}