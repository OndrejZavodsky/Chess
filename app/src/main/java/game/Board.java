package game;

import javafx.scene.layout.GridPane;

public class Board extends GridPane {
  private static final int TILE_SIZE = 50;
  private static final int BOARD_SIZE = 8;
  private Piece[][] pieces;
  private Board instance;

  private Board() {
    this.pieces = new Piece[BOARD_SIZE][BOARD_SIZE];
  }

  public Board getInstance() {
    if (this.instance == null) {
      this.instance = new Board();
    }
    return this.instance;
  }

}
