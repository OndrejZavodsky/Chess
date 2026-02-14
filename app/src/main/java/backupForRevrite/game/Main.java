package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    Game game = Game.getInstance();

    Board board = Board.getInstance();

    Scene scene = new Scene(board.getGrid(), 320, 320);

    primaryStage.setTitle("Chess Game");
    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
