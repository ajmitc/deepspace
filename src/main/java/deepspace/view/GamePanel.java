package deepspace.view;

import deepspace.Model;
import deepspace.game.CrewDice;
import deepspace.game.threat.Threat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;

public class GamePanel extends JPanel {
    private static final Point[] HULL_COORDS = {
            new Point(310, 435), // 0
            new Point(310, 395),
            new Point(310, 357),
            new Point(310, 320),
            new Point(310, 282),
            new Point(310, 245),
            new Point(310, 205),
            new Point(310, 166),
            new Point(310, 128), // 8
    };

    private static final Point[] SHIELD_COORDS = {
            new Point(360, 283), // 0
            new Point(360, 243),
            new Point(360, 205),
            new Point(360, 166),
            new Point(360, 128)
    };

    private static final int HULL_SHIELD_MARKER_SIZE = 30;
    private static final Color HULL_MARKER_COLOR = Color.GRAY;
    private static final Color SHIELD_MARKER_COLOR = Color.GREEN;

    private static final Point[] SCANNER_COORDS = {
            new Point(435, 85),
            new Point(505, 85),
            new Point(573, 85),
    };

    private static final Point[] UNASSIGNED_DICE_COORDS = {
            new Point(400, 855),
            new Point(470, 855),
            new Point(540, 855),
            new Point(610, 855),
            new Point(680, 855),
    };

    private static final Point[] THREAT_LEVEL_COORDS = {
            // Level 1
            new Point(860, 620),
            // Level 2
            new Point(860, 440),
            // Level 3
            new Point(860, 255),
            // Level 4
            new Point(860, 70),
    };

    private static final Point INTERNAL_THREAT_COORD = new Point(30, 60);

    private Model model;
    private View view;

    private Image boardImage;
    private int mx, my;

    public GamePanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        boardImage = ImageUtil.get("DSD6board.png");

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
                mx = e.getX();
                my = e.getY();
                refresh();
            }
        });
    }

    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;

        g.drawImage(model.getGame().getShip().getImage(), 0, 0, null);

        // Hull
        Point hullCoord = HULL_COORDS[model.getGame().getShip().getHull()];
        g.setColor(HULL_MARKER_COLOR);
        g.fill3DRect(hullCoord.x, hullCoord.y, HULL_SHIELD_MARKER_SIZE, HULL_SHIELD_MARKER_SIZE, true);

        // Shields
        Point shieldCoord = SHIELD_COORDS[model.getGame().getShip().getShield()];
        g.setColor(SHIELD_MARKER_COLOR);
        g.fill3DRect(shieldCoord.x, shieldCoord.y, HULL_SHIELD_MARKER_SIZE, HULL_SHIELD_MARKER_SIZE, true);

        // External Threats
        for (int level = 1; level <= 4; ++level) {
            List<Threat> threats = model.getGame().getExternalThreats().get(level);
            Point basePoint = THREAT_LEVEL_COORDS[level - 1];
            for (int i = 0; i < threats.size(); ++i){
                Threat threat = threats.get(i);
                g.drawImage(threat.getImage(), basePoint.x + (i * threat.getImage().getWidth(null)), basePoint.y, null);
            }
        }

        // Internal Threats
        for (int i = 0; i < model.getGame().getInternalThreats().size(); ++i){
            Threat threat = model.getGame().getInternalThreats().get(i);
            g.drawImage(threat.getImage(), INTERNAL_THREAT_COORD.x, INTERNAL_THREAT_COORD.y + (i * threat.getImage().getHeight(null)), null);
        }

        // Crew Dice
        for (int i = 0; i < model.getGame().getCrewDice().size(); ++i){
            CrewDice crewDice = model.getGame().getCrewDice().get(i);
            if (crewDice.isAssigned()){
                g.drawImage(crewDice.getActiveSide().getImage(), crewDice.getPx(), crewDice.getPy(), null);
            }
            else {
                Point p = UNASSIGNED_DICE_COORDS[i];
                g.drawImage(crewDice.getActiveSide().getImage(), p.x, p.y, null);
            }
        }

        g.setColor(Color.BLACK);
        g.drawString(mx + ", " + my, 50, 50);
    }

    public void refresh(){
        repaint();
    }
}
