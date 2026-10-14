import java.util.Scanner;

public class Scene12Epsilon {

    /**
     * Executes Scene 12: The Lower Levels of Epsilon III, utilizing a clean
     * switch statement to handle environmental reactions.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 12: THE LOWER LEVELS OF Epsilon III
            INT. EPSILON III - THE GREAT MACHINE - CONTINUOUS
            --------------------------------------------------------------------------------
            
            The transport pod docks with a dump, metallic echo at a gigantic, subterranean 
            airlock. As the heavy doors slide back, an overwhelming view reveals itself.
            
            The interior of the planet is no cave made of stone—it is an endless, miles-deep 
            canyon of breathing, pulsating technology. Giant, bronze gears, as large as 
            skyscrapers, mesh silently into each other. Biocrystalline energy lines traverse 
            the titanic struts like glowing blue veins. A deep, seismic bass vibration lies in the air.
            
            Out of the dense steam of the hydraulic lines, a small, fur-clothed figure stumbles 
            forward. He wears a clunky welder's goggle on his forehead, tugs at a heavy copper 
            cable and murmurs wildly to himself. It is ZATHRAS.
            
            ZATHRAS
            (shakes his head in panic, looks at the Commander)
            "No, no, no! Zathras said, first the primary coupling, then the guests! But nobody 
             listens to Zathras. Zathras is only Zathras. Zathras cleans the filters, Zathras 
             patches the wires... He is the One who was saved? Or the One who has yet to go? 
             Zathras mixes everything up. Too much time, too little Zathras!"
            
            COMMANDER
            "Zathras. Bring us to Draal. Time is pressing."
            
            ZATHRAS
            (startled, scratches his ear)
            "Yes, yes! Draal waits. The signal waits too. Machine is hungry for connection. 
             Come, come! Touch nothing, otherwise Zathras will have to clean the switches again 
             for days!"
            """);

        // Convert origin to switch logic for a quick immersion text flavor check
        switch (state.characterOrigin) {
            case "Intelligence" -> System.out.println("""
                [SYSTEM]: Your tactical visor processes the thermal layout of the moving gears.
                The structural scale of the ancient technology is mathematically incomprehensible.
                """);
            case "Underworld" -> System.out.println("""
                [SYSTEM]: Your smuggling senses alert you that a single piece of this ancient bronze 
                machinery could buy an entire shipping cartel in the Outer Rim.
                """);
            default -> System.out.println("\n[SYSTEM]: The massive hum of Epsilon III vibrates in your teeth.");
        }

        System.out.println("""
            
            Zathras flits with astonishing speed over a narrow, grid-like catwalk hanging over a 
            seemingly endless abyss of rotating generators. The Commander follows him deep into 
            the mechanical heart of the planet.
            
            [PRESS ENTER FOR SCENE 13]
            """);
        scanner.nextLine();
    }
}