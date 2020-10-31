package deepspace.game.threat;

import deepspace.game.Game;
import deepspace.game.PhaseStep;

public class Bomber2 extends ExternalThreat{
    public Bomber2(){
        super("Bomber", 2, "Bomber2.png", 2, 4);
    }

    @Override
    public void activate(Game game) {
        game.getShip().hit(-2);
        game.setPhaseStep(PhaseStep.ROLL_THREAT_SEND_CREW_TO_INFIRMARY);
    }
}
