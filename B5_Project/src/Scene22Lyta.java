import java.util.Scanner;

public class Scene22Lyta {

    /**
     * Executes Scene 22: Lyta Alexander's Hideout.
     * Utilizes a high-performance switch block to process recruitment path results
     * based on the player's prior structural moral alignment.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 22: LYTA ALEXANDER'S HIDEOUT (THE LAST CROSSROAD)
            INT. SMUGGLER OUTPOST - ASTEROID BAR - NIGHT
            --------------------------------------------------------------------------------
            
            The tracking vectors lead you into a dark, smoky bar buried deep inside a hollow asteroid. 
            This is lawless space, far away from any Alliance jurisdiction. 
            
            LYTA ALEXANDER sits in a dimly lit corner, her hood pulled low over her face. As you 
            approach her table, her head snaps up. Her eyes flash with an unnatural, terrifying 
            Vorlon-blue light. Her voice hammers directly into your synapses via telepathy.
            
            LYTA (Mental Projection):
            "You want my power to tear down Bester's walls. But I do not care about your corporate 
             treaties or military alliances. I want retribution. I want to see this damned Corps burn. 
             Down to its very foundations!"
            
            [PROCESSING MORAL ALIGNMENT FOR RECRUITMENT...]
            """);

        // Convert continuous alignment limits into discrete categorical keys for the switch
        String alignmentPath;
        if (state.controlDecryptionProgress == 999 && state.alignmentScore >= 75) {
            alignmentPath = "PATH_OF_LIGHT";
        } else if (state.alignmentScore <= 40) {
            alignmentPath = "PATH_OF_REVENGE";
        } else {
            alignmentPath = "TOTAL_FAILURE";
        }

        // REINE SWITCH-STEUERUNG FÜR DIE ENTWICKLUNG DER KAMPAHNE
        switch (alignmentPath) {
            case "PATH_OF_LIGHT" -> {
                System.out.println("""
                    [RECRUITMENT SUCCESS - THE PATH OF LIGHT]: 
                    You slide the data pad containing the hard Section 13 Mars evidence across the table. 
                    You speak with genuine empathy, explaining Talia Winters' tragic fate as an innocent victim.
                    
                    COMMANDER:
                    "Talia Winters is no longer an asset of the Corps, Lyta. She is a victim. 
                     Bester forced her into a biological switching unit. If you blindly burn the 
                     headquarters to ash, you murder a sister in mind. We must destroy the network, 
                     not the people caught inside."
                     
                    Lyta's eyes widen. The Vorlon-blue flickers and breaks into a deep, human tear. 
                    The evidence shatters her blind hatred.
                    
                    LYTA: (with a trembling voice)
                    "They did... they did that to her? Oh my God... No. I will go with you, Commander. 
                     I will restrain my powers. We will save Talia and burn Bester's net without 
                     sacrificing the innocent."
                    """);
                state.lytaRecruited = true;
                System.out.println("\n[STATUS]: Lyta Alexander recruited on the Path of Light. Resonance-Ending 7 unlocked!");
            }

            case "PATH_OF_REVENGE" -> {
                System.out.println("""
                    [RECRUITMENT SUCCESS - THE PATH OF REVENGE]: 
                    You nod grimly, matching her burning anger. You embrace her radical campaign of destruction.
                    
                    COMMANDER:
                    "Bester started this war, Lyta. We will finish it by his own rules. 
                     The Corps will burn. Every single cell."
                     
                    Lyta smiles a dark, lethal smile. Her eyes ignite in absolute god-like light. 
                    She stands up and follows you back to the hangar, ready to completely pulverize the HQ. 
                    Talia's rescue slips completely into the background.
                    """);
                state.lytaRecruited = true;
                System.out.println("\n[STATUS]: Lyta Alexander recruited on the Path of Revenge. Alliance fixed to Vengeance.");
            }

            case "TOTAL_FAILURE" -> {
                System.out.println("""
                    [RECRUITMENT FAILED - INDECISIVE MORALITY]: 
                    You fail to hit the correct emotional chord, arguing with dry military metrics or 
                    contradictory ideals. Lyta stares at you with pure, icy contempt.
                    
                    LYTA:
                    "You are just as blind as the generals in Geneva. You only want to use me as 
                     a weapon for your little alliance. Get out of my sight!"
                     
                    She turns her back on you, dissolving into the shadowy crowds of the asteroid outpost. 
                    She refuses to step aboard. You will have to face the final battle completely without 
                    her terrifying Vorlon telepathic powers.
                    """);
                state.lytaRecruited = false;
                System.out.println("\n[STATUS]: Lyta Alexander refused your offer. Final risk factors increased.");
            }

            default -> System.out.println("\n[SYSTEM ERROR]: Neural feedback anomaly in telepathic link.");
        }

        System.out.println("\n[SYSTEM]: Operations in Lyta's Refuge completed. Navigational grid updating.");
        System.out.println("[PRESS ENTER TO JUMP BACK TO TRANSIT HUB]");
        scanner.nextLine();
    }
}