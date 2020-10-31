package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FriendlyFire extends InternalThreat{
    private CrewDice crewDice;

    public FriendlyFire(){
        super("Friendly Fire", "FriendlyFire.png", new Integer[]{}, new Crew[]{});
    }

    @Override
    public void play(Game game) {
        super.play(game);
        List<CrewDice> matches = game.getCrewDice().stream().filter(d -> d.getActiveSide() == Crew.TACTICAL).collect(Collectors.toList());
        for (CrewDice match: matches) {
            game.getCrewDice().remove(match);
            game.getInfirmary().add(match);
        }
    }

    @Override
    public boolean isResolved(Game game) {
        return true;
    }
}
