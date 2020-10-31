package deepspace.game.threat;

import deepspace.game.Crew;

public class InternalThreat extends Threat{

    public InternalThreat(String name, String filename, Integer[] activationValues, Crew... awayMission){
        super(name, false, 0, filename, activationValues);
        for (Crew crew: awayMission)
            super.awayMission.add(crew);
    }
}
