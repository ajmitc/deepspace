package deepspace.game.threat;

import deepspace.game.Game;

public class SpacePirates2 extends ExternalThreat{
    public SpacePirates2(){
        super("Space Pirates", 2, "SpacePirates2.png", 3, 6);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
