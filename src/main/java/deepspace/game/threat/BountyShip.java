package deepspace.game.threat;

import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class BountyShip extends ExternalThreat{
    public BountyShip(){
        super("Bounty Ship", 4, "BountyShip.png", 1, 2);
    }

    @Override
    public void activate(Game game) {
        game.getShip().setShield(0);
        game.getShip().hit(-1);
    }
}
