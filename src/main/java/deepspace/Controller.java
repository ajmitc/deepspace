package deepspace;

import deepspace.game.Crew;
import deepspace.game.CrewDice;
import deepspace.game.Phase;
import deepspace.game.PhaseStep;
import deepspace.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void run(){
        while (true){
            switch (model.getGame().getPhase()){
                case SETUP:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.ROLL);
                            break;
                    }
                    break;
                case ROLL:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().getCrewDice().forEach(cd -> {
                                cd.roll();
                            });
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            List<CrewDice> threatDetectedDice = model.getGame().getCrewDice().stream().filter(cd -> cd.getActiveSide() == Crew.THREAT_DETECTED).collect(Collectors.toList());
                            List<CrewDice> toLock = new ArrayList<>();
                            for (CrewDice crewDice: threatDetectedDice){
                                if (model.getGame().getShip().addScannerCrewDice(crewDice)){
                                    toLock.add(crewDice);
                                }
                            }
                            model.getGame().getCrewDice().removeAll(toLock);
                            model.getGame().setPhase(Phase.CHECK_SCANNERS);
                            break;
                    }
                    break;
                case CHECK_SCANNERS:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            if (model.getGame().getShip().getScannerCrewDice().size() == model.getGame().getShip().getMaxScanner()){
                                model.getGame().getReturningCrewDice().addAll(model.getGame().getShip().getScannerCrewDice());
                                model.getGame().getShip().getScannerCrewDice().clear();
                                // TODO Draw Threat
                            }
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.ASSIGN_CREW);
                            break;
                    }
                    break;
                case ASSIGN_CREW:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.DRAW_THREAT);
                            break;
                    }
                    break;
                case DRAW_THREAT:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.ROLL_THREAT);
                            break;
                    }
                    break;
                case ROLL_THREAT:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case ROLL_THREAT_SEND_CREW_TO_INFIRMARY:
                            // TODO Tell user to choose dice to send to infirmary
                            return;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.GATHER_CREW);
                            break;
                    }
                    break;
                case GATHER_CREW:
                    switch (model.getGame().getPhaseStep()){
                        case START_PHASE:
                            model.getGame().setPhaseStep(PhaseStep.END_PHASE);
                            break;
                        case END_PHASE:
                            model.getGame().setPhase(Phase.ROLL);
                            break;
                    }
                    break;
            }
        }
    }
}
