package deepspace.game.threat;

import deepspace.game.Game;

public class Drone2 extends ExternalThreat{
    public Drone2(){
        super("Drone", 1, "Drone.png", 3, 5);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-1);
    }
}
