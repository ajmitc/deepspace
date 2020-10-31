package deepspace.game.threat;

import deepspace.game.Game;

public class AssaultCruiser2 extends ExternalThreat{
    public AssaultCruiser2(){
        super("Assault Cruiser", 4, "AssaultCruiser2.png", 1, 2);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
