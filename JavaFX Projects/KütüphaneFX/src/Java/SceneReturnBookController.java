
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

public class SceneReturnBookController {
    
    @FXML
    private ScrollPane kitapScrollPane;
    @FXML
    private Label notification;
    
    private Label oncekiLabel;
    private int secilenKitapID;
    
    public void initialize()
    {
        kitapScrollPane.setStyle("-fx-background: #202020;-fx-focus-color: transparent;-fx-faint-focus-color: transparent;"
                + "-fx-border-width: 2;-fx-border-color: #606060");
        
        buildScrollPane();
    }
    
    public void buildScrollPane()
    {
        VBox vbox = new VBox();
        
        for(Kitap k : KitapYonetim.getKitapListesi())
        {
            if(k.isOduncAlindi())
            {
                Label label = new Label("ID:"+k.getId()+"  |  Ad:"+k.getAdi()+"  |  Soyad:"+k.getYazar()+"  |  Durum:Mevcut değil");
                
                label.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15;");
                
                label.setOnMouseClicked(event -> selectBook(event, k.getId(), label));
                
                vbox.getChildren().add(label);
            }
        }
        
        kitapScrollPane.setContent(vbox);
    }
    
    public void selectBook(MouseEvent e, int id, Label label)
    {
        if(oncekiLabel != null)
        {
            oncekiLabel.setStyle("-fx-background-color: transparent;-fx-font-size: 15;");
        }
        
        label.setStyle("-fx-background-color: #606060;-fx-font-size: 15;");
        secilenKitapID = id;
        oncekiLabel = label;
    }
    
    public void geriButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/MainScene.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)kitapScrollPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması");
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("MainScene.fxml could not be loaded");
        }
    }
    
    public void teslimEtButton(ActionEvent e)
    {
        KitapYonetim.kitapIadeEt(secilenKitapID);
        notification.setText("Kitap Teslim Edildi");
        buildScrollPane();
    }
}
