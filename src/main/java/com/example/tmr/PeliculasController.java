package com.example.tmr;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PeliculasController<x> {

    @FXML
    private Pane ComediaPane;

    @FXML
    private Button PopularesButton;

    @FXML
    private Button ComediaButton;

    @FXML
    private Pane PopularesPane;

    @FXML
    private ImageView SiliconImage;

    @FXML
    private MediaView  ReproMedia;;

    private MediaPlayer mediaPlayer;

    @FXML
    private Pane ReproPane;

    @FXML
    private Pane InVidPane;

    @FXML
    private ImageView PlayImageB;

    @FXML
    private ImageView PauseImageB;

    @FXML
    private ImageView ResetImageB;

    @FXML
    private ImageView BackImageB;

    @FXML
    private ImageView BreakingBadImageB;

    @FXML
    private ImageView GameOTImageB;

    @FXML
    private ImageView LaCasaDPImageB;

    @FXML
    private ImageView OrangeImageB;

    @FXML
    private ImageView StrangerImageB;

    @FXML
    private ImageView Logodos;

    @FXML
    private Pane pane1;

    @FXML
    private Pane pane2;

    @FXML
    private Pane pane3;

    @FXML
    private AnchorPane CategoryPane;


    @FXML
    private void handleButtonAction (ActionEvent event){
        if(event.getSource()== PopularesButton){
            PopularesPane.toFront();

            RotateTransition rotate = new RotateTransition();
            rotate.setNode(Logodos);
            rotate.setDuration(Duration.millis(1000));
            rotate.setInterpolator(Interpolator.LINEAR);
            rotate.setByAngle(360);
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.play();

        } else if (event.getSource()==ComediaButton){
            ComediaPane.toFront();

            RotateTransition rotate = new RotateTransition();
            rotate.setNode(Logodos);
            rotate.setDuration(Duration.millis(1000));
            rotate.setInterpolator(Interpolator.LINEAR);
            rotate.setByAngle(360);
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.play();
        }
    }

    @FXML
    public void OnSiliconClick(MouseEvent event) throws IOException{

        ReproPane.toFront();

        String cadena = this.getClass().getResource("/SiliconValleyVid.mp4").getPath();
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/SiliconValleyVid.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        ReproMedia.setMediaPlayer(mediaPlayer);

    }

    @FXML
    void OnCasaClick(MouseEvent event) {
        ReproPane.toFront();

        String cadena = this.getClass().getResource("/CasaPapelVid.mp4").getPath();
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/CasaPapelVid.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        ReproMedia.setMediaPlayer(mediaPlayer);
    }

    @FXML
    void OnGameOTClick(MouseEvent event) {
        ReproPane.toFront();

        String cadena = this.getClass().getResource("/GameofThronesVid.mp4").getPath();
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/GameofThronesVid.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        ReproMedia.setMediaPlayer(mediaPlayer);
    }

    @FXML
    void OnOrangeClick(MouseEvent event) {
        ReproPane.toFront();

        String cadena = this.getClass().getResource("/OrangeVid.mp4").getPath();
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/OrangeVid.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        ReproMedia.setMediaPlayer(mediaPlayer);
    }

    @FXML
    void OnStrangerClick(MouseEvent event) {
        ReproPane.toFront();

        String cadena = this.getClass().getResource("/StrangerThingsVid.mp4").getPath();
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/StrangerThingsVid.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        ReproMedia.setMediaPlayer(mediaPlayer);
    }

    @FXML
    void onBreakingClick(MouseEvent event) {
        ReproPane.toFront();

        String cadena = this.getClass().getResource("/BreakingBadVid.mp4").getPath();
        mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource("/BreakingBadVid.mp4").toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        ReproMedia.setMediaPlayer(mediaPlayer);
    }

    @FXML
    void OnBackClick(MouseEvent event) {
        ReproPane.toBack();
        mediaPlayer.pause();
        mediaPlayer = null;
    }

    public void animacion (double duracion, Node node, double ancho)
    {

        TranslateTransition t = new TranslateTransition(Duration.seconds(duracion), node);
        t.setByX(ancho);
        t.play();

    }

   public void initialize(){
        animacion(0.5, pane2, -2000);
        animacion(0.5, pane3, -2000);
        pane2.toBack();
        pane3.toBack();

        CategoryPane.toFront();
    }

    int show=1;
    int showb=2;


    @FXML
    void next(MouseEvent event) {
        if (show == 0) {
            animacion(0.5, pane1, +2000);
            pane1.toFront();
            animacion(0.5, pane3, -2000);
            pane3.toBack();

            CategoryPane.toFront();

            show = 1;
            showb= 2;

        } else if (show == 1) {
            animacion(0.5, pane2, +2000);
            pane2.toFront();
            animacion(0.5, pane1, -2000);
            pane1.toBack();

            CategoryPane.toFront();

            show = 2;
            showb = 0;

        } else if (show == 2) {
            animacion(0.5, pane3, +2000);
            pane3.toFront();
            animacion(0.5, pane2, -2000);
            pane2.toBack();

            CategoryPane.toFront();

            show = 0;
            showb = 1;

        }
    }

    @FXML
    void back(MouseEvent event) {
        if(showb==0) {
            animacion(0.5, pane1, +2000);
            pane1.toFront();
            animacion(0.5, pane2, -2000);
            pane2.toBack();

            CategoryPane.toFront();

            show=1;
            showb=2;
        }else

        if(showb==1)
        {
            animacion(0.5, pane2, +2000);
            pane2.toFront();
            animacion(0.5, pane3, -2000);
            pane3.toBack();

            CategoryPane.toFront();

            show=2;
            showb=0;

        }else if(showb==2)
        {
            animacion(0.5, pane3, +2000);
            pane3.toFront();
            animacion(0.5, pane1, -2000);
            pane1.toBack();

            CategoryPane.toFront();

            show=0;
            showb=1;
        }

    }

    @FXML
    void OnMediaClick(MouseEvent event) {
        InVidPane.toBack();
    }

    @FXML
    void OnPauseClick(MouseEvent event) {
            mediaPlayer.pause();
    }

    @FXML
    void OnPlayClick(MouseEvent event) {
            mediaPlayer.play();
    }

    @FXML
    void OnResetClick(MouseEvent event) {
            mediaPlayer.stop();
            mediaPlayer.play();
    }

    @FXML
    void OnMediaMoves(MouseEvent event) {
        InVidPane.toFront();
    }
}