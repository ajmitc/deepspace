package deepspace.game.threat;

import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class Corsair extends ExternalThreat{
    public Corsair(){
        super("Corsair", 2, "Corsair.png", 4, 5, 6);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
