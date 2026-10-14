import java.util.Scanner;

public class Scene31FinalBattleConclusion {

    /**
     * Executes Scene 31: The Final Battle Timeline Evaluation.
     * Uses a precise switch block to calculate and output the unique story endings.
     */
    public static void execute(BabylonState state, Scanner scanner) {
        System.out.println("""
            --------------------------------------------------------------------------------
            SCENE 31: THE FINAL BATTLE – THE EVALUATION OF THE TIMELINE
            INT. PSI-CORPS HEADQUARTERS - MAIN MATRIX TERMINAL - AFTERMATH
            --------------------------------------------------------------------------------
            
            The screaming sirens are slowly dying down. The central neural server drops 
            its protective shields, and the stolen Section 13 Mars data streams are verified. 
            The quantum compiler of the Liburnia evaluates your structural footprint in the dust.
            
            [SYSTEM TIMELINE COMPILATION INBOUND...]
            """);

        // We convert the state flags into fixed string keys to feed our final switch block
        String calculatedEnding;
        if (state.lytaRecruited && state.controlDecryptionProgress == 999 && state.alignmentScore >= 75) {
            calculatedEnding = "ENDING_7_TRUE_KANON";
        }
        else if (state.controlDecryptionProgress == 999 && !state.lytaRecruited && state.relationships.get("Lochley_B5") >= 50) {
            calculatedEnding = "ENDING_1_DIPLOMATIC";
        }
        else if (state.characterOrigin.equalsIgnoreCase("Intelligence") && state.analysisFocus >= 80) {
            calculatedEnding = "ENDING_5_SHADOW_DIRECTOR";
        }
        else {
            calculatedEnding = "ENDING_6_GAME_OVER";
        }

        // HIGH-PERFORMANCE UNCOMPROMISING TIMELINE SWITCH
        switch (calculatedEnding) {
            case "ENDING_7_TRUE_KANON" -> System.out.println("""
                ================================================================================
                === ENDING 7: THE TELEPATH RESONANCE MASTERPIECE (TRUE KANON ENDING)         ===
                ================================================================================
                Talia Winters' dormant Ironheart heritage fully awakens to shield the sleeper minds! 
                Lyta Alexander channels her terrifying Vorlon power to completely burn Bester's künstliches Net. 
                The shadow tech fries, the corporate Curfew is shattered forever, and ALL MAIN CHARACTERS 
                SURVIVE UNHARMED! Humanity wakes up to a bright, free tomorrow.
                """);

            case "ENDING_1_DIPLOMATIC" -> System.out.println("""
                ================================================================================
                === ENDING 1: THE PATH OF LIGHT (DIPLOMATIC KANON ENDING)                    ===
                ================================================================================
                Talia overwrites the neural codes peacefully. Alfred Bester is placed under arrest by 
                the Alliance fleet. But as the structural columns of the headquarters collapse, 
                Lennier unexpectedly sacrifices his own life to pull Delenn, Ivanova, and you to safety. 
                Lennier clears his honor in the face of death.
                """);

            case "ENDING_5_SHADOW_DIRECTOR" -> System.out.println("""
                ================================================================================
                === ENDING 5: THE SHADOW DIRECTOR (YOUR MASTERPLAN)                         ===
                ================================================================================
                You ruthlessly execute Bester on the spot. Using your old Black Watch security codes, 
                you hijack the entire worldwide neural net for yourself instead of breaking it! 
                You become the new, invisible Director of Bureau 13. The population of Earth keeps sleeping... 
                completely unaware, under your iron rule.
                """);

            default -> System.out.println("""
                ================================================================================
                === ENDING 6: ABSOLUTE SILENCE (GAME OVER)                                   ===
                ================================================================================
                Your tactical attributes and alliance networks were too weak. Bester successfully 
                activates the worldwide neural network, frying the synapses of millions. 
                The Earth fractures permanently into civil war and absolute chaos.
                """);
        }

        System.out.println("""
            [SYSTEM]: Timeline successfully concluded. Sub-space comm lines opening...
            [PRESS ENTER FOR SCENE 32 - THE GRAND CLOSING EPILOGUE]
            """);
        scanner.nextLine();
    }
}