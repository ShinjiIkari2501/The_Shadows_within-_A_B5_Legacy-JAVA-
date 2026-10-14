import java.util.Scanner;

public class Scene23Mars {

    /**
     * Executes Scene 23: The Mars Coup, utilizing a clean switch-case block
     * to evaluate background benefits and triggers the permanent Babylon 5 lockdown.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 23: THE MARS COUP
            INT. MARS - THARSIS CRATER - EDGARS INDUSTRIES HIDDEN HANGAR - NIGHT
            --------------------------------------------------------------------------------
            
            The Liburnia materializes inside a massive, unmapped hangar deep within the crimson 
            rock of the Tharsis volcanic crater. The air is cold, smelling of rust and heavy grease.
            
            MICHAEL GARIBALDI sits at a long workbench covered in dismantled plasma rifles and 
            scrambler units. A fat, unlit cigar rests firmly in his mouth-corner as his sharp eyes 
            lock onto you. He smiles grimly, throwing a heavy data pad onto the metal table.
            
            GARIBALDI:
            "Good to see you alive, Commander. Zack told me you survived the Raider ambush. 
             Bester's black-ops network inside the Tharsis lab is heavily fortified. They are running 
             Section 13 protocols—the most paranoid encryption the Psi-Corps ever developed. 
             If we want to extract the sleeper net code data, we need a clean breach. 
             Tell me, what's your plan to crack their outer defense wall?"
            """);

        // MODERN SWITCH CONTROL BLOCK EVALUATING BACKGROUND-SPECIFIC INFILTRATION
        switch (state.characterOrigin) {
            case "Intelligence" -> {
                System.out.println("""
                    [INTELLIGENCE ADVANTAGE - BLUE CODES]: 
                    You step forward, typing an old, classified military decryption matrix into 
                    Garibaldi's console. His eyes widen in genuine surprise.
                    
                    COMMANDER:
                    "We use the old Black Watch backdoors, Michael. Bester's technicians updated 
                     the hardware, but they left the old intelligence firewalls untouched."
                     
                    GARIBALDI: (laughs dryly, biting his cigar)
                    "Ha! Beautiful! The bureaucratic arrogance of the Corps is our best asset. 
                     The outer defensive grids are falling like dominos. You saved us a massive fire fight."
                    """);
                state.analysisFocus += 5; // Direct attribute bonus for hacking precision
            }
            case "Underworld" -> {
                System.out.println("""
                    [UNDERWORLD ADVANTAGE - LOGISTIC BRIDGING]: 
                    You unfold a dynamic cargo manifest, outlining a smuggled shipment of illegal 
                    neural dampers that you routed directly into the lab's security barracks.
                    
                    COMMANDER:
                    "I paid off the local supply contractors, Michael. The guards in Sector 4 
                     are currently dealing with a massive logistics chaos in their inventory. 
                     The guard shifts are heavily delayed."
                     
                    GARIBALDI: (grins, nodding with respect)
                    "You sneaky smuggler bastard! You blinded their security shifts before we even 
                     pulled our weapons. That makes the approach three times faster."
                    """);
                state.credits -= 2000; // Small expenses for the supply manipulation
            }
            default -> System.out.println("""
                [BASELINE ATTACK]: You opt for a standard, direct tactical breach of the 
                perimeter networks. Garibaldi checks his rifle, prepared for heavy data friction.
                """);
        }

        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 24: THE COUPE AND THE LOCKDOWN
            INT. MARS - THARSIS CRATER LAB - HOURS LATER
            --------------------------------------------------------------------------------
            
            The infiltration is a complete tactical success! With Garibaldi covering your back, 
            you crack the central vault computer. The raw Section 13 files flood the Liburnia's core. 
            
            But as the data bars hit 100%, the main screen flashes in panicked red. 
            Talia Winters' holding cell inside the lab is empty—her physical body has already 
            been transported away to a terrifying, unknown destination.
            
            GARIBALDI: (slamming his fist onto the console)
            "Damn it! Bester knew we were close! He evacuated Talia to Earth... She is the primary 
             biological switching unit for the entire global sleeper network! But wait... look at 
             the decryption progress..."
            
            [SYSTEM ANALYSIS]: Decryption parameters fully completed. Progress: 999.
            [UNLOCKED]: Vektor 8 (Planet Earth - Geneva Approach) is now available in your navigation hub.
            
            Suddenly, a deafening sub-space alarm shrieks through the hangar. Sha'In stumbles onto the deck.
            
            SHA'IN:
            "Commander! The long-range relays just logged a priority emergency update from Zack! 
             Bester has discovered the Mars breach! In a blind, paranoid rage, he has ordered 
             three heavy Omega Destroyers to completely block the Epsilon system! Babylon 5 is under 
             permanent orbital arrest! Returning is absolutely impossible!"
            
            GARIBALDI: (takes the cigar out of his mouth, his face a grim mask of pure steel)
            "This is it, Commander. The Point of no Return. Bester has closed the gates behind us. 
             The only way out... is forward. We are setting course for Earth. We are going to 
             initiate a stratospheric dive over Geneva and bring this bastard down!"
            
            [SYSTEM]: Babylon 5 sector is now permanently LOCKED. 
            [PRESS ENTER TO RETURN TO STRATEGIC HUB]
            """);

        // POINT OF NO RETURN LOGIC TRIGGERED DIRECTLY INSIDE THE SWITCH ECOSYSTEM
        state.controlDecryptionProgress = 999;
        state.locationMap.get("B5").setBlocked(true); // Permanent block active!
        scanner.nextLine();
    }
}