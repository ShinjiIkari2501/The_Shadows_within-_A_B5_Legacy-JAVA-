import java.util.Scanner;

public class Scene4Negotiation {

    /**
     * Executes Scene 4: The Negotiation of the Alliance, utilizing a clean switch-case
     * block to evaluate the contract decisions in Lochley's office.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 4: THE NEGOTIATION OF THE ALLIANCE
            INT. CAPTAIN'S OFFICE - CONTINUOUS
            --------------------------------------------------------------------------------
            
            The heavy blast doors slide shut. Captain Lochley fixes the Commander with an 
            unyielding stare. A fragmentary, red-stamped Earthforce military file lies on her desk.
            
            LOCHLEY
            "Let's skip the diplomatic protocol. The subspace channels to Earth are pure 
             static ash. And right before this blackout, you throw an unbreakable alien 
             crystal onto my security chief's desk. Your file is a ghost story. 
             Who are you, and why did that Ranger pick you in the bowels of the station?"
            
            COMMANDER
            (cold, unmoved)
            "The Ranger died at my feet. I don't know what he wanted. But as he bled out, 
             he reminded me of someone. Someone who threw his life away for a uniform 
             I never understood. I brought the crystal to settle a debt of memory. 
             That is all the concessions you get, Captain."
            
            Zack Allan steps forward from the background, a deep recognition in his eyes.
            
            ZACK ALLAN
            "Captain... the fragments in the file. They match the sector logs from before 
             the Shadow War. Our Commander here used to run covert operations with Marcus Cole. 
             Long before Marcus ever joined the Anla'shok. The Ranger knew exactly who he was 
             looking for in the Brown Sector."
            
            Lochley's expression turns deadly serious.
            
            LOCHLEY
            "Marcus Cole... If he registered your name in the Ranger network before his death, 
             he knew you would fulfill the duty. You might not care about the Alliance, 
             but Earth is blind. President Sheridan has made provisions for this exact case: 
             Deep in Pirate Sector 14 lies a hidden prototype cruiser, an Earth-Minbari hybrid: 
             the LIBURNIA. But our master constructor, Sha'In, was just kidnapped by Raiders. 
             Secure the ship. Bring the constructor and the Liburnia home."
            
            🔀 INTERACTIVE WEGGABELUNG 2: THE ALLIANCE CONTRACT
            1 = PATH 1 [Demand conditions based on your hidden file or routes]
            2 = PATH 2 [Honor the legacy of your fallen comrade Marcus Cole]
            """);

        System.out.print("Your choice: ");
        String contractChoice = scanner.nextLine().strip();

        // CLEAN AND MODERN SWITCH CONTROL CONVERTED ONCE AND FOR ALL
        switch (contractChoice) {
            case "1" -> {
                state.relationships.put("Lochley_B5", state.relationships.get("Lochley_B5") + 20);
                System.out.println("""
                    
                    [CONSEQUENCE]: Lochley grinds her teeth but agrees to your demands. 
                    Your personal files and trade vectors are heavily classified for now. 
                    You successfully gained valuable diplomatic leverage.
                    """);
            }
            case "2" -> {
                state.relationships.put("Ivanova_Earthfleet", state.relationships.get("Ivanova_Earthfleet") + 25);
                System.out.println("""
                    
                    [CONSEQUENCE]: Zack Allan lowers his head with deep, silent respect. 
                    You accept the dangerous mission unconditionally to honor the memory 
                    of your fallen brother. The old Ranger bond is re-ignited.
                    """);
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your lack of commitment pushes the command staff to the edge. 
                    Lochley forcefully signs the order, warning you that Earthforce will not 
                    tolerate failure out in Sektor 14.
                    """);
                state.relationships.put("Lochley_B5", state.relationships.get("Lochley_B5") - 10);
            }
        }

        System.out.println("""
            
            [SYSTEM]: Act I finished. Course to Pirate Sector 14 is loading via hyperdrive relays...
            """);
        state.currentScreen = "ACT_II";
    }
}