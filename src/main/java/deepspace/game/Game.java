package deepspace.game;

import deepspace.game.threat.Threat;
import deepspace.game.threat.ThreatDeck;

import java.util.*;

public class Game {
    private Phase phase;
    private PhaseStep phaseStep;

    private Ship ship;
    private List<CrewDice> infirmary = new ArrayList<>();
    private boolean infirmaryBuddySystem;
    private Map<Integer, List<Threat>> externalThreats = new HashMap<>();
    private List<Threat> internalThreats = new ArrayList<>();
    private ThreatDeck threatDeck = new ThreatDeck();
    private List<CrewDice> crewDice = new ArrayList<>();
    private List<CrewDice> returningCrewDice = new ArrayList<>();
    private int threatsActivatedThisRound = 0;

    private int numThreatDieRolls = 1;
    // These crew cannot be assigned (except to away missions)
    private Set<Crew> blockedCrew = new HashSet<>();

    public Game(){
        setPhase(Phase.SETUP);
        crewDice.add(new CrewDice());
        crewDice.add(new CrewDice());
        crewDice.add(new CrewDice());
        crewDice.add(new CrewDice());
        crewDice.add(new CrewDice());
        crewDice.add(new CrewDice());
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
        this.phaseStep = PhaseStep.START_PHASE;
    }

    public void setPhaseStep(PhaseStep phaseStep) {
        this.phaseStep = phaseStep;
    }

    public Phase getPhase() {
        return phase;
    }

    public PhaseStep getPhaseStep() {
        return phaseStep;
    }

    public void allThreatsRecoverOneDamage(){
        for (int i = 3; i > 0; --i){
            List<Threat> threats = externalThreats.get(i);
            externalThreats.get(i + 1).addAll(threats);
            externalThreats.get(i).clear();
        }
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isInfirmaryBuddySystem() {
        return infirmaryBuddySystem;
    }

    public void setInfirmaryBuddySystem(boolean infirmaryBuddySystem) {
        this.infirmaryBuddySystem = infirmaryBuddySystem;
    }

    public List<CrewDice> getInfirmary() {
        return infirmary;
    }

    public Map<Integer, List<Threat>> getExternalThreats() {
        return externalThreats;
    }

    public int getThreatHealth(Threat threat){
        for (int health: externalThreats.keySet()){
            if (externalThreats.get(health).contains(threat)){
                return health;
            }
        }
        return 0;
    }

    public ThreatDeck getThreatDeck() {
        return threatDeck;
    }

    public int getNumThreatDieRolls() {
        return numThreatDieRolls;
    }

    public void setNumThreatDieRolls(int numThreatDieRolls) {
        this.numThreatDieRolls = numThreatDieRolls;
    }

    public Set<Crew> getBlockedCrew() {
        return blockedCrew;
    }

    public List<CrewDice> getCrewDice() {
        return crewDice;
    }

    public List<CrewDice> getReturningCrewDice() {
        return returningCrewDice;
    }

    public int getThreatsActivatedThisRound() {
        return threatsActivatedThisRound;
    }
}
