package deepspace.game.threat;

import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class Bomber extends ExternalThreat{
    public Bomber(){
        super("Bomber", 3, "Bomber.png", 3, 4);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-1);
        game.setPhaseStep(PhaseStep.ROLL_THREAT_SEND_CREW_TO_INFIRMARY);
    }
}
