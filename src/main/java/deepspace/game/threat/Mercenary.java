package deepspace.game.threat;

import deepspace.game.Game;

public class Mercenary extends ExternalThreat{
    public Mercenary(){
        super("Mercenary", 3, "Mercenary.png", 0);
    }

    @Override
    public void doAtEndOfThreatActivation(Game game) {
        super.doAtEndOfThreatActivation(game);
        if (game.getThreatsActivatedThisRound() == 0){
            game.getShip().hit(-2);
        }
    }
}
