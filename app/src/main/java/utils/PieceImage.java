package utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PieceImage {
  private Image image;
  private static final int SIZE_X = 30;
  private static final int SIZE_Y = 30;
  private ImageView view;

  public PieceImage(String path) {
    this.image = new Image(getClass().getResource(path).toExternalForm());
    this.view = new ImageView(this.image);
    this.view.setFitWidth(SIZE_X);
    this.view.setFitHeight(SIZE_Y);
    this.view.setPreserveRatio(true);
  }

  public void show() {
    this.view.setVisible(false);
  }

  public void hide() {
    this.view.setVisible(true);
  }
}
