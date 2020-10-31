package deepspace.game;

import java.util.ArrayList;
import java.util.List;

public abstract class CrewStation {
    private List<Crew> crewRequirements = new ArrayList<>();

    public CrewStation(List<Crew> crewRequirements){
        this.crewRequirements.addAll(crewRequirements);
    }

    public abstract boolean activate(Crew crew, Game game);
}
