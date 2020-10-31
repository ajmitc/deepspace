package deepspace.game.threat;

import deepspace.game.Game;

public class Drone extends ExternalThreat{
    public Drone(){
        super("Drone", 1, "Drone.png", 2, 4, 6);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-1);
    }
}
