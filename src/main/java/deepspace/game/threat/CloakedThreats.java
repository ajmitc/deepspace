package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;

public class CloakedThreats extends InternalThreat{
    public CloakedThreats(){
        super("Cloaked Threats", "CloakedThreats.png", new Integer[]{2}, new Crew[]{Crew.COMMANDER, Crew.SCIENCE});
    }

    @Override
    public void activate(Game game) {
        super.activate(game);
        game.setNumThreatDieRolls(game.getNumThreatDieRolls() + 1);
    }

    @Override
    public void deactivate(Game game) {
        super.deactivate(game);
        game.setNumThreatDieRolls(game.getNumThreatDieRolls() - 1);
    }
}
