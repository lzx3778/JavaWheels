package javaFX;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by lenovo on 2017-1-31.
 */
public class DrawFX extends Application{

    Stage stage;
    Scene scene;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(new Group(), 300, 300);
        ObservableList<Node> content = ((Group)scene.getRoot()).getChildren();
        stage.setScene(scene);

        content.add(blendMode());

        stage.show();
    }

    static Node blendMode(){
        Rectangle rect = new Rectangle();

        rect.setX(50);
        rect.setY(50);
        rect.setWidth(50);
        rect.setHeight(50);
        rect.setFill(Color.BLUE);

        Circle c = new Circle();
        c.setFill(Color.rgb(255, 0, 0, 0.5f));
        c.setCenterX(50);
        c.setCenterY(50);
        c.setRadius(25);

        Group g = new Group();
        g.setBlendMode(BlendMode.MULTIPLY);//blendMode混合模式//multiply：按比例增大
        g.getChildren().add(rect);
        g.getChildren().add(c);

        return g;
    }
}
