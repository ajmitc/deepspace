package deepspace.game;

import java.util.Date;
import java.util.Random;

public class CrewDice {
    private static final Random random = new Random(new Date().getTime());

    private Crew activeSide;

    public CrewDice(){
        activeSide = Crew.COMMANDER;
    }

    public Crew getActiveSide() {
        return activeSide;
    }

    public void roll(){
        activeSide = Crew.values()[random.nextInt(6)];
    }
}
