package es.ieslosmontecillos.controlcircle;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class ControlCircle extends Application {

    private Circle circle;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        circle = new Circle(100);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);

        // Crear los botones
        Button enlargeButton = new Button("Enlarge");
        Button shrinkButton = new Button("Shrink");

        // Asignar los eventos a los botones
        enlargeButton.setOnAction(event -> enlargeCircle());
        shrinkButton.setOnAction(event -> shrinkCircle());

        // Crear un contenedor para los botones
        HBox buttonContainer = new HBox(enlargeButton, shrinkButton);
        buttonContainer.setSpacing(10);
        buttonContainer.setAlignment(Pos.CENTER);

        // Crear el contenedor principal de la interfaz
        BorderPane root = new BorderPane();
        root.setCenter(circle);
        root.setBottom(buttonContainer);

        // Crear la escena y mostrarla en la ventana
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void enlargeCircle() {
        circle.setRadius(circle.getRadius() + 10);
    }

    private void shrinkCircle() {
        circle.setRadius(circle.getRadius() - 10);
    }
}