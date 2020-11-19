package deepspace.game.threat;

import deepspace.game.Game;

public class Flagship extends ExternalThreat{
    public Flagship(){
        super("Flagship", 4, "flagship.png", 4, 5, 6);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-3);
    }
}
