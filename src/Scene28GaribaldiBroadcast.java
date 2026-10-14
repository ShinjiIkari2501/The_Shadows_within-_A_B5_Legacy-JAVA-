import java.util.Scanner;

public class Scene28GaribaldiBroadcast {

    /**
     * Executes Scene 28: Garibaldi's Global Subspace Broadcast.
     * Utilizes a clean switch statement to modify the broadcast dynamics based on player origin.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 28: GARIBALDI'S GLOBAL SUBSPACE BROADCAST
            INT. REBEL FLAGSHIP - TRANSMISSION DECK / GLOBAL EARTH NETWORK - NIGHT
            --------------------------------------------------------------------------------
            
            While the Liburnia dives through the burning lower atmosphere, Michael Garibaldi 
            secures his breach into the primary ISN propaganda relay station over the Geneva grid. 
            The screens on the Liburnia's bridge flicker wildly, the sterile face of the 
            Psi-Corps news anchor dissolving into heavy static snow.
            
            Suddenly, Garibaldi's lined, unyielding face cuts through the worldwide broadcast network. 
            He takes the unlit cigar out of his mouth, leans straight into the camera lens, and 
            his dry, biting voice echoes from every single viewscreen, public terminal, and comm-link 
            across the surface of Planet Earth.
            
            GARIBALDI (Global Broadcast):
            "People of Earth, listen to me very carefully. I'm not some voice from a rogue resistance 
             cell, and I'm not here to negotiate. My name is Michael Garibaldi, former Chief of 
             Security on Babylon 5. For months, Alfred Bester and his synthetic net have lied to you. 
             They told you the Interstellar Alliance wants to consume your sectors. They told you 
             the curfew was for your own safety. It's a lie. A massive, bureaucratic lie."
            
            He slams a heavy data cartridge directly into the broadcast deck, projecting the stolen 
            Mars Section 13 files across the worldwide telemedia channels.
            
            GARIBALDI (Global Broadcast):
            "Right now, Bester is holding hundreds of innocent people—both mundanes and telepaths—
             inside a biological research network beneath Geneva. He is frying the brains of your 
             own children to secure his personal grip on power. We have the logs. We have the data. 
             To all Earthforce military units still taking orders from the Corps: stand down. 
             Your government has been blinded. Look at the screens. Look at the truth!"
            
            [PROCESSING INFILTRATION CONVERGENCE VIA SWITCH...]
            """);

        // MODERN SWITCH PATTERN HANDLING BROADCAST IMMERSION
        switch (state.characterOrigin) {
            case "Intelligence" -> {
                System.out.println("""
                    [INTELLIGENCE FEED INTENSIFIED]: 
                    Because you are an Ex-Agent, Garibaldi's data feed utilizes old, embedded 
                    Black Watch encryption frequencies. The broadcast bypasses the local tactical 
                    jammers twice as fast. Ground forces of the Psi-Corps panic as their internal 
                    rosters and hidden asset listings are exposed to the public!
                    
                    SHA'IN: 'The defensive network around the central dome is losing its coordination! 
                             Their tactical guards are abandoning their posts in confusion!'
                    """);
                state.besterThreatLevel -= 15; // Drastically drops the threat score
            }
            case "Underworld" -> {
                System.out.println("""
                    [UNDERWORLD NETWORK TRIGGERED]: 
                    Because you are a Smuggler, Garibaldi uses old pirate sub-relays and black-market 
                    frequencies to distribute the feed. The resistance groups inside the Greater Paris 
                    and Geneva sectors rise up immediately, cutting the power lines of the primary 
                    automated laser turrets outside the headquarters!
                    
                    KAREL: 'The local ground defense turrets are shutting down! The resistance cells 
                            are hitting them hard in the streets!'
                    """);
                state.credits += 5000; // Leftover resource retrieval simulation
            }
            default -> {
                System.out.println("""
                    [BASELINE BROADCAST]: The signal broadcasts via standard Ranger relays. 
                    The transmission is powerful, but local Psi jammers cause temporary signal 
                    degradation across the southern hemisphere before the network fully collapses.
                    """);
                state.besterThreatLevel -= 5;
            }
        }

        System.out.println("""
            
            The global broadcast triggers an instant psychological shockwave across the planet. 
            The security grids around the central biocrystalline dome begin to drop one by one. 
            The Liburnia's combat sensors lock onto the main target vector.
            
            [PRESS ENTER FOR SCENE 29]
            """);
        scanner.nextLine();
    }
}