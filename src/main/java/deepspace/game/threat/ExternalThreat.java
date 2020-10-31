package deepspace.game.threat;

public class ExternalThreat extends Threat{
    public ExternalThreat(String name, int startingHealth, String filename, Integer ... activationValues){
        super(name, true, startingHealth, filename, activationValues);
    }
}
