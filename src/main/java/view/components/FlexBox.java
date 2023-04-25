package view.components;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FlexBox extends Pane {

    private AlignHorizontal alignedHorizontal;
    private AlignVertical alignedVertical;
    private FlexDirection flexDirection;

    private List<Node> components;
    private HashMap<Integer, List<Node>> rows;



    private double gap;
    private Pane h, y;




    public FlexBox() {
        alignedHorizontal = AlignHorizontal.CENTER;
        alignedVertical = AlignVertical.CENTER;
        flexDirection = FlexDirection.ROW;
        components = new ArrayList<>();
        gap = 25;

        setPrefSize(200, 100);
        setStyle("-fx-background-color: #32323C;");
        widthProperty().addListener(observable -> update());
        heightProperty().addListener(observable -> update());


        h = new Pane();
        h.setStyle("-fx-background-color: #FFFFFF");
        h.setVisible(false);

        y = new Pane();
        y.setStyle("-fx-background-color: #FFFFFF");
        y.setVisible(false);

        getChildren().addAll(h, y);

        this.update();
    }

    public void addComponent(Node node) {
        this.components.add(node);
        this.getChildren().add(node);
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

       if(flexDirection == FlexDirection.ROW) {
           rows = new HashMap<>();
           rows.put(0, new ArrayList<>());
           int currentRow = rows.size() - 1;
           double calculatedWidth = 0;

           for(int i = 0; i < this.components.size(); i++) {
               Node currentChild = this.components.get(i);
               double childWidth = currentChild.getBoundsInLocal().getWidth();
               double nextWidth = (i == 0)? childWidth : calculatedWidth + childWidth + this.gap;

               if(nextWidth > getAvalibleWidth() && rows.get(currentRow).size() >= 1) {
                   rows.put(rows.size(), new ArrayList<>());
                   currentRow = rows.size() - 1;
               }

               rows.get(currentRow).add(currentChild);
               calculatedWidth = (nextWidth > getAvalibleWidth())? childWidth : nextWidth;
           }


           rows.forEach((rowNumber, nodes) -> {
               double y = calculateY(rowNumber);

               System.out.println();
               for(int i = 0; i < nodes.size(); i++) {
                   this.setPosition(nodes.get(i), this.calculateXRow(rowNumber, i), y);
               }
           });

           return;
       }

        for (int i = 0; i < this.components.size(); i++) {
            this.setPosition(this.components.get(i), this.calculateXColumn(i), this.calculateY(i));
        }
    }

    private double calculateXRow(int row, int place) {
        double rowWidth = getRowWidth(row);
        double xMin = 0;
        
        if(this.alignedHorizontal == AlignHorizontal.START) xMin = getPadding().getLeft();
        if(this.alignedHorizontal == AlignHorizontal.CENTER) xMin = getWidth() / 2 - rowWidth / 2;
        if(this.alignedHorizontal == AlignHorizontal.END) xMin = getWidth() - rowWidth - getPadding().getRight();


        double x = xMin;
        for (int i = 0; i < place; i++) {
            double childWidth = this.rows.get(row).get(i).getBoundsInLocal().getWidth();
            x += (i == place) ? childWidth : childWidth + gap;
            if(i == place) break;
        }

        return x;
    }

    public double calculateXColumn(int column) {
        double xMin = 0;
        if(this.alignedHorizontal == AlignHorizontal.START) xMin = getPadding().getLeft();
        if(this.alignedHorizontal == AlignHorizontal.CENTER) xMin = getWidth() / 2 - getColumnWidth(column) / 2;
        if(this.alignedHorizontal == AlignHorizontal.END) xMin = getWidth() - getColumnWidth(column) - getPadding().getRight();
        return xMin;
    }

    public double calculateY(int item) {
        double yMin = 0;
        double itemHeight = (flexDirection == FlexDirection.ROW) ? this.getTotalRowsHeight() : this.getTotalColumnsHeight();

        if(this.alignedVertical == AlignVertical.START) yMin = getPadding().getTop();
        if(this.alignedVertical == AlignVertical.CENTER) yMin = getHeight() / 2 - itemHeight / 2;
        if(this.alignedVertical == AlignVertical.END) yMin = getHeight() - itemHeight - getPadding().getBottom();

        double y = yMin;
        for(int i = 0; i < item; i++) {
            y += (this.flexDirection == FlexDirection.ROW) ? ( (i == item) ? getRowHeight(i) : getRowHeight(i) + gap) : ( (i == item) ? getColumnHeight(i) : getColumnHeight(i) + gap);
            if(i == item) break;
        }


        return y;
    }



    private void setPosition(Node node, double x, double y) {
        node.setTranslateX(x);
        node.setTranslateY(y);
    }

    // set the positions
    private void setCenterPosition(Node node, double x, double y) {
        node.setTranslateX(x - (node.getBoundsInLocal().getWidth() / 2));
        node.setTranslateY(y - (node.getBoundsInLocal().getHeight() / 2));
    }


    // private Position methods
    private double getAvalibleWidth() {
        return getWidth() - getPadding().getLeft() - getPadding().getRight();
    }

    private double getAvalibleHeight() {
        return getHeight() - getPadding().getTop() - getPadding().getBottom();
    }

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

    private double getColumnWidth(int column) {
        return (this.components.get(column) == null) ? 0 : this.components.get(column).getBoundsInLocal().getWidth();
    }

    private double getRowHeight(int row) {
        if(rows.get(row) == null) return 0;

        double max = 0;
        for (int i = 0; i < rows.get(row).size(); i++) {
            if(rows.get(row).get(i).getBoundsInLocal().getHeight() > max) max = rows.get(row).get(i).getBoundsInLocal().getHeight();
        }

        return max;
    }

    private double getColumnHeight(int column) {
        return (this.components.get(column) == null)? 0 : this.components.get(column).getBoundsInLocal().getHeight();
    }

    private double getTotalRowsHeight() {
        double calculated = 0;
        for (int i = 0; i < rows.size(); i++) {
            calculated += (i == 0) ? getRowHeight(i) : getRowHeight(i) + gap;
        }
        return calculated;
    }

    private double getTotalColumnsHeight() {
        double calculated = 0;

        for(int i = 0; i < this.components.size(); i++) {
            calculated += (i == 0) ? getColumnHeight(i) : getColumnHeight(i) + gap;
        }

        return calculated;
    }


}

enum AlignHorizontal {
    START, CENTER, END;
}

enum AlignVertical {
    START, CENTER, END;
}

enum FlexDirection {
    ROW, COLUMN;
}
