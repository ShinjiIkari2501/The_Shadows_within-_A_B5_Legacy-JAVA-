import java.util.Scanner;

public class Scene13Draal {

    /**
     * Executes Scene 13: Draal's Metaphors, using a clean switch block
     * to evaluate the critical alignment history of the Commander.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 13: DRAAL'S METAPHORS
            INT. EPSILON III - THE CENTRAL CORE - CONTINUOUS
            --------------------------------------------------------------------------------
            
            You reach a gewaltige, floating platform surrounded by a network of gleaming 
            energy cascades. In the center stands the main control matrix of the Great Machine.
            
            DRAAL steps forward from the shimmering light. His robes wave in the energetic 
            wind of the generators, his eyes glowing with the unearthly power of a man whose 
            nervous system is fully fused with an entire planet. Zathras flits immediately 
            to a console in the background, murmuring quietly and tugging at a stuck wire 
            with a heavy wrench.
            
            DRAAL
            (with a voice that echoes like thunder in the walls)
            "Greetings, traveler. The Machine felt your heartbeat in hyperspace. It felt the 
             burning plasma of your wounds. You bring questions born in the darkness of the homeworld."
            
            COMMANDER
            "We must break the Earth's signal free, Draal. The conventional communication is 
             completely blocked. We hope to establish a stable subspace connection via the 
             unimaginable energy of this facility."
            
            DRAAL
            (nods solemnly)
            "Bester... A small mind who believes he can stop the flow of time with iron gates. 
             Zathras! Activate the Tachyon Injector! We will give a voice to this silent cage!"
            
            Zathras jumps onto a large lever, ripping it down with his full body weight.
            
            ZATHRAS
            "Zathras makes! Machine breathes now! Big signal for little humans!"
            
            An ear-splitting hum takes over the room. The blue veins on the walls flare up 
            in a gleaming violet. A massive beam of energy shoots up from the planet's core, 
            straight through subspace towards Earth. 
            
            The connection stands. Draal steps closer to the Commander. The light of the 
            generators dims, and a sakrale, eerie calm settles over the platform. His eyes 
            fixate on your soul. He speaks with those cryptic, vague metaphors:
            """);

        // EVALUATE MORAL HISTORY VIA SWITCH EXPRESSION (CRITICAL LOG-CHECK)
        String moralPath = (state.alignmentScore >= 50) ? "LIGHT_LOYAL" : "DARK_RUTHLESS";

        switch (moralPath) {
            case "LIGHT_LOYAL" -> System.out.println("""
                [CRITICAL LOG-CHECK - PATH OF LIGHT]: Draal places a heavy, cool hand on your 
                uninjured shoulder. His voice is a whispering murmur.
                
                DRAAL: "The Machine sings of patterns that align, Commander. You gather the shards 
                       of a broken mirror, believing you can see the whole in it. A noble but arduous 
                       path. Yet, I see a flickering in your future... Beware of the chamber where 
                       the echo of old betrayal sleeps. When you reach out in the red sand to break 
                       the chains, make sure you do not become the smith's tool. For some gates 
                       open only to lock you in deeper. When the deception is perfect, the heart 
                       will save you—or break you."
                """);

            case "DARK_RUTHLESS" -> System.out.println("""
                [CRITICAL LOG-CHECK - PATH OF VENGEANCE]: The lights of the Great Machine flicker 
                in the threatening rhythm of his words. Draal steps back, his gaze full of icy severity.
                
                DRAAL: "The river divides, traveler, and you are already drawing your blade through 
                       the water. You believe you are moving forward, but you are only following the 
                       bloody slope of your own deeds. A throne... a throne is only ever as high 
                       as the ashes upon which it was built. If the hunger for control guides your 
                       mind, you will rule the worldwide net... but the net will erase your own 
                       traces in the dust. In the end, a king sits in an absolutely empty room, 
                       ruling over nothing but the great, eternal silence."
                """);

            default -> System.out.println("\n[SYSTEM]: The core frequency hums indifferently.");
        }

        System.out.println("""
            
            Before the Commander can answer, the sheer energy of the machine tears them back 
            to reality. A holographic terminal on the platform flickers wildly. The energy waves 
            break through the blockade. The signal from Earth finally bursts through with brutal clarity!
            
            [PRESS ENTER FOR SCENE 14]
            """);
        state.greatMachineEnergy = 100; // Unlocks max energy for the network relay
        scanner.nextLine();
    }
}