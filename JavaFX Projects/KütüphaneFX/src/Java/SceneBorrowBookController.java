
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

public class SceneBorrowBookController {
    
    @FXML
    private ScrollPane kitapScrollPane;
    @FXML
    private ScrollPane uyeScrollPane;
    @FXML
    private Label notification;
    
    private Label oncekiLabelKitap;
    private int secilenKitapID = -1;
    
    private Label oncekiLabelUser;
    private int secilenUserID = -1;
    
    public void initialize()
    {
        kitapScrollPane.setStyle("-fx-background: #202020;-fx-focus-color: transparent;-fx-faint-focus-color: transparent;"
                + "-fx-border-width: 2;-fx-border-color: #606060");
        
        uyeScrollPane.setStyle("-fx-background: #202020;-fx-focus-color: transparent;-fx-faint-focus-color: transparent;"
                + "-fx-border-width: 2;-fx-border-color: #606060");
        
        buildScrollPane();
    }
    
    public void buildScrollPane()
    {
        VBox vbox = new VBox();
        
        for(Kitap k : KitapYonetim.getKitapListesi())
        {
            if(!k.isOduncAlindi())
            {
                Label label = new Label("ID:"+k.getId()+"  |  Ad:"+k.getAdi()+"  |  Soyad:"+k.getYazar()+"  |  Durum:Mevcut");
                
                label.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15;");
                
                label.setOnMouseClicked(event -> selectBook(event, k.getId(), label));
                
                vbox.getChildren().add(label);
            }
        }
        
        kitapScrollPane.setContent(vbox);
        
        VBox vbox2 = new VBox();
        
        for(Uye u : UyeYonetim.getUyeListesi())
        {
            Label label = new Label("ID:"+u.getId()+"  |  Ad:"+u.getAd()+"  |  Soyad:"+u.getSoyad());
            
            label.setStyle("-fx-text-fill: #ffffff; -fx-font-size: 15;");
            
            label.setOnMouseClicked(event -> selectUser(event, u.getId(), label));
            
            vbox2.getChildren().add(label);
        }
        
        uyeScrollPane.setContent(vbox2);
    }
    
    public void selectUser(MouseEvent e, int id, Label label)
    {
        if(oncekiLabelUser != null)
        {
            oncekiLabelUser.setStyle("-fx-background-color: transparent;-fx-font-size: 15;");
        }
        
        label.setStyle("-fx-background-color: #606060;-fx-font-size: 15;");
        secilenUserID = id;
        oncekiLabelUser = label;
    }
    
    public void selectBook(MouseEvent e, int id, Label label)
    {
        if(oncekiLabelKitap != null)
        {
            oncekiLabelKitap.setStyle("-fx-background-color: transparent;-fx-font-size: 15;");
        }
        
        label.setStyle("-fx-background-color: #606060;-fx-font-size: 15;");
        secilenKitapID = id;
        oncekiLabelKitap = label;
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
    
    public void oduncAlButton(ActionEvent e)
    {
        if(secilenKitapID != -1 && secilenUserID != -1)
        {
            KitapYonetim.kitapOduncAl(secilenUserID, secilenKitapID);
            buildScrollPane();
            notification.setText("Kitap ödünç alındı");
        }
        else{
            notification.setText("Önce üye ve kitap seçiniz!");
        }
    }
}
