package deepspace.game;

import deepspace.view.ImageUtil;

import java.awt.*;

public enum Crew {
    COMMANDER("Commander.png"),
    SCIENCE("Science.png"),
    ENGINEERING("Engineering.png"),
    TACTICAL("Tactical.png"),
    MEDICAL("Medical.png"),
    THREAT_DETECTED("ThreatDetected.png");

    private String filename;
    private Image image;
    Crew(String filename){
        this.filename = filename;
        this.image = ImageUtil.get(filename);
    }

    public String getFilename() {
        return filename;
    }

    public Image getImage() {
        return image;
    }

    public String toString(){
        return name();
    }
}
