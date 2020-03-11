package Lab07;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class Lab07 extends Application {
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE,Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox main = new HBox();

        VBox legendBox = new VBox();

        HashMap<String, Integer> warningType = new HashMap<String, Integer>();

        File file = new File("src/Lab07/weatherwarnings-2015.csv");

        Scanner in = new Scanner(file);
        in.useDelimiter(",");

        while(in.hasNext()) {
            for (int i = 0; i < 5; i++) {
                in.next();
            }

            String temp = in.next();
            boolean isNew = true;

            for (String i : warningType.keySet()) {
                if (i.equals(temp)) {
                    warningType.replace(i, warningType.get(i) + 1);
                    isNew = false;
                    break;
                }
            }

            if (isNew) {
                warningType.put(temp, 1);
            }

            in.nextLine();
        }

        Canvas pie = new Canvas(300, 300);

        GraphicsContext pieGc = pie.getGraphicsContext2D();

        double total = 0;

        for (Integer i : warningType.values()) {
            total += i;
        }

        double centerx = 50;
        double centery = 50;
        double radius = 200;

        double curr = 0;
        int colourNum = 0;
        for (String i : warningType.keySet()) {
            pieGc.setFill(pieColours[colourNum]);
            colourNum++;
            double size = warningType.get(i) / total;

            pieGc.fillArc(centerx, centery, radius, radius, curr, size * 360, ArcType.ROUND);
            curr += size*360;
        }

        HBox[] legend = new HBox[warningType.size()];
        Canvas[] legendColor = new Canvas[warningType.size()];
        GraphicsContext[] legendGc = new GraphicsContext[warningType.size()];
        Label[] legendLabel = new Label[warningType.size()];

        int counter = 0;
        for (String i : warningType.keySet()) {
            legendLabel[counter] = new Label(i);
            counter++;
        }

        for(int i = 0; i < legend.length; i++){
            legendColor[i] = new Canvas(15, 15);
            legendGc[i] = legendColor[i].getGraphicsContext2D();

            legendGc[i].setFill(pieColours[i]);
            legendGc[i].fillRect(0, 0, 15, 15);

            legend[i] = new HBox();
            legend[i].getChildren().addAll(legendColor[i], legendLabel[i]);

            legendBox.getChildren().add(legend[i]);
        }

        main.getChildren().addAll(legendBox, pie);

        Scene scene = new Scene(main);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab 07");
        primaryStage.show();

    }
}
