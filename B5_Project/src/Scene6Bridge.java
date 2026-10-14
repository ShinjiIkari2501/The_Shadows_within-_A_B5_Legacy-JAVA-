import java.util.Scanner;

public class Scene6Bridge {

    /**
     * Executes Scene 6: The Bridge of the EAS Liburnia, utilizing a modern switch-case 
     * block to evaluate the matrix calibration and triggers the B5 subspace call.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 6: THE BRIDGE OF THE EAS LIBURNIA
            INT. EAS LIBURNIA - COMMAND DECK (DIREKT NACH DER RETTUNG)
            --------------------------------------------------------------------------------
            
            Sha'In slams her private override code into the heavy hangar lock. The blast doors 
            slide apart, revealing the breathtaking silhouette of the EAS LIBURNIA. Shimmering, 
            silver Minbari biocrystals run like organic tendons through the structural steel arches 
            of the Earthforce bridge.
            
            They rush onto the deck. But instead of majestically booting up, all consoles freeze 
            in a blocked, matte amber tone. A threatening warning hum vibrates through the hull.
            
            SHA'IN
            (grimly, slamming her fist against the terminal)
            "Damn it... it's my father's language-pattern protocol! They thought they were stealing 
             a finished weapon of war in Sector 14, but they only towed away a lifeless shell! 
             The ship is sleeping! My father gave his life to protect the formulas from the Raiders. 
             He couldn't write the final translation loop... The binary computer of Earth refuses 
             to interpret the flowing light patterns of the Minbari matrix. I am standing before 
             this wall of dead crystal, unable to ignite the spark!"
            
            The Commander steps to the main terminal, looking at the unfinished code cascades 
            of the murdered father.
            
            🔀 INTERACTIVE WEGGABELUNG 4: DAS SPRACHMUSTER-RÄTSEL (MISSION-HUB)
            1 = WEG 1 [Enforce human protocols (Binary Compression)]
            2 = WEG 2 [Give free rein to Minbari logic (Organic Stream)]
            3 = WEG 3 [Bridge the analytical gap (Requires High Analysis)]
            """);

        System.out.print("Your choice: ");
        String puzzleChoice = scanner.nextLine().strip();

        // THE CLEAN SWITCH PATTERN CONTINUES SECURELY
        switch (puzzleChoice) {
            case "1" -> {
                state.shipCalibrationPath = 1;
                System.out.println("""
                    
                    [PATH 1]: You force the rigid, binary command structures of Earth onto the matrix, 
                    compressing the organic paths into fixed grids.
                    The ship awakens with a rough, unhealthy mechanical cough. The lights flicker 
                    in a cold neon white. The systems run stable, but rigid and slowed down.
                    SHA'IN: (sighs quietly) 'It flies... but my father's work feels mutilated.'
                    """);
            }
            case "2" -> {
                state.shipCalibrationPath = 2;
                System.out.println("""
                    
                    [PATH 2]: You take the human security protocols completely off the network, 
                    giving free rein to the flowing crystal matrix. Earth code is fully subordinated.
                    The bridge glows instantly in a blinding, brilliant light. The hull hums full of wild, 
                    untamed energy. But all warning displays shift to three-dimensional Minbari light glyphs!
                    SHA'IN: (worried) 'It breathes... but the displays are a total riddle for human eyes!'
                    """);
            }
            case "3" -> {
                state.shipCalibrationPath = 3;
                state.constructorRescued = true; // Safely sets your newly added validation flag!
                System.out.println("""
                    
                    [PATH 3]: You use your extreme technological understanding, recognize the mathematical 
                    connection pattern, and write a hybrid translation protocol.
                    The matte amber breaks. A deep, powerful silver-blue floods the bridge. A gentle, 
                    mighty vibration grid runs harmoniously through the bulkheads. Human code and Minbari 
                    matrix merge into a perfect unit.
                    SHA'IN: (tears in her eyes) 'Valen be praised, it flies out of its own power. 
                             We completed my father's life's work.'
                    """);
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your standard input fails to bridge the gap. The matrix defaults to 
                    rigid baseline emergency procedures. The ship stutters heavily as it boots up.
                    """);
                state.shipCalibrationPath = 1;
            }
        }

        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 6b: THE COMPILER STRIKE TO BABYLON 5
            INT. EAS LIBURNIA - COMMAND DECK (CONTINUOUS)
            --------------------------------------------------------------------------------
            
            The engines thunder deeply. The long-range subspace relay builds a direct, heavily 
            encrypted line to Babylon 5. The hologram of Captain Elizabeth Lochley flickers on.
            
            LOCHLEY (Hologram)
            "Commander! We receive your ID. Report! Do you have the constructor?"
            
            COMMANDER
            "Sha'In is safe, Captain. And the prototype is fully operational. We hear nothing 
             but a murderous dead silence on the Earth frequencies out here."
            
            LOCHLEY (Hologram)
            "The situation escalated dramatically. Geneva remains silent. The Psi-Corps took control. 
             President Sheridan just called the Alliance Council on Minbar. Set course for the 
             Minbari sector immediately! The President expects you there personally in the council chamber!"
            
            The hologram cuts off. Sha'In looks at the Commander, pushing the throttle forward.
            
            SHA'IN
            "Start codes for Minbar space are loaded, Commander. We skip Babylon 5. 
             The engines are ready for the first real jump!"
            
            The Liburnia breaks out of Sektor 14, shooting directly into the gold-red vortex!
            
            [PRESS ENTER FOR SCENE 7]
            """);
        scanner.nextLine();
    }
}
