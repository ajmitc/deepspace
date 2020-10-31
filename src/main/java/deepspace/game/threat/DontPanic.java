package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Game;

public class DontPanic extends InternalThreat{
    private CrewDice crewDice;

    public DontPanic(){
        super("Don't Panic!", "DontPanicx6.png", new Integer[]{}, new Crew[]{});
    }

    @Override
    public boolean isResolved(Game game) {
        return true;
    }
}
