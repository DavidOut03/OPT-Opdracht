import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.Program;
import view.ProgramWindow;
import view.components.FlexBox;
import view.scenes.TestScene;

public class Main extends Application {

    private static Program program;
    public static Program getProgram() {return program;}

    @Override
    public void start(Stage stage) {
        Rectangle2D screen = Screen.getPrimary().getBounds();

        Button height = new Button();
        height.setText("Increase Height");
        height.setLayoutX(500);
        height.setLayoutY(500);
        height.setId("heightButton");

        Button width = new Button();
        width.setText("Increase Width");
        width.setLayoutX(100);
        width.setLayoutY(100);
        width.setId("widthButton");

        HBox hBox = new HBox();
        hBox.setStyle("-fx-background-color: #464653");
        hBox.setId("hbox");
        hBox.setPrefSize(50, 50);

        HBox hBox1 = new HBox();
        hBox1.setStyle("-fx-background-color: #464653");
        hBox1.setId("hbox1");
        hBox1.setPrefSize(50, 50);

        HBox hBox2 = new HBox();
        hBox2.setStyle("-fx-background-color: #464653");
        hBox2.setId("hbox2");
        hBox2.setPrefSize(50, 50);

        HBox hBox3  = new HBox();
        hBox3.setStyle("-fx-background-color: #464653");
        hBox3.setId("hbox3");
        hBox3.setPrefSize(50, 50);



        FlexBox root = new FlexBox();
        root.addComponent(hBox);
        root.addComponent(hBox1);
        root.addComponent(hBox2);
        root.addComponent(hBox3);

        root.setStyle("-fx-background-color: #32323C;");
        Scene scene = new Scene(root, Screen.getPrimary().getBounds().getWidth() - 20, Screen.getPrimary().getBounds().getHeight() - 200);
        Window window = scene.getWindow();


        height.setOnMouseClicked(event ->  scene.getWindow().setHeight(scene.getHeight() - 1));
        width.setOnMouseClicked(event -> scene.getWindow().setWidth(scene.getWidth() - 1));
        stage.setScene(scene);
        stage.setTitle("My JavaFX App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}