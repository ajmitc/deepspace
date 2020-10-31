package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;

public class Distracted extends InternalThreat{
    private CrewDice crewDice;

    public Distracted(){
        super("Distracted", "Distracted.png", new Integer[]{3, 4}, new Crew[]{Crew.MEDICAL, Crew.MEDICAL});
    }

    @Override
    public void activate(Game game) {
        super.activate(game);
        if (crewDice == null) {
            // Place a die here
            crewDice = game.getCrewDice().remove(0);
        }
    }

    @Override
    public boolean isResolved(Game game) {
        if (super.isResolved(game)){
            if (crewDice != null)
                game.getReturningCrewDice().add(crewDice);
            return true;
        }
        return false;
    }
}
