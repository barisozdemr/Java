
package Java;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SceneMainController {
    
    @FXML
    private AnchorPane mainAnchorPane;
    
    @FXML
    private Button uyeEkleButton;
    @FXML
    private Button uyeSilButton;
    @FXML
    private Button kitapEkleButton;
    @FXML
    private Button kitapSilButton;
    @FXML
    private Button oduncAlButton;
    @FXML
    private Button iadeEtButton;
    @FXML
    private Button cikisButton;
    
    public void uyeEkleButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/AddUser.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("AddUser.fxml could not be loaded");
        }
    }
    
    public void uyeSilButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/DeleteUser.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("DeleteUser.fxml could not be loaded");
        }
    }
    
    public void kitapEkleButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/AddBook.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("AddBook.fxml could not be loaded");
        }
    }
    
    public void kitapSilButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/DeleteBook.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("DeleteBook.fxml could not be loaded");
        }
    }
    
    public void kitapGoruntuleButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/ViewBooks.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("DeleteBook.fxml could not be loaded");
        }
    }
    
    public void oduncAlButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/BorrowBook.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("BorrowBook.fxml could not be loaded");
        }
    }
    
    public void iadeEtButton(ActionEvent e)
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/views/ReturnBook.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
            
            stage.setScene(scene);
            stage.setTitle("Kütüphane Uygulaması"); //set stage title
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.out.println("ReturnBook.fxml could not be loaded");
        }
    }
    
    public void cikisButton(ActionEvent e)
    {
        Stage stage = (Stage)mainAnchorPane.getScene().getWindow();
        
        stage.close();
    }
}
