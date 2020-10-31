package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;
import deepspace.game.PhaseStep;

import java.util.List;
import java.util.stream.Collectors;

public class Pandemic extends InternalThreat{
    private CrewDice crewDice;

    public Pandemic(){
        super("Pandemic", "Pandemic.png", new Integer[]{1}, new Crew[]{Crew.SCIENCE, Crew.MEDICAL});
    }

    @Override
    public void activate(Game game) {
        super.activate(game);
        game.setPhaseStep(PhaseStep.ROLL_THREAT_SEND_CREW_TO_INFIRMARY);
    }

    @Override
    public boolean isResolved(Game game) {
        int numMedical = (int) assignedCrew.stream().filter(d -> d.getActiveSide() == Crew.MEDICAL).count();
        int numScience = (int) assignedCrew.stream().filter(d -> d.getActiveSide() == Crew.SCIENCE).count();
        return numMedical > 0 || numScience > 0;
    }
}
