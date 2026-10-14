import java.util.Scanner;

public class Scene32Epilogue {

    /**
     * Executes the true cinematic epilogue of the campaign.
     * Contains President Sheridan's subspace message and the final hyperspace jump sequence.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 32: EPILOGUE – THE SUB-SPACE FREQUENCY FROM TUZANOR
            INT. EAS LIBURNIA - COMMAND DECK / EARTH ORBIT - AFTERMATH
            --------------------------------------------------------------------------------
            
            A quiet, respectful calm settles over the bridge of the Liburnia. The smoke over 
            Geneva is clearing, and the global network has stabilized. Suddenly, the primary 
            sub-space frequency chimes, building a secure link from Minbar.
            
            The lifelike hologram of PRESIDENT JOHN SHERIDAN appears in the center of the deck. 
            He wears his modest, dark civilian robes. He looks deeply weary from the galactic crisis, 
            but a profound, relieved smile spreads across his face as he looks at you.
            
            SHERIDAN (Hologram):
            "I have just received the official tactical logs about the neutralization of the Psi-Corps 
             headquarters, Commander. You and your crew have rendered an indescribably great service 
             to the Interstellar Alliance. Government-loyal forces on Earth have immediately gained 
             the upper hand, and the provisional government has instantly ordered the complete 
             dissolution of the Corps. All collaborators are under arrest.
             
             Even if the public will never know of your covert mission, and even if your share in this 
             success will remain hidden in our deepest archives... so bin ich mir ziemlich sicher, 
             dass Marcus besonders stolz auf Sie wäre. Auf Sie alle. Thank you, Commander. 
             Come home. Sheridan out."
            """);

        // Simple switch checkpoint to give a neat little text flavor based on crew survival
        String crewFate = (state.locationMap.get("NARN").isVisited() || state.areNarnMercenariesHired) ? "CREW_INTACT" : "CREW_SCARRED";

        switch (crewFate) {
            case "CREW_INTACT" -> System.out.println("""
                [ALLIANCE TRIUMPH]: Sha'In, Karel, and Meldor stand around the console, 
                nodding in deep, silent respect. Your crew survived the trial of the Shadows.
                """);
            default -> System.out.println("""
                [CREW SCARRED]: The empty station of Moka reminds you of the high price 
                that was paid in the lower corridors of Geneva to secure this tomorrow.
                """);
        }

        System.out.println("""
            --------------------------------------------------------------------------------
            THE CINEMATIC CINEMASCOPE SHOT
            EXT. DEEP SPACE - UPPER ATMOSPHERE OF EARTH - CONTINUOUS
            --------------------------------------------------------------------------------
            
            The final viewport camera drifts slowly out of the EAS Liburnia, pulling back into 
            the majestic, silent infinity of deep space. 
            
            The camera locks into a sharp, beautiful cinemascope focus. The uninjured, massive 
            heavy cruisers of the Interstellar Alliance—Minbari Sharlin warleaders, Narn G'Quan cruisers, 
            and Earthforce destroyers—lock into perfect formation all around your hull, forming a 
            triumphant escort network.
            
            Right ahead of the fleet, a colossal, glowing crimson-gold jump gate opens up in space, 
            its swirling tachyon vortex illuminating the dark hulls with brilliant energy.
            
            The Liburnia's hybrid engines roar to life in a powerful, silver-blue arc. Together, 
            in a grand, synchronous surge of power, the entire fleet dives forward into the swirling 
            vortex... leaving the cradle of humanity safe in the starlight behind them.
            
            === FADE TO WHITE - END OF THE SHADOWS WITHIN ===
            
            [PRESS ENTER TO SHUT DOWN THE ENGINE TERMINAL]
            """);
        scanner.nextLine();
    }
}