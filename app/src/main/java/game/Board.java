package game;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Board {
  private GridPane grid;
  private static final int BOARD_SIZE = 8;
  private static final int TILE_SIZE = 40;
  private static Board instance;

  private Board() {
    this.grid = new GridPane();
    this.grid.setPrefSize(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        Rectangle squer = new Rectangle(TILE_SIZE, TILE_SIZE);
        boolean light = (row + col) % 2 == 0;
        squer.setFill(light ? Color.BEIGE : Color.BROWN);
        grid.add(squer, col, row);
      }
    }
  }

  public Board getInstance() {
    if (this.instance == null) {
      this.instance = new Board();
    }
    return this.instance;
  }
}
