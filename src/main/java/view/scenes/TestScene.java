package view.scenes;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import view.ProgramWindow;


public class TestScene extends BaseScene {

    public TestScene(ProgramWindow window, Group root) {
        super(window, root, "test");
    }


    @Override
    public void draw() {

        Button height = new Button();
        height.setText("Increase Height");
        height.setOnMouseClicked(event ->  getProgramWindow().setScreenHeight(getProgramWindow().getScreenHeight() - 1));


        Button width = new Button();
        width.setText("Increase Width");
        width.setOnMouseClicked(event -> getProgramWindow().setScreenHeight(getProgramWindow().getSreenWidth() - 1));

        addComponent(height);
        addComponent(width);
    }
}
