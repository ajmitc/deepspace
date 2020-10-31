package deepspace.game.threat;

import deepspace.game.Game;

public class SolarWinds extends ExternalThreat{
    public SolarWinds(){
        super("Solar Winds", 4, "SolarWinds.png", 2);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-5);
    }

    @Override
    public boolean isResolved(Game game) {
        return activated;
    }
}
