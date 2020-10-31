package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class PanelExplosion extends InternalThreat{
    private CrewDice crewDice;

    public PanelExplosion(){
        super("Panel Explosion", "PanelExplosion.png", new Integer[]{}, new Crew[]{Crew.MEDICAL});
    }

    @Override
    public void play(Game game) {
        super.play(game);
        game.getBlockedCrew().add(Crew.ENGINEERING);
    }

    @Override
    public boolean isResolved(Game game) {
        if (super.isResolved(game)){
            game.getBlockedCrew().remove(Crew.ENGINEERING);
            return true;
        }
        return false;
    }
}
