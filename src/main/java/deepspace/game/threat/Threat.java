package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;
import deepspace.view.ImageUtil;

import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class Threat {
    protected Image image;
    protected boolean external;
    protected String name;
    protected int startingHealth;
    protected List<Integer> activationValues = new ArrayList<>();
    protected List<Crew> awayMission = new ArrayList<>();
    protected boolean awayMissionSendToInfirmary = false;
    // Should this threat stick around after activated?
    protected boolean activated = false;
    protected List<CrewDice> assignedCrew = new ArrayList<>();

    public Threat(String name, boolean external, int startingHealth, String filename, Integer ... activationValues){
        this.name = name;
        this.external = external;
        this.startingHealth = startingHealth;
        this.image = ImageUtil.get(filename);
        for (Integer av: activationValues)
            this.activationValues.add(av);
    }

    /**
     * Called when a threat is added to the play area
     * @param game
     */
    public void play(Game game){}

    /**
     * Called when a threat is activated (ie. one of the activation numbers are rolled or when an internal threat is drawn)
     * @param game
     */
    public void activate(Game game){
        this.activated = true;
    }

    /**
     * Called at end of turn to deactivate internal threats
     * @param game
     */
    public void deactivate(Game game){
        this.activated = false;
    }

    public void doAtEndOfThreatActivation(Game game){

    }

    /**
     * Called after a threat is resolved (ie. by away mission)
     * @param game
     * @return true if threat is indeed resolved and should be discarded, false otherwise.
     */
    public boolean isResolved(Game game) {
        if (awayMission.isEmpty())
            return false;
        boolean resolved = true;
        Map<Crew, Integer> required = new HashMap<>();
        Arrays.stream(Crew.values()).forEach(crew -> {
            required.put(crew, (int) awayMission.stream().filter(c -> c == crew).count());
        });
        for (Map.Entry<Crew, Integer> entry: required.entrySet()){
            int assigned = (int) assignedCrew.stream().filter(c -> c.getActiveSide() == entry.getKey()).count();
            if (assigned < entry.getValue()){
                resolved = false;
                break;
            }
        }
        return resolved;
    }

    public String getName() {
        return name;
    }

    public boolean isExternal() {
        return external;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public Image getImage() {
        return image;
    }

    public List<Integer> getActivationValues() {
        return activationValues;
    }

    public List<Crew> getAwayMission() {
        return awayMission;
    }

    public boolean isAwayMissionSendToInfirmary() {
        return awayMissionSendToInfirmary;
    }

    public List<CrewDice> getAssignedCrew() {
        return assignedCrew;
    }
}
