package view.components;

import com.sun.javafx.scene.traversal.Direction;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.List;

public class FlexBox extends Pane {

    private AlignHorizontal alignedHorizontal;
    private AlignVertical alignedVertical;
    private double gap;

    private List<Node> components;

    private Pane h;
    private Pane y;


    public FlexBox() {
        alignedHorizontal = AlignHorizontal.CENTER;
        alignedVertical = AlignVertical.CENTER;
        components = new ArrayList<>();
        gap = 25;
        setPadding(new Insets(10, 10, 10, 10));

        widthProperty().addListener(observable -> {update();});
        heightProperty().addListener(observable -> {update();});


        h = new Pane();
        y = new Pane();

        h.setStyle("-fx-background-color: #FFFFFF");
        h.setPrefSize(60, 3);
        h.setVisible(false);

        y.setStyle("-fx-background-color: #FFFFFF");
        y.setPrefSize(3, 60);
        y.setVisible(false);

        getChildren().addAll(h, y);

        this.update();
    }

    public void addComponent(Node node) {
        this.getChildren().add(node);
        this.components.add(node);
    }

    public void removeComponents(Node node) {
        this.components.remove(node);
        this.getChildren().remove(node);
    }

    public void setGap(double gap) {
        this.gap = gap;
    }
    public void showCenter(boolean show) {
        h.setVisible(show);
        y.setVisible(show);
    }

    public void setHAndYCenter() {
        this.setCenterPosition(h, (getWidth() / 2), (getHeight() / 2) );
        this.setCenterPosition(y, (getWidth() / 2), (getHeight() / 2) );
    }

    public void update() {
       this.setHAndYCenter();

        System.out.println("-----------------------------------------");
        for (int i = 0; i < components.size(); i++) {
//            System.out.println(i + " " + components.get(i).getId() + " " + calculateX(i) + " " + calculateY(i));
            this.setPosition(this.components.get(i), calculateX(i), calculateY(i));
        }
        System.out.println("-----------------------------------------");
    }


    // Calculate the positions
    private double calculateX(int place) {
        double x;

        if(this.alignedHorizontal == AlignHorizontal.START) {
            x = 0;
            for (int i = 0; i < place; i++) {
                x = x + this.components.get(i).getBoundsInLocal().getWidth() + gap;
            }
            return x;
        }

        if(this.alignedHorizontal == AlignHorizontal.CENTER) {

            if(this.components.size() == 1) {
                return getWidth() / 2 - (this.components.get(place).getBoundsInLocal().getWidth() / 2);
            }

            // if the size of components is even.
            if(this.components.size() % 2 == 0) {
                int centerNumber = Math.round(this.components.size() / 2);
                double center = getWidth() / 2;
                x = center;

                for(int i = 0; i < this.components.size(); i++) {
                    if(i == centerNumber) {
                       x = center;
                    }

                    double componentWidth = this.components.get(i).getBoundsInLocal().getWidth();

                    if(i < centerNumber) {
                        x = (i == 0) ? x - this.gap /2  - componentWidth : x - this.gap - componentWidth;
                    } else {
                        x = (i == centerNumber) ? x + this.gap / 2  : x + this.gap + componentWidth;
                    }

                    if(i == place) break;
                }

                System.out.println(place + " " + x + ((place < centerNumber) ? " before center" : " after center"));
                return x;
            }


        }


        if(this.alignedHorizontal == AlignHorizontal.END) {
            x = getWidth() - this.components.get(0).getBoundsInLocal().getWidth();

            for (int i = 0; i < place; i++) {
                x = x - this.components.get(i).getBoundsInLocal().getWidth() - this.gap;
            }
            return x;
        }

        return 0;
    }

    public double calculateY(double place) {
        return getHeight() / 2  - this.components.get(0).getBoundsInLocal().getHeight() / 2;
    }


    private void setPosition(Node node, double x, double y) {
        node.setTranslateX(getPostionXWithPadding(x));
        node.setTranslateY(getPostionYWithPadding(y));
    }

    // set the positions
    private void setCenterPosition(Node node, double x, double y) {
        node.setTranslateX(getPostionXWithPadding(x) - (node.getBoundsInLocal().getWidth() / 2));
        node.setTranslateY(getPostionYWithPadding(y) - (node.getBoundsInLocal().getHeight() / 2));
    }

    private double getPostionXWithPadding(double x) {
        return x;
    }

    private double getPostionYWithPadding(double y) {
        return y;
    }


}

enum AlignHorizontal {
    START, CENTER, END;
}

enum AlignVertical {
    START, CENTER, END;
}
