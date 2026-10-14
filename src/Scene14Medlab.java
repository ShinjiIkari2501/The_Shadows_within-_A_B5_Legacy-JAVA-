import java.util.Scanner;

public class Scene14Medlab {

    /**
     * Executes Scene 14: The Franklin Protocol and Delenn's encounter.
     * Restores player health and evaluates background profiles using a modern switch block.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 14: THE FRANKLIN PROTOCOL
            INT. BABYLON 5 - MEDLAB ONE - HOURS LATER
            --------------------------------------------------------------------------------
            
            The energy of the Great Machine has been rerouted directly into the secured 
            medical bays of the station. The Commander lies on a diagnostic table while 
            DR. SARAH CHAMBERS guides a hissing regeneration scanner over his burns. 
            The cool, bluish light closes the scorched skin in a matter of seconds. 
            
            [SYSTEM]: Your health points have been fully restored!
            """);

        state.playerHP = 100; // Full recovery triggered dynamically

        System.out.println("""
            In the center of the room, the main projector displays a life-sized, razor-sharp 
            hologram. It is DR. STEPHEN FRANKLIN, broadcasting directly from the underground of Earth! 
            At his side in the Medlab stand CAPTAIN LOCHLEY, TESSA HOLLORAN (head of the IAA intelligence), 
            and DELENN.
            
            FRANKLIN (Hologram)
            "Thank God, the connection holds! I don't know what energy source you tapped into, 
             but it stands up to Bester's broadband jammers. Listen to me carefully: Bester hasn't 
             just sealed Earth politically. He is using a modified variant of the Drakh plague—
             a biomechanical tech-cross—to pull up a worldwide, unhackable sleeper network via 
             the telepaths! He is experimenting in secret on kidnapped Technomages to abuse their 
             implants as biological relay stations!"
            
            The raw data floods the Medlab terminal. The Technomage Meldor steps forward. 
            His fingers fly over the cybernetic console. Thanks to his crypto-analytical 
            skills, he deciphers the deeper layers of the Ranger crystal, bringing the secret 
            update about Bester's Section 13 experiments to light.
            
            MELDOR
            "The data tapes speak of a 'primary biological switching unit' in the hangar... 
             They are using someone to stabilize the entire worldwide network. The fate of 
             my kidnapped brothers leads directly there."
            
            Suddenly, a highly encrypted dossier buzzes over the B5 channel. A voice recording 
            from MICHAEL GARIBALDI breaks through.
            
            GARIBALDI (Audio-Feed)
            "Lochley, forward this to the Commander immediately. I received confirmation via 
             the industrial espionage channels of Edgars Industries: Bester has built a strictly 
             secret research station right inside the Tharsis volcanic crater on Mars. I've 
             attached the original infiltration codes. My corporation has also unlocked a covert, 
             unregistered hangar in the Mars system for the Liburnia. Use it as a safe base. 
             Find out what they are doing there."
            
            The hologram fades out. The coordinates to the alien worlds and the Mars base lie 
            open before them. Everyone leaves the Medlab to prepare the mission. Only Delenn 
            remains behind at the Commander's bedside. She looks at him with infinitely gentle 
            but piercing wisdom.
            """);

        // CLEAN AND MODERN SWITCH EXPRESSION INSTEAD OF MESSY IF-ELSE
        switch (state.characterOrigin) {
            case "Intelligence" -> System.out.println("""
                DELENN
                "You look at the blueprint of this war, Commander, and you see only numbers and grids. 
                 But Marcus did not see the universe as an equation. He saw it as a family worth 
                 sacrificing everything for. I know what he meant to you as a partner in the shadow days. 
                 Do not let his light fade into the database."
                """);

            case "Underworld" -> System.out.println("""
                DELENN
                "You pretend you only care about the Credits and the freedom of your cargo routes. 
                 But Marcus knew the real person behind that smuggler mask. He trusted you with his life, 
                 and he registered your name because he knew your core is honorable. Settle the debt 
                 of memory, my friend."
                """);

            default -> System.out.println("""
                DELENN
                "We share this loss, Commander. The Anla'shok carry a heavy burden, but we are 
                 never truly alone as long as the memory of the fallen guides our hand."
                """);
        }

        System.out.println("""
            DELENN
            "The Rangers stand ready, Commander. But the Psi-Corps has Earth in a stranglehold. 
             To win this war, we must assemble the pieces of the old alliance. Travel to the 
             alien worlds. Bring us the fleets of the Narn and the Centauri!"
            
            TESSA HOLLORAN
            "The Liburnia is fully fueled and operational, Commander. The tactical mission center 
             in the hub is unlocked. Select your route. The future of Earth begins now."
            
            [SYSTEM]: Act III Core Hub unlocked. Navigation vectors available.
            [PRESS ENTER TO CLOSE MEDLAB MODULE]
            """);
        scanner.nextLine();
    }
}
