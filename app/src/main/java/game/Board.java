package game;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import pieces.*;

public class Board {
  private GridPane grid;
  private static final int BOARD_SIZE = 8;
  private static final int TILE_SIZE = 40;
  private static Board instance;
  private Piece[][] board;

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
    this.board = new Piece[8][8];
    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
        board[y][x] = null;
      }
    }
  }

  public static Board getInstance() {
    if (instance == null) {
      instance = new Board();
    }
    return instance;
  }

  public void setBoard() {
    board[0][0] = PieceFactory.createPiece(PieceType.ROOK, 0, 0, false);
    board[0][1] = PieceFactory.createPiece(PieceType.KNIGHT, 1, 0, false);
    board[0][2] = PieceFactory.createPiece(PieceType.BISHOP, 2, 0, false);
    board[0][3] = PieceFactory.createPiece(PieceType.QUEEN, 3, 0, false);
    board[0][4] = PieceFactory.createPiece(PieceType.KING, 4, 0, false);
    board[0][5] = PieceFactory.createPiece(PieceType.BISHOP, 5, 0, false);
    board[0][6] = PieceFactory.createPiece(PieceType.KNIGHT, 6, 0, false);
    board[0][7] = PieceFactory.createPiece(PieceType.ROOK, 7, 0, false);
    for (int x = 0; x < 8; x++) {
      board[1][x] = PieceFactory.createPiece(PieceType.PAWN, x, 1, false);
    }
    for (int x = 0; x < 8; x++) {
      board[6][x] = PieceFactory.createPiece(PieceType.PAWN, x, 6, true);
    }
    board[7][0] = PieceFactory.createPiece(PieceType.ROOK, 0, 7, true);
    board[7][1] = PieceFactory.createPiece(PieceType.KNIGHT, 1, 7, true);
    board[7][2] = PieceFactory.createPiece(PieceType.BISHOP, 2, 7, true);
    board[7][3] = PieceFactory.createPiece(PieceType.QUEEN, 3, 7, true);
    board[7][4] = PieceFactory.createPiece(PieceType.KING, 4, 7, true);
    board[7][5] = PieceFactory.createPiece(PieceType.BISHOP, 5, 7, true);
    board[7][6] = PieceFactory.createPiece(PieceType.KNIGHT, 6, 7, true);
    board[7][7] = PieceFactory.createPiece(PieceType.ROOK, 7, 7, true);
  }

  public Piece getPiece(int x, int y) {
    return board[x][y];
  }
}
