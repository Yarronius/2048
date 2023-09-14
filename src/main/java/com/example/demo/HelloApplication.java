package com.example.demo;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        Button button1 = new Button("DECORATED");
        Button button2 = new Button("UNDECORATED");
        Button button3 = new Button("TRANSPARENT");
        Button button4 = new Button("UTILITY");
        Button button5 = new Button("UNIFIED");
        root.getChildren().addAll(button1, button2, button3,
                button4, button5);
        button1.setOnAction(event -> {
            newWindow(StageStyle.DECORATED);
        });
        button2.setOnAction(event -> {
            newWindow(StageStyle.UNDECORATED);
        });
        button3.setOnAction(event -> {
            newWindowTransparent();
        });
        button4.setOnAction(event -> {
            newWindow(StageStyle.UTILITY);
        });
        button5.setOnAction(event -> {
            newWindow(StageStyle.UNIFIED);
        });
        Scene scene = new Scene(root, 400, 350);
        stage.setTitle("Указание стиля окна");
        stage.setScene(scene);
        stage.show();

        if (Platform.isSupported(ConditionalFeature.UNIFIED_WINDOW)) {
            System.out.println("Стиль UNIFIED поддерживается");
        }
        else {
            System.out.println("Нет поддержки");
        }
    }

    public void newWindow(StageStyle style) {
        Stage window = new Stage(style);
        BorderPane pane = new BorderPane();
        pane.setBackground(Background.EMPTY);
        Button btn = new Button("Закрыть окно");
        pane.setCenter(btn);
        btn.setOnAction(event -> {
            window.close();
        });
        window.setScene(new Scene(pane, 400, 150));
        window.setTitle("Стиль " + window.getStyle());
        window.show();
        System.out.println(window.getStyle());
    }

    public void newWindowTransparent() { // Прозрачное окно
        Stage window = new Stage();
        SVGPath svg = new SVGPath();
        svg.setContent("M 50 50 L 350 50 L 300 250 L 200 200 L 100 250 z");
        svg.setFill(new Color(0.0, 1.0, 0.5, 1.0));
        svg.setEffect(new DropShadow());
        window.setTitle("Новое окно");
        StackPane pane = new StackPane();
        pane.setBackground(Background.EMPTY);
        Button btn = new Button("Закрыть окно");
        pane.getChildren().addAll(svg, btn);
        btn.setOnAction(event -> {
            window.close();
        });
        window.setScene(new Scene(pane, 400, 300, Color.TRANSPARENT));
        window.initStyle(StageStyle.TRANSPARENT);
        window.show();
    }

    @Override
    public void init() {
        System.out.println("getRaw(): " +
                this.getParameters().getRaw());
        System.out.println("getNamed(): " +
                this.getParameters().getNamed().keySet());
        System.out.println("getUnnamed(): " +
                this.getParameters().getUnnamed());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Метод stop()" + " " +
                Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        launch();
    }
}