package deepspace.game.threat;

import deepspace.game.Game;

public class Raiders extends ExternalThreat{
    public Raiders(){
        super("Raiders", 2, "Raiders.png", 4, 6);
    }

    @Override
    public void activate(Game game) {
        // Ignore shields
        game.getShip().adjHull(-2);
    }
}
