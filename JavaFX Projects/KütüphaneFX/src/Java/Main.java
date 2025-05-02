package Java;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        UyeYonetim.dosyadanOku();
        KitapYonetim.dosyadanOku();
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/MainScene.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("MainScene.fxml could not be loaded");
        }
    }
}

