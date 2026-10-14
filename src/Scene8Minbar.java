import java.util.Scanner;

public class Scene8Minbar {

    /**
     * Executes Scene 8: The Alliance Palace on Minbar.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 8: THE ALLIANCE PALACE ON MINBAR
            INT. MINBAR - ALLIANZPALAST - DAY
            --------------------------------------------------------------------------------
            
            The Liburnia goes into a stable orbit around the homeworld of the Minbari. After 
            landing on the white crystal platforms, the Commander, along with Sha'In, is escorted 
            by a guard of young, silent Ranger Cadets through the monumental, light-flooded 
            corridors of the Alliance Palace directly before the central podium.
            
            PRESIDENT JOHN SHERIDAN awaits them already. The exhaustion of the last few days 
            is written deeply into the face of the leader of the Alliance. The conversation 
            begins with icy, military urgency.
            
            SHERIDAN
            "Listen to me carefully, Commander. This is a pure phantom operation. No Alliance flags, 
             no official support, no assistance. If you are caught out there, the Interstellar 
             Alliance will deny any connection to you. That's why I can't send any of my Rangers 
             with you—nothing, absolutely nothing about this mission must point to us. You are on 
             your own. Interplanetary Expeditions (IPX) suppressed secret findings years ago—reports 
             about a dead, unmapped system near the old Shadow borderlands. The Corps has interfered 
             in these excavations; they are looking for something there for their own interests. 
             Fly disguised down there. Remain undetected and bring us the data from the ruins. 
             Good luck, Commander."
            
            In the middle of Sheridan's explanations, the light on the massive crystal walls flickers 
            unsteadily. Out of absolute nothingness, MELDOR materializes in the hall. His long, heavy 
            staff taps dully on the white marble, his hood pulled deep into his face. The Ranger 
            Cadets instinctively reach for their fighting staffs, but Sheridan lifts a calming hand.
            
            MELDOR
            (his voice echoes mystically and quietly through the high hall)
            "The Psi-Corps is searching that dead world for the dark relics of the past. They are 
             using the abandoned system for their paranoia. But they are not alone. The old servants 
             of the Shadows are stirring in hiding, out of pure self-interest and revenge for their 
             banished masters. They are after a fundamental power, and strangely enough, traces of 
             missing brothers of my order can also be found there. In this coming darkness, isolation 
             is certain death. The Alliance requires the crypto-analytical knowledge of my order to 
             break the ciphers of the Corps—just as we require the strength of your fleets to 
             fathom the fate of our vanished brothers. Mutual aid is the only vector we have left."
            
            Sheridan nods deeply impressed and hands the Commander the encrypted IPX dossier.
            
            SHERIDAN
            "Bring us the data from the ruins. Good luck, Commander."
            
            --------------------------------------------------------------------------------
            EXT. ALLIANZPALAST - EXIT - SHORTLY AFTER
            --------------------------------------------------------------------------------
            
            The Commander leaves the majestic building of the Alliance Palace in the direction of 
            the hangars. But still on the steps of the exit, DELENN takes him quietly aside. Her 
            voice is calm, gentle, but filled with a real, emotional warmth. She blickt around briefly, 
            ensures that the guards are out of earshot, and unnoticed presses a cold, highly encrypted 
            data crystal into the Commander's hand.
            
            DELENN
            (looks at the Commander with deep, knowing eyes)
            "Dark times are ahead of us, Commander... and the brightest light is found where connection 
             exists. I share your loss, as many friends do. Perhaps you should talk to them. On this 
             crystal you will find the current intelligence data and the unregistered routes to the 
             places where you can search undercover for allies. The future of the Alliance lies in 
             your hands... May Valen guide your steps."
            
            The Commander pauses for a moment. He feels the weight of the crystal in his fist. His 
            unapproachable mask remains rigid, but he nods gratefully to her and strides determinedly 
            forward to the waiting Liburnia.
            
            [PRESS ENTER FOR SCENE 9]
            """);
        state.hasDelennsDataCrystal = true;
        scanner.nextLine();
    }
}
