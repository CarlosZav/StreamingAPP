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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.transform.Rotate;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloController {

    @FXML
    private TextField UserField;

    @FXML
    private PasswordField PasswordFieldx;

    @FXML
    private ImageView LogoImage;

    @FXML
    private Button OnSesion;

    @FXML
    private Label SesionIncorrecta;


    @FXML
    public void initialize() throws IOException{

            RotateTransition rotate = new RotateTransition();
            rotate.setNode(LogoImage);
            rotate.setDuration(Duration.millis(2000));
            rotate.setInterpolator(Interpolator.LINEAR);
            rotate.setByAngle(360);
            rotate.setAxis(Rotate.Z_AXIS);
            rotate.play();

    }

    @FXML
    void OnSesionClick(MouseEvent event) {

        SesionIncorrecta.setText(null);


        if (UserField.getText().equals("carlos") && PasswordFieldx.getText().equals("123")) {

            Node source = (Node) event.getSource();
            Stage stage2 = (Stage) source.getScene().getWindow();
            stage2.close();

            FXMLLoader fxmlLoader =  new FXMLLoader(HelloApplication.class.getResource("SeleccionVen.fxml"));
            Parent root = null;
            try {
                root = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        }
        else {
            SesionIncorrecta.setText("usuario y/o contraseña incorrecta");

        }
    }
}