package deepspace.game.threat;

import deepspace.game.Game;

public class SpacePirates extends ExternalThreat{
    public SpacePirates(){
        super("Space Pirates", 3, "SpacePirates.png", 1, 3);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
