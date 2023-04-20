package view.scenes;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import view.ProgramWindow;

import java.util.List;

public abstract class BaseScene extends Scene {

    private ProgramWindow window;
    private String cssFile;

    public BaseScene(ProgramWindow window, Group root, String cssFileName) {
        super(root);
        this.cssFile = cssFileName;
    }

    public ProgramWindow getProgramWindow() {return window;}

    public abstract void draw();

    public void addComponent(Node node) {
        getRoot().getChildrenUnmodifiable().add(node);
    }

    public void addComponents(List<Node> nodes) {
       getRoot().getChildrenUnmodifiable().addAll(nodes);
    }

    public void setComponents(List<Node> nodes) {
        getRoot().getChildrenUnmodifiable().setAll(nodes);
    }


    public List<Node> getComponents() {return getRoot().getChildrenUnmodifiable().subList(0, getRoot().getChildrenUnmodifiable().size());}


    public void showScene() {
        window.setCurrentScene(this);
    }

    public void hideScene() {
        window.setCurrentScene(new Scene(getRoot()));
    }
}
