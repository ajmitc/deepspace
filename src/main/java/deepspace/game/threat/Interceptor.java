package deepspace.game.threat;

import deepspace.game.Game;

public class Interceptor extends ExternalThreat{
    public Interceptor(){
        super("Interceptor", 3, "Interceptor.png", 1, 2, 3, 4, 5);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-1);
    }
}
