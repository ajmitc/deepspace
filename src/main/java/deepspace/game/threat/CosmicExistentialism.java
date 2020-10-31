package deepspace.game.threat;

import deepspace.game.Crew;
import deepspace.game.Game;

public class CosmicExistentialism extends InternalThreat{
    public CosmicExistentialism(){
        super("Cosmic Existentialism", "CosmicExistentialism.png", new Integer[]{}, new Crew[]{Crew.SCIENCE});
    }

    @Override
    public void play(Game game) {
        super.activate(game);
        game.getBlockedCrew().add(Crew.SCIENCE);
    }

    @Override
    public boolean isResolved(Game game) {
        if (super.isResolved(game)){
            game.getBlockedCrew().remove(Crew.SCIENCE);
            return true;
        }
        return false;
    }
}
