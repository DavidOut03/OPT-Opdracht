package view.components;

import com.sun.javafx.scene.traversal.Direction;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class FlexBox extends Pane {

    private AlignHorizontal alignedHorizontal;
    private AlignVertical alignedVertical;
    private AlignDirection direction;
    private double gap;



    public FlexBox() {
        alignedHorizontal = AlignHorizontal.CENTER;
        alignedVertical = AlignVertical.CENTER;
        direction = AlignDirection.HORIZONTAL;
        gap = 25;
        setPadding(new Insets(10, 10, 10, 10));

        setHeight(500);
        setWidth(500);
        widthProperty().addListener(observable -> {update();});
        heightProperty().addListener(observable -> {update();});
    }

    public void addComponent(Node node) {
        this.getChildren().add(node);
    }

    public void setGap(double gap) {
        this.gap = gap;
    }



    public void update() {
        for (int i = 0; i < getChildren().size(); i++) {
            Node child = getChildren().get(i);
            Bounds bounds = child.getBoundsInLocal();

            System.out.println();
            System.out.println(child.getId());

            double x = 0;
            double y = 0;

            switch (alignedVertical) {
                case START:
                    y = getPadding().getTop();
                    break;
                case CENTER:
                    y = (getHeight() / 2) - getPadding().getTop() - getPadding().getBottom();
                    break;
                case END:
                    y = getHeight() - getPadding().getBottom() - bounds.getHeight();
                    break;
            }

            switch (alignedHorizontal) {
                case START:
                    x = getPadding().getLeft();
                    break;
                case CENTER:
                    x = getWidth() / 2;
                    break;
                case END:
                    x = getWidth() - getPadding().getRight() - bounds.getWidth();
                    break;
            }

            x = calculateX(x, i, bounds.getWidth());
            y = calculateY(y, i, bounds.getHeight());

            child.setTranslateX(x);
            child.setTranslateY(y);
            System.out.println();
        }
    }

    private double calculateX(double x, int place, double nodeWidth) {
        if(this.direction == AlignDirection.HORIZONTAL) {
            if(this.alignedHorizontal == AlignHorizontal.START) {
                x = getPadding().getLeft();

                for(int xc = 0; xc < place; xc++) {
                    Node bro = getChildren().get(xc);
                    x = bro.getTranslateX() + bro.getBoundsInLocal().getWidth() + this.gap;
                }

                return x;
            }

            if(this.alignedHorizontal == AlignHorizontal.CENTER) {
                int centerNumber = Math.round(getChildren().size() / 2);
                double center = x;

                if(getChildren().size() % 2 == 0) {
                    // TODO left side has 1 gap to much
                    // TODO right side has 1 gap to little

                    if(place >= centerNumber) {
                      for(int i = centerNumber; i < place; i++) {
                         x = x + gap + getChildren().get(i).getBoundsInLocal().getWidth();
                      }
                    } else {
                        for(int i = centerNumber; i > place; i--) {
                            x = x - gap - getChildren().get(i).getBoundsInLocal().getWidth();
                        }
                    }

                    return x;
                }

            }


        }



        return x;
    }

    public double calculateY(double y, int place, double nodeWidth) {
        return y;
    }




}

enum AlignDirection {
    HORIZONTAL, VERTICAL;
}

enum AlignHorizontal {
    START, CENTER, END;
}

enum AlignVertical {
    START, CENTER, END;
}
