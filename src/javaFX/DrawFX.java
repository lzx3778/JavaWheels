package javaFX;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
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

        final PhongMaterial redMaterial = new PhongMaterial();
        redMaterial.setSpecularColor(Color.ORANGE);
        redMaterial.setDiffuseColor(Color.RED);

        final PhongMaterial blueMaterial = new PhongMaterial();
        blueMaterial.setDiffuseColor(Color.BLUE);
        blueMaterial.setSpecularColor(Color.LIGHTBLUE);

        final PhongMaterial greyMaterial = new PhongMaterial();
        greyMaterial.setDiffuseColor(Color.DARKGREY);
        greyMaterial.setSpecularColor(Color.GREY);

        final Box red = new Box(400, 400, 400);
        red.setMaterial(redMaterial);

        final Sphere blue = new Sphere(200);
        blue.setMaterial(blueMaterial);

        final Cylinder grey = new Cylinder(5, 100);
        grey.setMaterial(greyMaterial);
        return g;
    }
}
