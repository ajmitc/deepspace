package deepspace.game.threat;

import deepspace.game.Game;

public class Raiders3 extends ExternalThreat{
    public Raiders3(){
        super("Raiders", 2, "Raiders3.png", 1, 4);
    }

    @Override
    public void activate(Game game) {
        // Ignore shields
        game.getShip().adjHull(-2);
    }
}
