package deepspace.game.threat;

import deepspace.game.Game;

public class InterceptorX extends ExternalThreat{
    public InterceptorX(){
        super("Interceptor X", 4, "Interceptor.png", 1, 2, 3, 4, 5);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-1);
    }
}
