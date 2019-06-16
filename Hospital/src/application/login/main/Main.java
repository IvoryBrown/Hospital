package application.login.main;
	
import application.setting.file.FolderWriter;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Main
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new FolderWriter();
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/application/login/view/Login.fxml"));
			primaryStage.setWidth(1600);
			primaryStage.setHeight(900);
			primaryStage.setMinWidth(1200);
			primaryStage.setMinHeight(600);
			primaryStage.setMaxWidth(2000);
			primaryStage.setMaxHeight(1200);
			primaryStage.setTitle("Stanicli");
			Scene scene = new Scene(root);
			scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			    @Override
			    public void handle(MouseEvent mouseEvent) {
			        System.out.println("mouse click detected! " + mouseEvent.getSource());
			    }
			});
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
