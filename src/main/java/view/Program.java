package view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.scenes.TestScene;

import java.util.ArrayList;
import java.util.List;

public class Program {

    private ProgramWindow programWindow;
    private Stage stage;

    public Program(Stage stage, ProgramWindow programWindow) {
        this.programWindow = programWindow;
        this.stage = stage;
    }

    public Program() {
        this.programWindow = null;
        this.stage = null;
    }

    public void setWindow(Stage stage, ProgramWindow programWindow) {
        this.stage = stage;
        this.programWindow = programWindow;
    }


    public void start() {
        this.stage.setScene(programWindow.getCurrentScene());
        this.stage.setTitle(programWindow.getTitle());
        this.stage.show();
    }

}
