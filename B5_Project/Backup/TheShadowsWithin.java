import java.util.Scanner;
import java.util.HashMap;

public class TheShadowsWithin {

    // 1. Global Game States (Timeline cleaned)
    static Player activePlayer; // Our character aka player

    // 2. Global relationships and threats
    static HashMap<String, Integer> relations = new HashMap<>();
    static int besterThreat = 75;
    static int draghPlague = 100;

    // 2.1 Die dynamische Liste für deine Reise-Historie
    static java.util.ArrayList<String> logbuch = new java.util.ArrayList<>();

    // 3. Loop controller
    static String currenLocation = "CHARACTER_CREATION";
    static boolean isGameRunning = true;
    static Scanner scanner = new Scanner(System.in);

    // 4. Savegame-system (Matrix)
    static String[] saveSlots = new String[3];      // 3 Slots

    static void saveGame(int slot) {
        if (slot < 0 || slot > 2 || activePlayer == null) return;

        try {
            StringBuilder snapshot = new StringBuilder();
            snapshot.append(currenLocation).append(";")
                    .append(activePlayer.getOrigin()).append(";")
                    .append(activePlayer.getCredits()).append(";")
                    .append(activePlayer.getAnalysisFocus()).append(";")
                    .append(activePlayer.getLoreKnowledge()).append(";")
                    .append(activePlayer.getPsiLevel()).append(";");

            saveSlots[slot] = snapshot.toString();
            System.out.println("\n[SYSTEM] Game synchronized with Slot " + (slot + 1) + "!");

        } catch (Exception e) { // Fängt Fehler im Netzwerk/PHP ab
            System.out.println("\n[CRITICAL ERROR] Failed to write neural snapshot: " + e.getMessage());
        } finally { // Wird IMMER ausgeführt
            System.out.println("[SYSTEM] Save operation cycle finished.");
        }
    }

    // 4.1 UNIVERSAL QUICK-SAVE: Only at location-change
    static void checkQuickSave() {
        System.out.println("\n------------------------------------------------------");
        System.out.println("Neural link stable. Would you like to quick-save your progress?");
        System.out.print("Input (yes / no): ");
        String quickChoice = scanner.next().trim();

        if (quickChoice.equalsIgnoreCase("yes")) {
            System.out.print("Select storage slot (1, 2, or 3): ");
            int slot = scanner.nextInt() - 1;
            saveGame(slot);
        }
    }


    // 5. The Main Reactor (Core Loop)
    public static void main(String[] args) {

        // 5.1 Set initial relationships
        relations.put("Lochley_B5", 50);
        relations.put("Ivanova_Earthfleet", 50);

        System.out.println("======================================================");
        System.out.println("=== PROJEKT: THE SHADOWS WITHIN - A B5 LEGACY =======");
        System.out.println("======================================================");

        // 5.2 The main loop controls the game via the enhanced switch
        while (isGameRunning) {
            switch (currenLocation) {
                case "CHARACTER_CREATION" -> selectOrigin();
                case "CINEMATIC_INTRO" -> playIntro();
                case "INTRO" -> playIntro();
                case "PROLOGUE" -> startPrologue();
                case "SECURITY_CENTER" -> transferToSecurity();
                case "ZOCALO" -> enterZocalo();
                case "COMMAND_CONFRONTATION" -> transferLochleyOffice();
                case "SHIP_RECOVERY" -> shipRecovery();
                case "RESEARCH_PHASE" -> allianceResearch();
                case "TECHNOMAGE_ARRIVAL"   -> transferSheridanAudience();
                case "SHERIDAN_AUDIENCE"    -> transferSheridanAudience();
                case "LIBURNIA_HUB" -> transferLiburniaHub();
                case "GAMEOVER" -> isGameRunning = false;
                default -> isGameRunning = false;
            }
        }
        scanner.close();
    }

    // 6. Chronicles/Story Modules
    static void selectOrigin() {
        System.out.println("\n[CHARACTER INITIALIZATION: THE RECKONING OF YESTERDAY]");

        System.out.print("Enter your operative name: ");
        String name = scanner.next().trim();

        System.out.println("\nBefore you descend into the venting shafts, choose who you are:");
        System.out.println("1 = EX-AGENT (Analysis and Lore Bonus)");
        System.out.println("2 = Smuggler (Bonus Credits)");

        System.out.print("Select your path (1/2): ");
        String choice = scanner.next().trim();

        if (choice.equals("1")) {
            activePlayer = new Player(name, "Ex-Agent");
        } else {
            activePlayer = new Player(name, "Smuggler");
        }

        System.out.println("\n" + activePlayer);

        currenLocation = "CINEMATIC_INTRO";
    }

    // 7.1 Play-Intro
    static void playIntro() {
        System.out.println("""
                
                ======================================================
                === CINEMATIC INTRO: THE ASHES OF YESTERDAY =========
                ======================================================
                
                The crackle of the dying campfire throws long, dancing shadows against the 
                ancient stone walls of the Narn ruins. The air is heavy with the scent of 
                burning g'quaneth incense. 
                
                Citizen G'Kar sits by the flames, his single eye reflecting the amber glow 
                as he looks across the hearth at Alric. The silence between them carries the 
                weight of a century of suffering.
                
                G'Kar: 'The universe is driven by complex vectors, Alric. We believe we move 
                      forward, yet we constantly step into the footprints of those who came 
                      before us. The shadows are fading, yes... but the spaces they left behind 
                      are cold. And vacuum rushes to fill a void.'
                
                Alric watches the embers drift up into the starless twilight, his hand resting 
                thoughtfully on his old datajournal.
                
                G'Kar: 'A spark will fall in the dirt of Babylon 5. Someone will have to catch it 
                      before the Corps turns the homeworld into a silent cage. Walk with light, 
                      my friend... for the night ahead is absolute.'
                
                [FADE TO BLACK]
                
                ======================================================
                === BABYLON 5: THE SHADOWS WITHIN ====================
                ======================================================
                [EPIC TITLE CARD ACCELERATION - SMOKE AND BIOCRYSTAL]""");

        currenLocation = "PROLOGUE";
    }

    // =========================================================================
    // 7.2 ACT I - PART 1: THE SPARK IN THE DARK (Prolog mit HP-Konsequenzen)
    // =========================================================================
    static void startPrologue() {
        System.out.println("""
                
                ======================================================
                === PROLOGUE: THE SPARK IN THE DARK ==================
                ======================================================
                
                The air in Sector Brown of Babylon 5 tastes of recycled oxygen,
                cheap synthetic coffee, and the stale heat of unmonitored freighter vents.
                Down here, in the sub-level maintenance shafts, you move through the grey.
                It is the only way you found to survive after the tragic loss of your partner, Marcus Cole.
                
                Suddenly, a figure stumbles through a heavy maintenance airlock.
                A man in the shredded, blood-stained robes of a Ranger collapses directly before you.
                Behind him, far down the corridor, Psi Corps bloodhounds sweep the alley with bioscanners.
                
                The Ranger gasps, dark blood welling on his lips. Silent recognition glints in his eyes.
                He presses a cold data crystal into your palm, whispering with a rasping, broken voice:
                 'Take it... Bring it... personally to the command staff... Trust no one...'
                 'The sleepers are waking... We die... for the One...'
                
                A final rattle, then his body slacks. The Anla'shok medallion slips into your fist.
                Suddenly, the harsh searchlights of the Psi-Gards cut through the iron fog! 
                The bioscanners are heading straight toward your coordinates. You have seconds to act.
                
                Wie reagierst du auf die herannahende Patrouille?""");

        // INTERAKTIVE WEGGABELUNG
        System.out.println("1 = [CHAMELEON NETTING] Activate your illegal cloaking field and press against the bulkhead.");
        System.out.println("2 = [TACTICAL EVASION] Dash into the open ventilation shafts to outrun the scanners.");
        if (activePlayer.getOrigin().equalsIgnoreCase("Ex-Agent")) {
            System.out.println("3 = [INTEL OVERRIDE] Use your security codes to jam the local area scanner grid.");
        } else {
            System.out.println("3 = [UNDERWORLD BRIBERY] Toss 5,000 Credits to a nearby lurker to create a loud distraction.");
        }

        System.out.print("\nDeine Wahl (1/2/3): ");
        String choice = scanner.next().trim();

        if (choice.equals("1")) {
            System.out.println("""
                
                [CLOAKING SUCCESSFUL]
                The holographic field hums faintly. As the harsh lights of the telepath agents 
                sweep over you, they see nothing but a blank service wall and move on, frustrated. 
                You managed to avoid any detection silently.""");
        } else if (choice.equals("3")) {
            if (activePlayer.getOrigin().equalsIgnoreCase("Ex-Agent")) {
                System.out.println("""
                    
                    [DECEPTION TRIUMPH]
                    Your old Black-Watch codes instantly loop the security sub-station. 
                    The Psi-Gards' scanners glitch violently, forcing them to turn back 
                    to recalibrate their equipment. The sector is clear.""");
            } else {
                activePlayer.spendCredits(5000);
                System.out.println("""
                    
                    [DISTRACTION SUCCESSFUL]
                    The lurker snatches the credits and sprints down the opposing corridor, 
                    screaming and triggering the alarms. The Psi-Patrol wheels around and 
                    hunts the decoy. You slip away into the dark minus 5,000 Credits.""");
            } // KORREKTUR: Hier war die Klammer zu viel oder falsch gesetzt!
        } else {
            System.out.println("""
                
                [TACTICAL FAILURE - SCANNER DETECTED]
                You scramble into the venting ducts, but the biological sensors pick up your 
                heat signature! A Black Omega guard opens fire with a heavy PPG. 
                A plasma bolt grazes your shoulder, burning through your jacket before you 
                can slide down the emergency trash chute into safety!""");

            // KORREKTUR: Nutzt setHealth() aus deiner Character-Klasse, um 25 HP abzuziehen
            activePlayer.damage(25);
            System.out.println("[HEALTH WARNING] Current Condition: " + activePlayer.getHealth() + " HP remaining.");

            if (activePlayer.getHealth() <= 0) {
                System.out.println("\n[FATAL ERROR] Your vitals flatline in the dark shafts of Babylon 5.");
                currenLocation = "GAMEOVER";
                return;
            }

        activePlayer.setHasDataCrystal(true);
        activePlayer.setHasMedaillion(true);

        System.out.println("\n[INVENTORY UPDATE] " + activePlayer);

        System.out.println("""
                
                This silent sacrifice triggers a painful memory of the unyielding life
                Marcus once chose. Your mask remains cold, but the path is set.""");

        currenLocation = "SECURITY_CENTER";
    }
}

    // =========================================================================
    // ACT I - PART 1: THE SECURITY CENTER & THE ENCRYPTED CRYSTAL
    // =========================================================================
    static void transferToSecurity() {
        System.out.println("""
                
                [THE PATH TO THE SECURITY CENTER]
                Utilizing unmanifested smuggling routes, you slip past the automated internal grid.
                You emerge with icy urgency directly inside the private office of Zack Allan.
                
                Without a word of explanation, you place the encrypted data crystal on his console.
                You: 'Mr. Allan. A Ranger just died in the shafts of Sector Brown. The Corps is hunting
                     these data. It was absolutely vital to him that this crystal reaches the station command.
                     Ensure it gets into their hands personally. Take care of it.'
                
                Zack Allan stares at the object, nods grimly, and sweeps it off his desk.
                He turns around: 'Damn it... Where is the body? Tell me where he--'
                
                But he speaks to a bare bulkhead. In the two seconds of his distraction, you have
                timed the perfect moment and vanished flawlessly into the crowded corridors.
                
                Wenkig later, Zack Allan closes the heavy blast doors of the Council Chamber.
                Captain Elizabeth Lochley slides the crystal into a secure Alliance terminal.
                The console hums, but a cold prompt flashes on the screen: [CRITICAL ERROR - DATA ENCRYPTED].
                The decryption protocols fail completely against the alien encryption.
                
                Lochley frowns grimly: 'It is completely locked down. We cannot read the coordinates.
                We need someone who understands this kind of ancient tech...'
                
                The terminal continues to pulse in warning, the encryption remaining impenetrable. 
                Suddenly, a high-priority proximity alert blares through the Council Chamber's comm-channels.
                
                Outside the viewport, the massive swirling vortex of the local hyperspace jump gate ignites. 
                A sleek, dark vessel of unfamiliar design—its hull covered in shifting, biomechanical patterns—emerges 
                silently from the blue void and enters the station's sector.
                
                The central comm-deck crackles to life as a cold, modulated voice requests immediate docking 
                clearance for a private hangar bay. A Technomage has arrived at Babylon 5.
                
                Captain Lochley opens the command channel, granting the clearance without hesitation. 
                She turns to her terminal, her voice cutting through the secure security grid with sharp authority:
                'Lochley to Command Deck. Alert Zack Allan and Tessa Holloran immediately. Tell them the gold 
                channels to Earth are dark, and we need to find that '""" + activePlayer.getOrigin() + """
                who left this crystal. Find them at all costs!'""");

        // Only the crystal is handed over. The medallion STAYS with the player!
        activePlayer.setHasDataCrystal(false);
        activePlayer.setHasMedaillion(false);

        System.out.println("\n[INVENTORY UPDATE] " + activePlayer);

        checkQuickSave();
        // Shifting coordinates to the Research Phase
        currenLocation = "ZOCALO";
    }

    // =========================================================================
    // ACT I - PART 3: THE ZOCALO & THE SILENT COUP
    // =========================================================================
    static void enterZocalo() {
        System.out.println("""
                
                ======================================================
                === ACT I - PART 2: THE ZOCALO =======================
                ======================================================
                
                The neon lights of the Zocalo flicker weakly against the metallic bulkheads. 
                You move cautiously through the dense crowd, blending seamlessly into the shadows 
                of the transit sectors. Your hand rests near your PPG holster, your eyes tracking 
                every security patrol.
                
                Suddenly, every BabCom monitor across the promenade cuts to static. 
                The continuous ISN news broadcast freezes, snapping into cold, dead snow. 
                The sudden loss of the gold channels to Earth does not trigger a unified panic—instead, 
                a heavy, suffocating silence washes over the multi-species crowd. 
                
                The reaction across the alien sectors is fractured. A group of Centauri merchants near 
                the diplomatic lounge merely shrug with cold indifference, whispering spöttisch about 
                the fragile nature of human infrastructure. A lone Narn warrior turns away with 
                unconcealed disdain, completely detached from the plight of the homeworld. 
                
                Yet, amidst the rising tension, a serene Minbari attache steps into the center of the 
                promenade, raising their hands in a gesture of profound empathy, murmuring words of 
                comfort to soothe a group of terrified human docking technicians. 
                
                A low, anxious murmur spreads through the square. Hundreds of eyes of different shapes 
                and colors stare up at the empty screens, leaving a stifling atmosphere filled with 
                unanswerable questions. The homeworld is simply gone from the subspace relays.
                
                Before you can recede into the sub-levels, a heavy security detachment seals off 
                the exit junction. Zack Allan steps forward from the iron fog, his expression grim.
                
                Zack Allan: 'Don't move. I am not arresting you... but hell just broke loose. The homeworld is gone.'
                
                He grabs your arm, bypassing the station's general grid overrides, and shoves you 
                directly into the high-security briefing elevator bound for the Command Deck.""");

        System.out.println("\n[INVENTORY STATE] " + activePlayer);

        checkQuickSave(); // Ruft die Abfrage blitzschnell auf
        currenLocation = "COMMAND_CONFRONTATION";
    }

    // =========================================================================
    // ACT II: THE COUNCIL OFFICE INTERROGATION (Fragmented Shadows)
    // =========================================================================
    static void transferLochleyOffice() {
        System.out.println("""
            
            ======================================================
            === ACT II: THE COLD CONFRONTATION ===================
            ======================================================
            
            The heavy oak blast doors of Captain Lochley's private office slide shut. 
            The room is dimly lit, the viewport behind her desk showing the silent, swirling 
            vortex of the local jump gate. Zack Allan stands quietly by the door, keeping watch.
            
            Captain Elizabeth Lochley leans against her desk, her arms crossed, fixing you 
            with an intense, unyielding gaze:
            'Let's skip the military formalities. The subspace gold channels to Earth force command 
             just vaporized into pure static. And right before the blackout, you—'""");

        System.out.println("            '" + activePlayer.getName() + "'");

        System.out.println("""
             '—hand a highly classified, impenetrable alien data crystal to my Head of Security. 
             The homeworld is completely silent, and I don't know if we are facing a technical 
             collapse or an invisible invasion. And your file...'
            
            She taps a datapad on her desk. A fragmented, heavily redacted dossier flickers in amber light.
            
            Lochley: '...your file is a ghost story. Half-deleted Earthforce records, unverified smuggler 
                     manifests, or black-ops clearances that officially don't exist. Alliance Intel 
                     has nothing but questions. Who are you, and why did that Ranger pick you out of 
                     all the thousands of souls in the lower sectors?'
            
            You remain completely silent, your expression an unreadable mask. You offer no explanations, 
            keeping your motives entirely to yourself.
            
            You: 'The Ranger collapsed at my feet in the dark. I don't know why he was there, and I don't 
                 know what he wanted from me. But when he bled out... he reminded me of someone. Someone 
                 who threw his life away for a cause and a uniform I never understood. I brought you 
                 the crystal to settle a memory. That is all the leverage you get, Captain.'
            
            Zack Allan looks at you, a realization flashing in his eyes. He turns to Lochley:
            'Captain... the Black-Watch clearance fragments in the file. They match the old sector logs 
             from before the Shadow War. Our operative here... they used to run grids with Marcus Cole. 
             Long before Marcus abandoned the shadows to join the Anla'shok. That Ranger knew exactly 
             who he was looking for in Sektor Braun.'
            
            Lochley looks from the screen back to you, the suspicion in her eyes turning into grim gravity:
            'Marcus Cole... If he put your name in the Ranger grid before he died, he knew you would 
             deliver. You might not care about our Alliance, but Earth is blind right now, and that 
             crystal is impenetrably locked. We cannot read it without a specialized biohemical cypher'
            
            She steps closer, the urgency in her voice sharp and official:
            'The moment the grid died, I initiated a secure crisis corridor to President Sheridan. 
             He anticipated future problems and prepared for these scenarios: 
             Hidden in Sector 14 lies a secret prototype cruiser, the LIBURNIA. 
             An Earth-Minbari hybrid. But our chief constructor, Sha'In, has just been abducted by raiders. 
             Sheridan's direct orders are to secure that ship. I need your skills in the dark. 
             Take the Liandra, infiltrate Sector 14, find the girl, and bring the Liburnia home.'""");

        // 💡 DEINE INLINE-ENTSCHEIDUNG: Gesinnung und Reaktion bleiben waage
        System.out.println("\nHow do you respond to Lochley's urgent deployment order?");
        if (activePlayer.getOrigin().equalsIgnoreCase("Ex-Agent")) {
            System.out.println("1 = [PROFESSIONAL DISTANCE] 'Sheridan's contingency parameters are logical. I will secure the asset.'");
            System.out.println("2 = [LEVERAGE] 'If I risk my neck in Sector 14, I want my official Earthforce record completely wiped clean.'");
            System.out.println("3 = [THE ECHO OF MARCUS] 'Marcus died protecting your vision of tomorrow. I'll find the girl. For him.'");
        } else { // Smuggler
            System.out.println("1 = [BUSINESS AS USUAL] 'Infiltrating raider territory carries a high premium, Captain. I expect full immunity for my routes.'");
            System.out.println("2 = [UNALIGNED] 'I don't care about Sheridan's ghost ship, but I hate anyone who locks down my airspace. I'm in.'");
            System.out.println("3 = [A SILENT DEBT] 'Marcus Cole was a fool... but he was a fool who kept me alive once. I'll bring the ship back.'");
        }

        System.out.print("\nYour decision (1/2/3): ");
        String choice = scanner.next().trim();

        // Variables update using your HashMap system
        if (choice.equals("3")) {
            relations.put("Ivanova_Earthfleet", relations.get("Ivanova_Earthfleet") + 25);
            System.out.println("\n-> Zack Allan nods with quiet respect: 'Some debts are never truly settled.'");
        } else {
            relations.put("Lochley_B5", relations.get("Lochley_B5") + 20);
            System.out.println("\n-> Captain Lochley accepts your terms with a crisp, guarded military nod.");
        }

        System.out.println("""
            
            Lochley hands you the clearance datapad: 'Proceed to Hangar Bay 7. 
            The Liandra's crew is ready to transport you to Sha'In's last known coordinates. 
            From there on, you're on your own. Bring her and the ship safely back to Babylon 5.'""");

        // Savegame routine
        System.out.println("\n------------------------------------------------------");
        System.out.println("Tactical milestone reached. Synchronize neural net with save slots?");
        System.out.print("Input (yes / no): ");
        String saveChoice = scanner.next().trim();

        if (saveChoice.equalsIgnoreCase("yes")) {
            System.out.print("Select target storage slot (1, 2, or 3): ");
            int slot = scanner.nextInt() - 1;
            saveGame(slot);
        }

        checkQuickSave();
        currenLocation = "SHIP_RECOVERY";
    }

// =========================================================================
// ACT II - PART 2: THE PIRATE SECTOR 14 (Tactical Infiltration)
// =========================================================================
static void shipRecovery() {
    System.out.println("""
            
            ======================================================
            === ACT II - PART 2: THE PIRATE SECTOR 14 ============
            ======================================================
            
            The Liandra drops out of hyperspace inside the debris field of Sector 14. 
            The raider outpost is hidden inside a shattered Dreadnought hull. 
            You infiltrate the lower maintenance levels through a garbage chute. 
            
            Deep within the lower levels, you locate the heavy security cells. 
            Sha'In is trapped inside a high-frequency energy cage, guarded by two mercenaries 
            who are patrolling the iron walkway right in front of the cell block.
            
            Wie gehst du gegen die beiden Wachen vor?""");

    // 💡 INTERAKTIVES STEALTH- UND TÄUSCHUNGS-MENÜ
    System.out.println("1 = [TACTICAL ASSAULT] Draw your PPG and eliminate them in a direct firefight.");
    System.out.println("2 = [SILENT OVERPOWER] Creep up from the pipes and choke the rear guard out silently.");
    System.out.println("3 = [THROW OBJECT] Throw a loose fusion coupling down the corridor to divert their attention.");
    System.out.println("4 = [DECEPTIVE BLUFF] Step out confidently, flashing a fake Alliance black-ops warrant.");

    System.out.print("\nDeine Wahl (1/2/3/4): ");
    String choice = scanner.next().trim();

    // Flag to track the noise level for the return path consequence
    String tacticalWay = "stealth";

    if (choice.equals("2")) { // Lautlose Überwältigung
        System.out.println("""
                
                [SILENT OVERPOWER SUCCESSFUL]
                You drop silently from the ceiling pipes behind the rear guard. 
                Before his partner turns around, you drag him into the dark and break his neck. 
                You dive forward, knocking the second mercenary over the railing into the reactor pit. 
                The area remains completely quiet.""");
        tacticalWay = "stealth";

    } else if (choice.equals("3")) { // Gegenstand werfen (Ablenkung)
        System.out.println("""
                
                [DISTRACTION SUCCESSFUL]
                You hurl the heavy fusion coupling into the ventilation shafts further down the hall. 
                The echoing metal crash makes both guards draw their weapons and investigate the noise. 
                While their backs are turned, you slip to the console, deactivate the cage, and pull 
                Sha'In into the maintenance tunnels before they return.""");
        tacticalWay = "stealth";

    } else if (choice.equals("4")) { // Täuschungsmanöver (Bluff)
        if (activePlayer.getOrigin().equalsIgnoreCase("Ex-Agent")) {
            System.out.println("""
                    
                    [DECEPTIVE TRIUMPH - INTEL BONUS]
                    Utilizing your cold Black-Watch posture, you present the encrypted datapad. 
                    The mercenaries, intimidated by the official Alliance security clearance, 
                    assume you are here for a classified extraction. They step aside with a crisp nod 
                    and open the energy cage without a single question.""");
            tacticalWay = "stealth";
        } else { // Smuggler bluff fails but switches to bribery
            System.out.println("""
                    
                    [BLUFF FAILED - UNDERWORLD EXTORTION]
                    The mercenaries laugh at your fake Alliance documents: 'Nice try, smuggler.' 
                    They demand a toll. You are forced to pay 15,000 Credits on the spot to buy your way out.""");

            boolean purchaseSuccessful = activePlayer.spendCredits(15000);
            if (purchaseSuccessful) {
                System.out.println("\nThey take the credit chips, grin greedily, and deactivate the cage.");
                tacticalWay = "stealth";
            } else {
                System.out.println("""
                        
                        [NO FUNDS - COMBAT TRIGGERED]
                        You lack the credits! They immediately raise their rifles. 
                        You are forced into a chaotic, close-quarters brawl, taking a heavy punch 
                        to the ribs before you can overpower them!""");
                activePlayer.damage(20); // HP-Abzug bei Fehlschlag
                tacticalWay = "action";
            }
        }

    } else if (choice.equals("1")) { // Offener Kampf (PPG)
        System.out.println("""
                
                [PPG ENGAGEMENT]
                You open fire. Two plasma bolts cut through the iron fog. The mercenaries return fire, 
                their heavy slugs denting the bulkheads. You eliminate them, but the noise is deafening.""");
        tacticalWay = "action";

    } else { // Fallback/Fehlentscheidung
        System.out.println("""
                
                [TACTICAL FAILURE]
                You hesitate too long. The mercenaries spot your shadow and open fire instantly! 
                A plasma shot grazes your flank before you can clear the corridor!""");
        activePlayer.damage(25); // HP-Abzug
        tacticalWay = "action";
    }

    // --- DER LOGISCHE RÜCKWEG ZUM GEHEIMEN HANGAR BASED ON CONSEKUENZ ---
    System.out.println("""
            
            Sha'In steps out of the cell: 'Thank Valen! But we are miles away from the construction dock. 
            The LIBURNIA is hidden deep in the upper militarized hangar bay. We need to get there now!'
            
            You guide her out of the cell block and navigate the long path up to the primary docks.""");

    // Logischer Pfad basierend auf deiner Infiltrations-Taktik
    if (tacticalWay.equals("action")) {
        System.out.println("""
                
                [ALERT CONDITION RED]
                Because of the loud combat at the cells, the raider base is on high alert! 
                The path up to the hangar is crawling with reinforcements. You and Sha'In are 
                forced to fight your way through two blast doors, burning through ammunition 
                and taking minor damage before you can slide into the main dock corridor!""");
        if (activePlayer.getHealth() > 15) {
            activePlayer.setHealth(activePlayer.getHealth() - 10); // Zusätzlicher Verschleiß bei Alarm
        }
    } else {
        System.out.println("""
                
                [GHOST RUN PROTOCOL]
                Because you cleared the cells without a sound using your tactical maneuvers, the base 
                remains completely oblivious. You and Sha'In slip flawlessly through the maintenance shafts, 
                bypassing the patrol grids entirely until you reach the reinforced doors of the secret hangar.""");
    }

    System.out.println("""
            
            Sha'In punches her private override into the heavy hangar lock. 
            Before you stands the breathtaking silhouette of the hybrid cruiser.
            
            Sha'In: 'Engines online. Biocrystalline core at maximum. Let's fly!'
            
            The ship is yours. Current Vitals: """ + activePlayer.getHealth() + " HP.");

    checkQuickSave();
    currenLocation = "RESEARCH_PHASE";
    }

// =========================================================================
// ACT II - PART 3: THE CORPS OVERRIDE (The Medlab Investigation & Healing)
// =========================================================================
static void allianceResearch() {
    System.out.println("""
            
            [BABYLON 5 - MEDLAB ONE - HOURS LATER]
            The biocrystalline cores of the newly secured LIBURNIA are safely powered down 
            in hangar bay 7. You enter Medlab One alongside a completely exhausted Sha'In. 
            Captain Elizabeth Lochley and Zack Allan are already waiting by the central grid.""");

    // 💡 INTERACTIVE HEALING SYSTEM: Dr. Chambers treats your wounds if you are damaged
    // 💡 INTERACTIVE HEALING SYSTEM: Dr. Chambers treats your wounds if you are damaged
    if (activePlayer.getHealth() < 100) {
        activePlayer.heal(100);
        System.out.println("""
                
                Dr. Sarah Chambers looks up from her console, her eyes instantly tracking your 
                limping stride and the plasma burns on your tactical jacket.
                Chambers: 'You look like hell. Sit down on the diagnostic bed before you flatline on my floor.'
                
                She activates a localized cortical scanner. A soothing warm light bathes your wounds, 
                synthesizing cell regeneration in seconds.""");

        activePlayer.modifyHealth(100 - activePlayer.getHealth()); // Fully restores your health using the Character parent class method
        System.out.println("[SYSTEM] Vitals fully restored: " + activePlayer.getHealth() + " HP.");
    }

    System.out.println("""
            
            The data crystal sits inside a static containment field on the central terminal—cold, 
            dark, and completely impenetrable. Dr. Sarah Chambers is running a microscopic resonance 
            sweep directly on the surface of the locked crystal. 
            
            Dr. Stephen Franklin remains patched in via an encrypted tactical link from Earthforce 
            Medical in Geneva. The communication utilizes secure Interstellar Alliance micro-frequencies. 
            Though the Earth's civilian net has been dead from the start, this military line has 
            held—until now.
            
            Chambers: 'Lochley, I am running a microscopic resonance sweep on the crystal's casing. 
                      The material is contaminated with an exotic, biomechanical radiation. It does not 
                      match any known League or Minbari technology.'
            
            Franklin (via comms): 'The energetic amplitudes match the old classified logs from Mars, Sarah... 
                                  but this matrix is active. It requires a highly focused, synthetic mind-force 
                                  to stabilize it. A telepathic lock of immense power.'
            
            [THE TRANSMISSION SEVERS]
            Suddenly, without warning, Dr. Franklin's holographic image violently shatters into 
            pure static. High-frequency white noise screeches through the speakers. Franklin didn't 
            even have time to realize what happened—the tactical Alliance corridor has just been 
            abruptly severed from the other side.
            
            Lochley frowns, tapping the console: 'Stephen? Franklin, respond! Damn it, the line is dead.'
                
            [THE SHADOW-TECH ENERGY SPIKE]
            Before Zack can cycle the emergency sub-routines, a massive, unprecedented energy spike 
            surges through every communication relay on the station. The sub-space conduits groan 
            under a violent biomechanical overload—a tachyon-driven carrier wave broadcasted by the 
            stolen Shadow technology on Hentou. The Psi Corps has weaponized the ancient matrix, 
            using the network's amplification to instantly activate every sleeper unit across the galaxy.
                
            [THE PSI CORPS OVERRIDE - ALL CHANNELS LIVE-FEED]
            Every single monitor inside Medlab, and across the entire station, violently flashes. 
            The civilian BabCom grid, the secure military channels, and the commercial relays are 
            instantly hijacked by the overriding signal. 
                
            The cold, stark insignia of the Psi Corps materializes on the black screens. 
            Beneath the burning telepath symbol, a systematic text pulses: [PLEASE STAND BY].
                
            An absolute, paranoid unease and panic instantly ripple through the corridors of Babylon 5. 
            Seconds later, the symbol fades. 
                
            Alfred Bester appears on the broadcast. He is sitting behind the grand mahogany desk 
            inside the private office of the Earth Alliance President in Geneva. Two elite Black Omega 
            guards stand rigid behind him. His expression carries a chilling, victorious calm.
            
            Bester (Broadcast): 'Good evening. To all citizens of the Earth Alliance, both at home 
                               and across the distant sectors. Due to sudden, severe infrastructure 
                               instabilities and unverified external threats, President Roschenk 
                               has stepped down to secure planetary continuity.
                               
                               As of this hour, the Psi Corps has assumed full temporary administration 
                               over all governmental branches, military networks, and communication arrays. 
                               For the mundane population, a new era of absolute protection and structured 
                               service begins. Do not attempt to breach the global quarantine corridors. 
                               We are watching. We are everywhere. Trust the Corps.'
            
            The live-feed cuts back to dead static. The homeworld is a fortress of silence.
            
            [PSI-RESONANCE INTENSIFICATION]
            A sudden, invisible pressure slams into your temples—a residual sub-space shockwave 
            of thousands of telepaths silently synchronizing across the sector.""");

    // --------------------------------=====================================
    // DYNAMIC POLYMORPHIC LOGIC: Differentiating behavior based on character origin
    // --------------------------------=====================================
    if (activePlayer.getOrigin().equalsIgnoreCase("Ex-Agent")) {
        System.out.println("""
                Utilizing your specialized Black-Watch intelligence training, you immediately focus 
                your breathing. Your military conditioning triggers an intentional psychological 
                wall, locking your memories behind deep, artificial sub-routines.""");
    } else { // Smuggler path
        System.out.println("""
                Reacting on pure underworld instinct, your fingers tap a concealed switch under your 
                jacket. A subcutaneous Neuro-Jammer pulses to life, flooding your synapses with a 
                localized cybernetic static to block any external telepathic scans.""");
    }

    // --------------------------------=====================================
    // INTERFACE FULFILLMENT: Triggering contract methods from TelepathicLink
    // --------------------------------=====================================
    activePlayer.initialMentalSync("The Severed Homeworld Grid");
    activePlayer.shieldMind();

    System.out.println("""
            
            [A DISTANT VISITATION - DOCKING BAY 13]
            Deep within the shadows of your mind, the interface registers a secondary, uninvited 
            resonance. Miles away, inside the dark cockpit of the sleek, pattern-covered vessel, 
            the Technomage lowers his glowing staff. His biomechanical sphere reflects the dim reflection 
            of your face and Lochley's voice through the station's atmospheric vibrations. 
            He extinguishes the embers of the sphere with a dark whisper, adjusting his robes as 
            he prepares to move. He has witnessed everything.
            
            Inside Medlab, Captain Lochley turns around, her face pale but her eyes burning with fury.
            
            Lochley: 'It was a coup. Bester just handed the entire planet to his guards on a silver platter. 
                     We cannot read this crystal while the homeworld is a tactical prison. We need 
                     to mobilize the galaxy.'
                     
            She hands you an encrypted high-security clearance chip:
            'President John Sheridan is currently coordinating the crisis strategy from the Alliance 
             Chamber. He needs an operative who can navigate the grey sectors of the alien worlds. 
             Take the Liburnia. Go to Sheridan immediately. We must rally our allies among the Narn, 
             Minbari, and Centauri, break this communication siege, and tear Bester's wall down.'""");

    checkQuickSave();
    currenLocation = "SHERIDAN_AUDIENCE";
    }


    // =========================================================================
    // ACT III: THE ALLIANCE COUNCIL (The Mandate of President Sheridan)
    // =========================================================================
    static void transferSheridanAudience() {
        System.out.println("""
            
            ======================================================
            === ACT III: THE MANDATE OF THE ALLIANCE =============
            ======================================================
            
            The high-security blast doors of the Interstellar Alliance Chamber on Minbar slide open. 
            The vast circular council hall is dark, illuminated only by the massive holographic map 
            of the local galaxy pulsing in calm, blue vectors against the white crystalline walls. 
            
            President John Sheridan stands at the central podium, his expression heavily etched 
            with gravity as he monitors the dark, unmapped sectors that used to be the Earth Alliance.
            
            Sheridan: 'Come in. Captain Lochley informed me about your deployment in Sector 14. 
                      You brought Sha'In and the LIBURNIA safely here to our hidden docks. Excellent work. 
                      We are going to need that hybrid cruiser sooner than anyone anticipated.'
            
            He taps the console, highlighting three alien sectors on the star map.
            
            Sheridan: 'Bester's wide-spectrum suppressors have locked the homeworld inside a cage 
                      of total silence. The Interstellar Alliance cannot intervene directly without 
                      triggering a full-scale galactic war. But we can build a bypass. 
                      If we reconnect the old sub-space routing nodes on the alien homeworlds, 
                      we can shatter the Corps' blockade from the outside...'
            
            [A THEATRICAL INTRUSION - THE SHADOWS BEND]
            Before Sheridan can finish his tactical brief, the corporate holo-map violently 
            flickers, its blue vectors bending away from the back of the room. The ambient 
            temperature drops into freezing static. 
            
            Out of the absolute darkness of the structural recess, shifting golden geometric 
            equations cascade along the bulkheads, condensing into a single point. 
            The Technomage steps into the light, his staff tapping the polished stone floor with a 
            rhythmic, metallic echo.
            
            The Mage: 'A bypass, Mr. President? How beautifully linear. You think in networks 
                      and wires, Sheridan. Much like Alric used to do when he calculated the 
                      vectors of the stars. But a wire can be cut. A legacy cannot.'
            
            Sheridan's hand tightens against the podium, his eyes narrowing: 'You bypassed 
            our security matrix. Who authorized your presence on this deck? Elric warned me 
            about your order's interference.'
            
            The Mage lets out a soft, modulated chuckle, his shrouded head turning toward you. 
            From the deep folds of his heavy robes, he produces a heavy, dark crystalline artifact—the 
            sacred Seal of the Kha'Ri, its ancient Narn engravings catching the sharp light of the grid.
            
            The Mage: 'The universe moves in circles, Sheridan. You left your true home on 
                      Babylon 5 to bury yourself here, in the frozen crystal spires of Minbar. 
                      A strange choice for a man who once broke empires. And yet, the spark still 
                      finds its way back to the dirt.'
                      
            He holds up the Narn artifact, presenting it to Sheridan as absolute proof of his legitimacy:
            'Citizen G'Kar marked this path before his departure. This seal of the Kha'Ri is the verification 
             of his warning. Sha'In's rescue was not a coincidence—it was the first step to ensure the 
             Liburnia flies when the dark world demands a weapon.'
            
            The Mage looks back at the star map:
            'The biochemical cipher protecting that data crystal cannot be forced while the 
             homeworld is isolated. Sheridan's logic is, for once, adequate. You must reconnect 
             the alien routing nodes on the primary sectors first to stabilize the sub-space link. 
             Once your patchwork alliance stands and the line to Earth breathes again... I shall 
             unseal the secrets of Hentou for you. Not a second before.'
            
            Sheridan takes a measured breath, looking from the Mage back to you:
            'This remains a black-budget Alliance operation. You fly the Liburnia. 
             Your priority vectors are clear: secure the sub-space routing support from the Minbari, 
             the Narn, and the Centauri. Rebuild the relays.'
            
            With a collective nod, the briefing ends. The Technomage fades back into the structural 
            recesses, leaving the heavy Seal of the Kha'Ri resting on the central tactical table.""");

        checkQuickSave();
        // We descend into the hidden underground construction drydocks of Minbar
        currenLocation = "LIBURNIA_HUB";
    }

    // =========================================================================
    // ACT III - PART 2: THE LIBURNIA COMMAND DECK (Mission Hub on Minbar)
    // =========================================================================
    static void transferLiburniaHub() {
        // 💡 DEINE STATISTIK IM EINSATZ: Speichert die Ankunft im Logbuch ab!
        logbuch.add("Act III: Arrived at the hidden underground drydocks of Minbar.");

        System.out.println("""
            
            ======================================================
            === MISSION HUB: BRÜCKE DER EAS LIBURNIA =============
            ======================================================
            
            The air inside the main bridge of the Liburnia hums with a deep, organic resonance. 
            Shifting crystalline matrices—the Minbari contribution to the prototype—glow with a 
            soft, pulse-like silver ambiance along the structural arches. 
            
            Sha'In stands at the primary telemetry console, her fingers sliding over the interface:
            'System parameters are completely stable, Commander. The prototype cloaking grid is fully 
             operational. The underground construction drydocks of Minbar have completely cleared 
             our launch vectors.'
             
            She turns around, carefully sliding the heavy crystalline Seal of the Kha'Ri, which Zack 
             Allan brought down from Sheridan's office, into your tactical storage rack:
            'The President sent G'Kar's seal with us. It belongs on this ship. Its authority might 
             be the only thing that keeps us from being blown out of the sky when we cross into 
             alien borders.'
            
            The command grid flashes to life, illuminating the three strategic routing vectors Sheridan 
            assigned to break Bester's information siege.
            
            Where shall we chart our course, Commander?""");

        // Das Siegel des Kha'Ri geht permanent an Bord der Liburnia in deinen Besitz über
        activePlayer.setHasKhariSeal(true);
        System.out.println("[INVENTORY UPDATE] " + activePlayer + "\n");

        // Taktisches Missionszentrum
        System.out.println("Select your next interstellar mission destination:");
        System.out.println("1 = [VECTOR MINBAR] Secure biocrystalline routing relays from the Federation.");
        System.out.println("2 = [VECTOR NARN] Recruit heavy structural security vanguards from the Regime.");
        System.out.println("3 = [VECTOR CENTAURI] Infiltrate the high-society communication relays of the Republic.");

        System.out.print("\nYour choice (1/2/3): ");
        String vectorChoice = scanner.next().trim();

        if (vectorChoice.equals("1")) {
            System.out.println("\n-> Launch codes accepted. Leaving Minbar's atmosphere. Entering Hyperspace: Sector Minbar.");
            currenLocation = "MISSION_MINBAR";
        } else if (vectorChoice.equals("2")) {
            System.out.println("\n-> Launch codes accepted. Leaving Minbar's atmosphere. Entering Hyperspace: Sector Narn.");
            currenLocation = "MISSION_NARN";
        } else {
            System.out.println("\n-> Launch codes accepted. Leaving Minbar's atmosphere. Entering Hyperspace: Sector Centauri Prime.");
            currenLocation = "MISSION_CENTAURI";
        }

        checkQuickSave();
    }

    // Neue provisorische Platzhalter für die interstellaren Reisen, damit das Switch-Statement stabil bleibt
    static void missionMinbar() { System.out.println("\n[TACTICAL MILESTONE] Entering Minbari space..."); isGameRunning = false; }
    static void missionNarn() { System.out.println("\n[TACTICAL MILESTONE] Entering Narn space..."); isGameRunning = false; }
    static void missionCentauri() { System.out.println("\n[TACTICAL MILESTONE] Entering Centauri space..."); isGameRunning = false; }

} // <--- Das hier ist die allerletzte geschlossene Klammer der gesamten Klasse!
