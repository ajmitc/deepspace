package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;

public class CommsOffline extends InternalThreat{
    public CommsOffline(){
        super("Comms Offline", "CommsOffline.png", new Integer[]{}, new Crew[]{Crew.ENGINEERING});
    }

    @Override
    public void play(Game game) {
        super.play(game);
        game.getBlockedCrew().add(Crew.COMMANDER);
    }

    @Override
    public boolean isResolved(Game game) {
        if (super.isResolved(game)){
            game.getBlockedCrew().remove(Crew.COMMANDER);
            return true;
        }
        return false;
    }
}
