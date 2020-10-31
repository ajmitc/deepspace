package deepspace.game.threat;

import deepspace.game.Game;

public class AssaultCruiser extends ExternalThreat{
    public AssaultCruiser(){
        super("Assault Cruiser", 4, "AssaultCruiser.png", 4, 5);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
