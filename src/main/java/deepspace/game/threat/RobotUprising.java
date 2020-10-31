package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;
import deepspace.game.PhaseStep;

import java.util.List;
import java.util.stream.Collectors;

public class RobotUprising extends InternalThreat{
    private CrewDice crewDice;

    public RobotUprising(){
        super("Robot Uprising", "RobotUprising.png", new Integer[]{1, 2, 3}, new Crew[]{Crew.ENGINEERING});
    }

    @Override
    public void activate(Game game) {
        super.activate(game);
        game.setPhaseStep(PhaseStep.ROLL_THREAT_SEND_CREW_TO_INFIRMARY);
    }
}
