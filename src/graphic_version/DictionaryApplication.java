package graphic_version;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class DictionaryApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(DictionaryApplication.class.getResource("graphic/mainScene.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 900, 750);
            Image favicon = new Image("file:src/graphic_version/image/logo.png");
            stage.getIcons().add(favicon);
            stage.setTitle("Oxford Dictionary");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace() ;
        }
    }
}