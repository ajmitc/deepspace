package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class Invaders extends InternalThreat{
    public Invaders(){
        super("Invaders", "Invaders.png", new Integer[]{2, 4}, new Crew[]{Crew.TACTICAL, Crew.TACTICAL});
    }

    @Override
    public void activate(Game game) {
        super.activate(game);
        // Send unit to infirmary
        game.setPhaseStep(PhaseStep.ROLL_THREAT_SEND_CREW_TO_INFIRMARY);
    }
}
