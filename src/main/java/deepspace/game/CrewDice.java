package deepspace.game;

import java.util.Date;
import java.util.Random;

public class CrewDice {
    private static final Random random = new Random(new Date().getTime());

    private Crew activeSide;

    private boolean assigned;

    private int px, py;

    public CrewDice(){
        activeSide = Crew.COMMANDER;
        assigned = false;
        px = 0;
        py = 0;
    }

    public Crew getActiveSide() {
        return activeSide;
    }

    public void roll(){
        activeSide = Crew.values()[random.nextInt(6)];
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public int getPy() {
        return py;
    }

    public int getPx() {
        return px;
    }

    public void setCoord(int px, int py){
        this.px = px;
        this.py = py;
    }
}
