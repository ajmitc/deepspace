package deepspace;

import deepspace.view.View;

public class Main {
    public static void main(String ... args){
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
        view.getFrame().setVisible(true);
        controller.run();
    }
}
