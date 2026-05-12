package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;

public class VideoIntro extends Application {

    @Override
    
    public void start(Stage primaryStage) {
        // Usar getResource para archivos dentro de src/
        String videoPath;
        try {
            videoPath = getClass().getResource("/video_intro/QHAPAQ_Intro.mp4").toExternalForm();
        } catch (NullPointerException e) {
            System.out.println("❌ No se encontró el archivo de video en /video_intro/QHAPAQ_Intro.mp4");
            return;
        }

        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        // Ajustes del video
        mediaView.setPreserveRatio(true);
        mediaView.setFitWidth(1280);
        mediaView.setFitHeight(720);

         // Botón "Saltar Intro"
        Button skipButton = new Button("Saltar Intro");
        skipButton.setStyle("-fx-font-size: 16px; -fx-background-color: rgba(0,0,0,0.6); -fx-text-fill: white;");
        skipButton.setOnAction(e -> {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            primaryStage.close();
            Main.launchGameWindow();
        });

        // Contenedor principal con video + botón sobrepuesto
        StackPane root = new StackPane();
        root.getChildren().addAll(mediaView, skipButton);
        StackPane.setAlignment(skipButton, javafx.geometry.Pos.TOP_RIGHT);
        skipButton.setTranslateX(-20); // un poco hacia adentro
        skipButton.setTranslateY(20);

        Scene scene = new Scene(root, 1280, 720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("QHAPAQ | Calles que Hablan: Recuerdos y Leyendas de Lima");

        // FullScreen si está activado desde config (opcional)
        // primaryStage.setFullScreen(true);

        // Escuchar si cambia el tamaño para ajustar video
        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            mediaView.setFitWidth(newVal.doubleValue());
        });
        primaryStage.heightProperty().addListener((obs, oldVal, newVal) -> {
            mediaView.setFitHeight(newVal.doubleValue());
        });

        primaryStage.show();
        mediaPlayer.play();

        // Cuando termina el video, lanza el juego
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.dispose();
            primaryStage.close();
            Main.launchGameWindow();
        });
    } 

    public static void main(String[] args) {
        launch(args);
    }
}
