package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class BoostMorale extends InternalThreat{
    private boolean resolved = false;

    public BoostMorale(){
        super("Boost Morale", "BoostMorale.png", new Integer[]{6}, new Crew[]{});
    }

    @Override
    public void activate(Game game) {
        game.getShip().adjScanner(-1);
        resolved = true;
    }

    @Override
    public boolean isResolved(Game game) {
        return resolved;
    }
}
