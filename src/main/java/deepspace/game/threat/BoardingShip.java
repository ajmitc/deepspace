package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;

public class BoardingShip extends ExternalThreat{
    public BoardingShip(){
        super("Boarding Ship", 4, "BoardingShip.png", 3, 4);
        getAwayMission().add(Crew.TACTICAL);
        awayMissionSendToInfirmary = true;
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
