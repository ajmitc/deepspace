package deepspace.game.threat;

import deepspace.game.Game;

public class Raiders2 extends ExternalThreat{
    public Raiders2(){
        super("Raiders", 2, "Raiders2.png", 4, 6);
    }

    @Override
    public void activate(Game game) {
        // Ignore shields
        game.getShip().adjHull(-2);
    }
}
