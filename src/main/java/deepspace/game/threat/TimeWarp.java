package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;

public class TimeWarp extends InternalThreat{
    public TimeWarp(){
        super("Time Warp", "TimeWarp.png", new Integer[]{2}, new Crew[]{Crew.SCIENCE, Crew.SCIENCE});
    }

    @Override
    public void activate(Game game) {
        super.activate(game);
        game.allThreatsRecoverOneDamage();
    }
}
