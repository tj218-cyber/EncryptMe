package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("application/welcomepage.fxml"));
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("EncryptMe");
		Image icon = new Image("application/logo.png");
		primaryStage.getIcons().add(icon);
		primaryStage.show();
	}



    public static void main(String[] args) {
        launch(args);
    }
   
}
