package deepspace.game.threat;

import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class Bomber3 extends ExternalThreat{
    public Bomber3(){
        super("Bomber", 2, "Bomber3.png", 2, 4);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-1);
        game.setPhaseStep(PhaseStep.ROLL_THREAT_SEND_CREW_TO_INFIRMARY);
    }
}
