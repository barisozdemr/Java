
package Java;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneDeleteUserController {
    
    @FXML
    private ScrollPane uyeScrollPane;
    
    private Label oncekiLabel;
    private int secilenUserID;
    
    public void initialize()
    {
        uyeScrollPane.setStyle("-fx-background: #202020;-fx-focus-color: transparent;-fx-faint-focus-color: transparent;"
                + "-fx-border-width: 2;-fx-border-color: #606060");
        
        buildScrollPane();
    }
    
    public void buildScrollPane()
    {
        VBox vbox = new VBox();
        
        for(Uye u : UyeYonetim.getUyeListesi())
        {
            Label label = new Label("ID:"+u.getId()+"  |  Ad:"+u.getAd()+"  |  Soyad:"+u.getSoyad());
            
            label.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15;");
            
            label.setOnMouseClicked(event -> selectUser(event, u.getId(), label));
            
            vbox.getChildren().add(label);
        }
        
        uyeScrollPane.setContent(vbox);
    }
    
    public void selectUser(MouseEvent e, int id, Label label)
    {
        if(oncekiLabel != null)
        {
            oncekiLabel.setStyle("-fx-background-color: transparent;-fx-font-size: 15;");
        }
        
        label.setStyle("-fx-background-color: #606060;-fx-font-size: 15;");
        secilenUserID = id;
        oncekiLabel = label;
    }
    
    public void geriButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/MainScene.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)uyeScrollPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması");
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("MainScene.fxml could not be loaded");
        }
    }
    
    public void silButton(ActionEvent e)
    {
        UyeYonetim.uyeSil(secilenUserID);
        buildScrollPane();
    }
}
