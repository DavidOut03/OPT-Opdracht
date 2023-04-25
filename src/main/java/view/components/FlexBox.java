package view.components;

import com.sun.javafx.scene.traversal.Direction;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FlexBox extends Pane {

    private AlignHorizontal alignedHorizontal;
    private AlignVertical alignedVertical;
    private double gap;

    private List<Node> components;
    private HashMap<Integer, List<Node>> rows;

    private Pane h;
    private Pane y;


    public FlexBox() {
        alignedHorizontal = AlignHorizontal.CENTER;
        alignedVertical = AlignVertical.CENTER;
        components = new ArrayList<>();
        gap = 25;
        setPadding(new Insets(10, 10, 10, 10));

        widthProperty().addListener(observable -> update());
        heightProperty().addListener(observable -> update());


        h = new Pane();
        y = new Pane();

        h.setStyle("-fx-background-color: #FFFFFF");
        h.setVisible(false);

        y.setStyle("-fx-background-color: #FFFFFF");
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

    public void removeComponent(int i) {
        this.components.remove(i);
        this.getChildren().remove(i);
    }

    public void addComponents(Node ...nodes) {
        this.getChildren().addAll(nodes);
        this.components.addAll(Arrays.asList(nodes));
    }

    public void setGap(double gap) {
        this.gap = gap;
    }
    public void showCenter(boolean show) {
        h.setVisible(show);
        y.setVisible(show);
    }

    public void setHAndYCenter() {
        y.setPrefSize(3, getHeight());
        h.setPrefSize(getWidth(), 3);
        this.setCenterPosition(h, (getWidth() / 2), (getHeight() / 2) );
        this.setCenterPosition(y, (getWidth() / 2), (getHeight() / 2) );
    }

    public void update() {
       this.setHAndYCenter();

        rows = new HashMap<>();
        rows.put(0, new ArrayList<>());
        int currentRow = rows.size() - 1;
        double calculatedWidth = 0;

        for(int i = 0; i < this.components.size(); i++) {
            Node currentChild = this.components.get(i);
            double childWidth = currentChild.getBoundsInLocal().getWidth();
            double nextWidth = (i == 0)? childWidth : calculatedWidth + childWidth + this.gap;

            if(nextWidth > getWidth()) {
                rows.put(rows.size(), new ArrayList<>());
                currentRow = rows.size() - 1;
            }

            rows.get(currentRow).add(currentChild);
            calculatedWidth = (nextWidth > getWidth())? childWidth : nextWidth;
        }


        rows.forEach((rowNumber, nodes) -> {
            double y = rowNumber * 150;

            System.out.println();
            for(int i = 0; i < nodes.size(); i++) {
                this.setPosition(nodes.get(i), this.calculateX(rowNumber, i), y);
            }
            System.out.println();

        });

    }

    private double calculateX(int row, int place) {
        double rowWidth = getRowWidth(row);
        double rowMin = 0;
        
        if(this.alignedHorizontal == AlignHorizontal.START) rowMin = 0;
        if(this.alignedHorizontal == AlignHorizontal.CENTER) rowMin = getWidth() / 2 - rowWidth / 2;
        if(this.alignedHorizontal == AlignHorizontal.END) rowMin = getWidth() - rowWidth;


        double x = rowMin;
        for (int i = 0; i < place; i++) {
            double childWidth = this.rows.get(row).get(i).getBoundsInLocal().getWidth();
            x += (i == place) ? childWidth : childWidth + gap;
            if(i == place) break;
        }

        return x;
    }

    // Calculate the positions
//    private double calculateX(int row, int place) {
//        List<Node> rowComponents = this.rows.get(row);
//        double x;
//
//
//        if(this.alignedHorizontal == AlignHorizontal.START) {
//            x = 0;
//            for (int i = 0; i < place; i++) {
//                x = x + rowComponents.get(i).getBoundsInLocal().getWidth() + gap;
//            }
//            return x;
//        }
//
//        if(this.alignedHorizontal == AlignHorizontal.CENTER) {
//            double center = getWidth() / 2;
//            x = center;
//
//            if(rowComponents.size() == 1) {
//                return x - (rowComponents.get(place).getBoundsInLocal().getWidth() / 2);
//            }
//
//            // if the size of components is even.
//            if(rowComponents.size() % 2 == 0) {
//                int centerNumber = Math.round(rowComponents.size() / 2);
//
//
//                for(int i = 0; i < rowComponents.size(); i++) {
//                    if(i == centerNumber) {
//                       x = center;
//                    }
//                    double componentWidth = rowComponents.get(i).getBoundsInLocal().getWidth();
//                    if(i < centerNumber) {
//                        x = (i == 0) ? x - this.gap /2  - componentWidth : x - this.gap - componentWidth;
//                    } else {
//                        x = (i == centerNumber) ? x + this.gap / 2  : x + this.gap + componentWidth;
//                    }
//                    if(i == place) break;
//                }
//
//                return x;
//            }
//
//
//            if(rowComponents.size() %  2 != 0) {
//                int centerComponentNumber = Math.round(rowComponents.size() / 2 + rowComponents.size() % 2) - 1;
//                double centerComponentWidth = rowComponents.get(centerComponentNumber).getBoundsInLocal().getWidth();
//
//                for(int i = 0; i < rowComponents.size(); i++) {
//                    double componentWidth = rowComponents.get(i).getBoundsInLocal().getWidth();
//
//                    if(i == centerComponentNumber && place == centerComponentNumber) {
//                       return  (getWidth() / 2) - componentWidth / 2;
//                    }
//                    if(i < centerComponentNumber) {
//                        x = (i == 0) ? x - (centerComponentWidth / 2) - this.gap - componentWidth : x - this.gap - componentWidth;
//                    } else {
//                        x = (i == centerComponentNumber) ? (getWidth() / 2) - componentWidth / 2: x + this.gap + componentWidth;
//                    }
//
//                    if(i == place) break;
//                }
//
//                return x;
//            }
//
//        }
//
//
//        if(this.alignedHorizontal == AlignHorizontal.END) {
//            x = getWidth() - rowComponents.get(0).getBoundsInLocal().getWidth();
//
//            for (int i = 0; i < place; i++) {
//                x = x - rowComponents.get(i).getBoundsInLocal().getWidth() - this.gap;
//            }
//            return x;
//        }
//
//        return 0;
//    }

    public double calculateY(int place) {
        return getHeight() / 2;
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


    // private Position methods
    private double getRowWidth(int row) {
        if(rows.get(row) == null) return 0;

        double calculated = 0;
        for (int i = 0; i < rows.get(row).size(); i++) {
            Node child = rows.get(row).get(i);
            double childWidth = child.getBoundsInLocal().getWidth();
            calculated += (i == 0) ? childWidth : childWidth + gap;
        }

        return calculated;
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
