
package Java;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SceneAddUserController {
    
    @FXML
    private Button ekleButton;
    
    @FXML
    private TextField uyeAd;
    @FXML
    private TextField uyeSoyad;
    
    @FXML
    private Label notification;
    
    public void ekleButton(ActionEvent e)
    {
        UyeYonetim.uyeEkle(uyeAd.getText(), uyeSoyad.getText());
        notification.setText("Uye eklendi.");
    }
    
    public void geriButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/MainScene.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)ekleButton.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması");
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("MainScene.fxml could not be loaded");
        }
    }
}
