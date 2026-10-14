/**
 * Manages the global state of the game, including player attributes,
 * economy, ship statistics, relationships, and story-driven blockade flags.
 * Acts as the centralized save-state system for Level 13.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BabylonState {
    // 1. Character Core Attributes
    public String characterOrigin = "";          // 'Intelligence' or 'Underworld'
    public int alignmentScore = 50;              // 0 = Aggressive/Revenge, 100 = Peaceful/Light
    public int analysisFocus = 85;
    public int loreKnowledge = 80;
    public int psiLevel = 0;
    public String currentScreen = "START";
    public int playerHP = 100;

    // 2. Economy & Ship Variables
    public int credits = 120000;
    public String shipName = "Liburnia";
    public boolean shipObtained = false;
    public int shipStealth = 35;
    public int shipCalibrationPath = 3;         // 1 = Binary, 2 = Minbari, 3 = Perfect Hybrid

    // 3. Threat, Alliance & Plot Indicators
    public int besterThreatLevel = 75;           // Controls dynamic ISN newsfeeds
    public int drakhInfluence = 50;              // Drops on Vir path, rises on Londo path
    public int controlDecryptionProgress = 0;    // Hits 999 after Mars
    public int greatMachineEnergy = 0;           // Importend for Epsilon III

    // 4. Permanent Story Flags
    public boolean hasDelennsDataCrystal = false;
    public boolean isNarnAvantgardeRecruited = false;
    public boolean areNarnMercenariesHired = false;
    public boolean lytaRecruited = false;
    public boolean taliasTraumaResolved = false;
    public boolean constructorRescued = false;   // UNLOCKS SHA'IN'S BLIND TRUST IN SCENE 6

    // 5. Object Collections & Frameworks
    public List<CrewMember> crewList = new ArrayList<>();
    public Map<String, Location> locationMap = new HashMap<>();
    public Map<String, Integer> relationships = new HashMap<>();
    public Map<String, Boolean> visitedLocations = new HashMap<>();

    public BabylonState() {
        // Initialize Core Locations matching Act III Vectors
        locationMap.put("B5", new Location("B5", "Sector Babylon 5"));
        locationMap.put("CENTAURI", new Location("CENTAURI", "Centauri Prime"));
        locationMap.put("NARN", new Location("NARN", "Narn Homeworld"));
        locationMap.put("MARS", new Location("MARS", "Mars Sector"));
        locationMap.put("LYTA", new Location("LYTA", "Lyta's Refuge"));

        // Initialize Base Relationships
        relationships.put("Lochley_B5", 50);
        relationships.put("Garibaldi_Mars", 50);
        relationships.put("Ivanova_Earthfleet", 50);

        // Initialize Travel Verification Flags
        visitedLocations.put("B5", false);
        visitedLocations.put("Centauri_Prime", false);
        visitedLocations.put("Narn", false);
        visitedLocations.put("Mars", false);
        visitedLocations.put("Earth", false);
    }

    /**
     * Dynamically generates the unedited Earth ISN feed based on plot flags
     */
    public String getCurrentISNNewsfeed() {
        if (locationMap.get("B5").isBlocked()) {
            return "[ISN EMERGENCY FEED]: Earthforce Destroyers are blocking the Epsilon system. Babylon 5 is under orbital arrest! Curfews active.";
        }
        if (besterThreatLevel >= 85) {
            return "[ISN PROPAGANDA]: Special decree enacted by the Corps. Public execution and arrest of 'normal agitators' in Geneva completed.";
        } else if (besterThreatLevel >= 60) {
            return "[ISN CENSORSHIP]: Mass surveillance of all telemedia channels active on Earth. Resistance in the Greater Paris sector crushed.";
        } else {
            return "[ISN WARNING]: Increased readiness active for all Black Omega squadrons in Earth orbit. Under-cover threats monitored.";
        }
    }
}
