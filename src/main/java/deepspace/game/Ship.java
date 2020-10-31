package deepspace.game;

import deepspace.view.ImageUtil;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String name;
    private Image image;
    private int maxHull;
    private int hull;
    private int maxShield;
    private int shield;
    private int maxScanner;
    private List<CrewDice> scanner = new ArrayList<>();
    private List<CrewStation> crewStations = new ArrayList<>();
    private boolean shieldsOnline = true;

    private int hullLostThisRound = 0;

    public Ship(String name, String imageFilename, int maxHull, int maxShield, int maxScanner){
        this.name = name;
        this.image = ImageUtil.get(imageFilename);
        this.maxHull = maxHull;
        this.hull = maxHull;
        this.maxShield = maxShield;
        this.shield = maxShield;
        this.maxScanner = maxScanner;
    }

    public void hit(int times){
        for (int i = 0; i < times; ++i){
            if (shieldsOnline && shield > 0){
                adjShield(-1);
            }
            else {
                adjHull(-1);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }

    public int getMaxHull() {
        return maxHull;
    }

    public int getMaxShield() {
        return maxShield;
    }

    public int getMaxScanner() {
        return maxScanner;
    }

    public List<CrewStation> getCrewStations() {
        return crewStations;
    }

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }

    public void adjHull(int amount){
        this.hull += amount;
        if (this.hull < 0)
            this.hull = 0;
        if (this.hull > maxHull)
            this.hull = maxHull;
        if (amount < 0)
            hullLostThisRound -= amount;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public void adjShield(int amount){
        this.shield += amount;
        if (this.shield < 0)
            this.shield = 0;
        if (this.shield > maxShield)
            this.shield = maxShield;
    }

    public List<CrewDice> getScannerCrewDice() {
        return scanner;
    }

    public boolean addScannerCrewDice(CrewDice crewDice){
        if (this.scanner.size() < maxScanner) {
            this.scanner.add(crewDice);
            return true;
        }
        return false;
    }

    public void setShieldsOnline(boolean shieldsOnline) {
        this.shieldsOnline = shieldsOnline;
    }

    public boolean areShieldsOnline() {
        return shieldsOnline;
    }

    public int getHullLostThisRound() {
        return hullLostThisRound;
    }

    public void resetHullLostThisRound() {
        this.hullLostThisRound = 0;
    }
}
