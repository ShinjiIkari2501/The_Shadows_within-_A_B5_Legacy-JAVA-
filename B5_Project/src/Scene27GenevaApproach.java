import java.util.Scanner;

public class Scene27GenevaApproach {

    /**
     * Executes Scene 27: The Geneva Stratospheric Approach.
     * Utilizes a high-performance switch block to determine shield stress and entry vectors.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 27: THE GENEVA STRATOSPHERIC APPROACH
            INT. EAS LIBURNIA - COMMAND DECK / EARTH ORBIT - NIGHT
            --------------------------------------------------------------------------------
            
            The viewscreen clears, revealing the breathtaking, sapphire-blue marble of Earth. 
            But the cradle of humanity is surrounded by an iron ring—the black, dagger-like 
            silhouettes of Earthforce destroyers loyal to Bester's regime are patrolled by elite 
            Black Omega starfighters.
            
            The subspace relays hum with wild energy. GENERAL SUSAN IVANOVA's face flares up 
            on the main tactical display from her flagship's bridge, her eyes burning with a lethal, 
            uncompromising intensity.
            
            IVANOVA (Holo-Feed):
            "All rebel units, this is General Ivanova. We have tracked Bester's primary transponder 
             signals down to the central biocrystalline dome in Geneva. The network is hot, and they 
             know we are here. There will be no elegant maneuvers, no tactical retreats. We are going 
             straight through their defensive line. Lock your shields, heat up your plasma arrays, 
             and push your throttles to the absolute wall. We are going home!"
            
            The entire rebel fleet ignites their fusion drives simultaneously, screaming forward 
            in a massive wave of fire. The Liburnia dives ahead, leading the vanguard. 
            
            SHA'IN
            (gripping her console as the atmospheric entry friction turns the viewport blood-red)
            "Thermal hull shields are melting, Commander! The friction is hitting critical levels, 
             and two Black Omega heavy interceptors are locking their plasma cannons onto our engine matrix! 
             We must choose our atmospheric entry angle immediately!"
            
            CHOOSE YOUR STRATEGIC STRATOSPHERIC ENTRY VECTOR:
            1 = Vector 1 [Aggressive dive: Maximum thrust to overpower the interceptors via raw speed]
            2 = Vector 2 [Evasive glide: Roll the ship into the thermal blind spots of the atmosphere]
            """);

        System.out.print("Your flight vector choice: ");
        String entryChoice = scanner.nextLine().strip();

        // REINE SWITCH-STEUERUNG FÜR DEN STRATOSPHÄREN-DIVE
        switch (entryChoice) {
            case "1" -> {
                System.out.println("""
                    
                    [VECTOR 1 - AGGRESSIVE DIVE]: You slam the primary hybrid throttles forward! 
                    The Liburnia's engines shriek in a terrifying mechanical roar. The ship punches 
                    through the atmospheric boundary like a burning meteor, easily outpacing the 
                    interceptors. However, the extreme, unmitigated friction overloads the primary 
                    shield generator, forcing raw heat into the crew compartments.
                    """);
                state.playerHP -= 15;
                state.alignmentScore -= 5; // Aggressive tactical path
                System.out.println("Damage Suffered: -15 HP. Current Health: " + state.playerHP + "/100");
            }
            case "2" -> {
                System.out.println("""
                    
                    [VECTOR 2 - EVASIVE GLIDE]: You execute a precise, calculated roll, hiding the 
                    Liburnia's heat signature inside the turbulent ionization waves of the upper atmosphere. 
                    The Black Omega starfighters lose their target lock in the radar static. 
                    The entry is smooth and cool, protecting the hull integrity perfectly.
                    """);
                state.analysisFocus += 5; // Tactical precision optimization
            }
            default -> {
                System.out.println("""
                    
                    [WARNING]: Your lack of direction causes the ship to tumble wildly in the thin air! 
                    The interceptors score a direct hit on your secondary thruster wing before Karel 
                    can manually stabilize the vector.
                    """);
                state.playerHP -= 20;
                System.out.println("Damage Suffered: -20 HP. Current Health: " + state.playerHP + "/100");
            }
        }

        System.out.println("""
            
            The dense clouds break apart with a deafening supersonic boom. Below you, through the 
            shattered gray clouds, the brennende silhouette of the Greater Geneva Sector and the 
            colossal, sparkling dome of the Psi-Corps Headquarters materialize out of the haze. 
            The final drop has officially begun.
            
            [PRESS ENTER FOR SCENE 28]
            """);
        scanner.nextLine();
    }
}