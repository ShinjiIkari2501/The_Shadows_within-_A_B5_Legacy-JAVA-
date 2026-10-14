import java.util.Scanner;

public class Scene16Centauri {

    /**
     * Executes the diplomatic encounter on Centauri Prime.
     * Utilizes a clean switch statement to process Londo Mollari's ultimatum.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 16-B: THE NET OF THE SPIDER
            INT. CENTAURI PRIME - IMPERIAL THRONE ROOM - DAY
            --------------------------------------------------------------------------------
            
            The Liburnia touches down on the grand landing platforms of Centauri Prime. 
            You are escorted into the high, echoing Imperial Throne Room. 
            
            EMPEROR LONDO MOLLARI sits on his heavy throne, his eyes narrow, filled with the 
            weariness of a man carrying chains he cannot show. He looks at you with cold, 
            calculated etiquette.
            
            LONDO MOLLARI:
            "Ah, the Alliance emissary... Sheridan sends you to beg for my royal fleet, yes? 
             Earthforce is fractured, Bester is playing with forces he cannot comprehend. 
             I will give you my heaviest battle cruisers to shatter the Black Omega lines. 
             But... the Centauri Republic expects a return on its investment. I demand 
             exclusive, absolute colonial authority over the Narn sectors once this war is over. 
             Sign the military pact, or leave my palace empty-handed."
            
            🔀 INTERACTIVE WEGGABELUNG 9-B: THE PALACE ULTRA-PAKT
            1 = Choice 1 [Accept Londo's aggressive military pact - Sacrifice Narn sovereignty]
            2 = Choice 2 [Reject Londo and look for alternative paths inside the courts]
            """);

        System.out.print("Your diplomatic choice: ");
        String choice = scanner.nextLine().strip();

        switch (choice) {
            case "1" -> {
                state.relationships.put("Ivanova_Earthfleet", state.relationships.get("Ivanova_Earthfleet") - 20);
                state.drakhInfluence += 25; // Rises significantly, angering the Narn later
                state.besterThreatLevel += 15;
                System.out.println("""
                    
                    [CONSEQUENCE - THE LONDO PACT]: 
                    You pick up the electronic stylus and sign the imperial treaty. 
                    Londo smiles grimly, nodding as heavy cruisers are assigned to your vector. 
                    But the shadow of the Drakh over the Centauri throne intensifies.
                    """);
            }
            case "2" -> {
                state.drakhInfluence -= 30; // Drakh influence drops as you refuse the trap
                System.out.println("""
                    
                    [CONSEQUENCE - THE COVETED EVASION]: 
                    You refuse the ultimatum, turning your back on the Emperor. Londo's face turns 
                    into a mask of pure fury as he waves his guards to dismiss you from the hall.
                    
                    In the shadows of the marble corridors, VIR COTTO intercepts you, sweating but determined.
                    
                    VIR COTTO:
                    "Commander! Please, listen to me... Londo is not himself. The courts are blinded. 
                     I cannot give you the main fleet, but I have unlocked a secret, unregistered 
                     humanitarian rescue fleet through the Ranger channels. Use it to evacuate the 
                     civilians when the drop begins. It's all I can do."
                    """);
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your hesitation offends the court. Londo slams his fist on the armrest, 
                    refusing any official support. You are escorted back to the hangar empty-handed.
                    """);
                state.drakhInfluence += 10;
            }
        }

        System.out.println("\n[SYSTEM]: Centauri Prime operations completed. Hyperspace coordinates active.");
        System.out.println("[PRESS ENTER TO RETURN TO TRANSIT ENGINE]");
        scanner.nextLine();
    }
}