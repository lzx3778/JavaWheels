package tutorials.javaFX;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by lzx on 2017/3/27.
 */
public class MovingLine extends Application implements Runnable {

    int x = 40;
    Canvas canvas = new Canvas(300, 250);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        drawShapes(gc);

        Button button = new Button("GO");
        button.setOnAction(ActionEvent -> {
            x = 100;
            drawShapes(gc);
        });

        root.getChildren().add(canvas);
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Thread thread = new Thread(this);
        thread.start();
    }

    private void drawShapes(GraphicsContext gc) {
        gc.clearRect(0, 0, 100, 100);
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(x, 10, x - 30, 40);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            x++;
            System.out.println(x);
            drawShapes(gc);
        }
    }
}