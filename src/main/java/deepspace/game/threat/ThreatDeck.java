package deepspace.game.threat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreatDeck {
    private List<Threat> deck = new ArrayList<>();
    private List<Threat> discardList = new ArrayList<>();

    public ThreatDeck(){
        deck.add(new AssaultCruiser());
        deck.add(new AssaultCruiser2());
        deck.add(new BoardingShip());
        deck.add(new Bomber());
        deck.add(new Bomber2());
        deck.add(new Bomber3());
        deck.add(new BoostMorale());
        deck.add(new BountyShip());
        deck.add(new CloakedThreats());
        deck.add(new CommsOffline());
        deck.add(new Corsair());
        deck.add(new CosmicExistentialism());
        deck.add(new Distracted());
        deck.add(new DontPanic());
        deck.add(new DontPanic());
        deck.add(new DontPanic());
        deck.add(new DontPanic());
        deck.add(new DontPanic());
        deck.add(new DontPanic());
        deck.add(new Drone());
        deck.add(new Drone2());
        deck.add(new Flagship());
        deck.add(new FriendlyFire());
        deck.add(new Hijackers());
        deck.add(new Interceptor());
        deck.add(new InterceptorX());
        deck.add(new Invaders());
        deck.add(new Mercenary());
        deck.add(new Meteoroid());
        deck.add(new Nebula());
        deck.add(new Pandemic());
        deck.add(new PanelExplosion());
        deck.add(new Raiders());
        deck.add(new Raiders2());
        deck.add(new Raiders3());
        deck.add(new RobotUprising());
        deck.add(new ScoutingShip());
        deck.add(new SolarWinds());
        deck.add(new SpacePirates());
        deck.add(new SpacePirates2());
        deck.add(new SpacePirates3());
        deck.add(new TimeWarp());

        Collections.shuffle(deck);
    }

    public Threat draw(){
        if (deck.isEmpty())
            return null;
        return deck.remove(0);
    }

    public void discard(Threat threat){
        discardList.add(threat);
    }
}
