package view;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ProgramWindow {

    private String title;
    private double width;
    private double height;
    private Scene currentScene;
    private Stage stage;
    private Group root;

    private javafx.stage.Window window;

    public ProgramWindow(String title, Stage stage, double width, double height) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.stage = stage;
        this.root = new Group();
    }

    public Group getRoot() {return root;}

    public double getScreenHeight() {return height;}
    public void setScreenHeight(double screenHeight) {
        this.height = screenHeight;
        window.setHeight(screenHeight);
    }

    public double getSreenWidth() {return width;}
    public void setScreenWidth(double screenWidth) {
        this.width = screenWidth;
        window.setWidth(screenWidth);
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
        stage.setTitle(title);
    }


    public Scene getCurrentScene() {return this.currentScene;}
    public void setCurrentScene(Scene scene) {
        this.currentScene = scene;
        this.window = scene.getWindow();
    }
}
