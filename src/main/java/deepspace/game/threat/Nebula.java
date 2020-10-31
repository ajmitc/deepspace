package deepspace.game.threat;

import deepspace.game.Game;

public class Nebula extends ExternalThreat{
    public Nebula(){
        super("Nebula", 3, "Nebula.png", 1, 2, 3, 4, 5);
    }

    @Override
    public void play(Game game) {
        super.play(game);
        game.getShip().setShieldsOnline(false);
    }

    @Override
    public void activate(Game game) {
        int health = game.getThreatHealth(this);
        game.getExternalThreats().get(health).remove(this);
        health -= 1;
        if (health == 0) {
            game.getShip().setShieldsOnline(true);
        }
    }
}
