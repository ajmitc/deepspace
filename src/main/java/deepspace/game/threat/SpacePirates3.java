package deepspace.game.threat;

import deepspace.game.Game;

public class SpacePirates3 extends ExternalThreat{
    public SpacePirates3(){
        super("Space Pirates", 2, "SpacePirates3.png", 3, 6);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
