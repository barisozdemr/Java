
package Java;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneViewBooksController {
    
    @FXML
    private ScrollPane kitapScrollPane;
    @FXML
    private Label notification;
    
    private Label oncekiLabel;
    private int secilenKitapID = -1;
    
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
            String durum;
            Label label;
            
            if(k.isOduncAlindi())
            {
                durum = "Mevcut değil";
            }
            else{
                durum = "Mevcut";
            }
            
            if(k.getSahipID() != -1)
            {
                String sahipAd = null;
                for(Uye u : UyeYonetim.getUyeListesi())
                {
                    if(u.getId() == k.getSahipID())
                    {
                        sahipAd = u.getAd();
                    }
                }
                if(sahipAd == null)
                {
                    label = new Label("ID:"+k.getId()+"  |  Ad:"+k.getAdi()+"  |  Soyad:"+k.getYazar()+"  |  Durum:"+durum);
                }
                else{
                    label = new Label("ID:"+k.getId()+"  |  Ad:"+k.getAdi()+"  |  Soyad:"+k.getYazar()+"  |  Durum:"+durum+"  |  Sahip:"+sahipAd);
                }
            }
            else{
                label = new Label("ID:"+k.getId()+"  |  Ad:"+k.getAdi()+"  |  Soyad:"+k.getYazar()+"  |  Durum:"+durum);
            }
            
            label.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15;");
            
            vbox.getChildren().add(label);
        }
        
        kitapScrollPane.setContent(vbox);
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
}
