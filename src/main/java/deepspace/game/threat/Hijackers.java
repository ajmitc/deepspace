package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;

public class Hijackers extends ExternalThreat{
    public Hijackers(){
        super("Hijackers", 4, "Hijackers.png", 4, 5);
        awayMission.add(Crew.COMMANDER);
        awayMission.add(Crew.COMMANDER);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
    }
}
