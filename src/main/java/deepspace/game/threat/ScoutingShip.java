package deepspace.game.threat;

import deepspace.game.Game;

public class ScoutingShip extends ExternalThreat{
    public ScoutingShip(){
        super("Scouting Ship", 3, "ScoutingShip.png", 0);
    }

    @Override
    public void doAtEndOfThreatActivation(Game game) {
        super.doAtEndOfThreatActivation(game);
        if (game.getShip().getHullLostThisRound() > 0){
            game.getShip().adjHull(-1);
        }
    }
}
