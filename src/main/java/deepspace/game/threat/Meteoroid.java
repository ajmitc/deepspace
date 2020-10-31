package deepspace.game.threat;

import deepspace.game.Game;

public class Meteoroid extends ExternalThreat{
    public Meteoroid(){
        super("Meteoroid", 4, "Meteoroid.png", 1);
    }

    @Override
    public void activate(Game game) {
        int health = game.getThreatHealth(this);
        game.getExternalThreats().get(health).remove(this);
        health -= 1;
        if (health == 0) {
            game.getShip().hit(-5);
        }
        else {
            game.getExternalThreats().get(health).add(this);
        }
    }
}
