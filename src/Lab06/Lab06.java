package Lab06;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class Lab06 extends Application {
    private static double[] avgHousingPricesByYear = {247381.0,264171.4,287715.3,294736.1,308431.4,322635.9,340253.0,363153.7};
    private static double[] avgCommercialPricesByYear = {1121585.3,1219479.5,1246354.2,1295364.8,1335932.6,1472362.0,1583521.9,1613246.3};

    private static String[] ageGroups = {"18-25", "26-35", "36-45", "46-55", "56-65", "65+"};
    private static int[] purchasesByAgeGroup = {648, 1021, 2453, 3173, 1868, 2247};
    private static Color[] pieColours = {Color.AQUA, Color.GOLD, Color.DARKORANGE,Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM};
    @Override

    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();

        Canvas bar = new Canvas(300, 300);

        GraphicsContext barGc = bar.getGraphicsContext2D();

        double big = 0;
        for(int i = 0; i < avgHousingPricesByYear.length; i++){
            if(avgHousingPricesByYear[i] > big){
                big = avgHousingPricesByYear[i];
            }
        }

        for(int i = 0; i < avgCommercialPricesByYear.length; i++){
            if(avgCommercialPricesByYear[i] > big){
                big = avgCommercialPricesByYear[i];
            }
        }

        int max = 250;

        barGc.setFill(Color.RED);
        for(int i = 0; i < avgHousingPricesByYear.length; i++){
            double size = avgHousingPricesByYear[i] / big;

            barGc.fillRect( i * 40 + 20, 280 - (max * size),7, max * size );
        }

        barGc.setFill(Color.BLUE);
        for(int i = 0; i < avgCommercialPricesByYear.length; i++){
            double size = avgCommercialPricesByYear[i] / big;

            barGc.fillRect( i * 40 + 20 + 7, 280 - (max * size),7, max * size );
        }


        Canvas circle = new Canvas(300, 300);
        GraphicsContext cirGc = circle.getGraphicsContext2D();

        double total = 0;

        for(int i = 0; i < purchasesByAgeGroup.length; i++){
            total += purchasesByAgeGroup[i];
        }

        double centerx = 50;
        double centery = 50;
        double radius = 200;

        double curr = 0;
        for(int i = 0; i < purchasesByAgeGroup.length; i++){
            cirGc.setFill(pieColours[i]);
            double size = purchasesByAgeGroup[i] / total;

            cirGc.fillArc(centerx, centery, radius, radius, curr, size * 360, ArcType.ROUND);
            curr += size*360;
        }


        hbox.getChildren().addAll(bar, circle);

        Scene scene = new Scene(hbox);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab06");
        primaryStage.show();
    }
}
