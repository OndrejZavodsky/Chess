package game;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseEvent;
import pieces.Piece;
import pieces.PieceFactory;
import pieces.PieceFactory.PieceType;

public class Board {
  private GridPane grid;
  private static final int BOARD_SIZE = 8;
  private static final int TILE_SIZE = 40;
  private static Board instance;
  private Piece[][] board;
  private int selectedX = -1;
  private int selectedY = -1;
  private Rectangle[][] highlights;
  private StackPane[][] cells;

  private Board() {
    this.grid = new GridPane();
    this.grid.setPrefSize(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
    this.highlights = new Rectangle[8][8];
    this.cells = new StackPane[8][8];
    for (int row = 0; row < BOARD_SIZE; row++) {
      for (int col = 0; col < BOARD_SIZE; col++) {
        StackPane cell = new StackPane();
        cell.setPrefSize(TILE_SIZE, TILE_SIZE);
        
        Rectangle squer = new Rectangle(TILE_SIZE, TILE_SIZE);
        boolean light = (row + col) % 2 == 0;
        squer.setFill(light ? Color.BEIGE : Color.BROWN);
        squer.setMouseTransparent(true);
        
        Rectangle highlight = new Rectangle(TILE_SIZE, TILE_SIZE);
        highlight.setFill(Color.TRANSPARENT);
        highlight.setStroke(Color.GREEN);
        highlight.setStrokeWidth(3);
        highlight.setVisible(false);
        highlight.setMouseTransparent(true);
        highlights[row][col] = highlight;
        
        cell.getChildren().addAll(squer, highlight);
        cells[row][col] = cell;
        
        final int x = row;
        final int y = col;
        cell.setOnMouseClicked(e -> handleCellClick(x, y));
        
        grid.add(cell, col, row);
      }
    }
    this.board = new Piece[8][8];
    for (int y = 0; y < 8; y++) {
      for (int x = 0; x < 8; x++) {
        board[y][x] = null;
      }
    }
  }

  private void handleCellClick(int x, int y) {
    Game game = Game.getInstance();
    
    if (selectedX == -1) {
      // First click - select piece
      Piece piece = board[x][y];
      if (piece != null) {
        selectedX = x;
        selectedY = y;
        highlights[x][y].setVisible(true);
      }
    } else {
      // Second click - attempt move
      if (selectedX == x && selectedY == y) {
        // Clicked same square - deselect
        highlights[selectedX][selectedY].setVisible(false);
        selectedX = -1;
        selectedY = -1;
      } else {
        // Attempt to move
        game.makeMove(selectedX, selectedY, x, y);
        highlights[selectedX][selectedY].setVisible(false);
        selectedX = -1;
        selectedY = -1;
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
    board[0][1] = PieceFactory.createPiece(PieceType.KNIGHT, 0, 1, false);
    board[0][2] = PieceFactory.createPiece(PieceType.BISHOP, 0, 2, false);
    board[0][3] = PieceFactory.createPiece(PieceType.QUEEN, 0, 3, false);
    board[0][4] = PieceFactory.createPiece(PieceType.KING, 0, 4, false);
    board[0][5] = PieceFactory.createPiece(PieceType.BISHOP, 0, 5, false);
    board[0][6] = PieceFactory.createPiece(PieceType.KNIGHT, 0, 6, false);
    board[0][7] = PieceFactory.createPiece(PieceType.ROOK, 0, 7, false);
    for (int x = 0; x < 8; x++) {
      board[1][x] = PieceFactory.createPiece(PieceType.PAWN, 1, x, false);
    }
    for (int x = 0; x < 8; x++) {
      board[6][x] = PieceFactory.createPiece(PieceType.PAWN, 6, x, true);
    }
    board[7][0] = PieceFactory.createPiece(PieceType.ROOK, 7, 0, true);
    board[7][1] = PieceFactory.createPiece(PieceType.KNIGHT, 7, 1, true);
    board[7][2] = PieceFactory.createPiece(PieceType.BISHOP, 7, 2, true);
    board[7][3] = PieceFactory.createPiece(PieceType.QUEEN, 7, 3, true);
    board[7][4] = PieceFactory.createPiece(PieceType.KING, 7, 4, true);
    board[7][5] = PieceFactory.createPiece(PieceType.BISHOP, 7, 5, true);
    board[7][6] = PieceFactory.createPiece(PieceType.KNIGHT, 7, 6, true);
    board[7][7] = PieceFactory.createPiece(PieceType.ROOK, 7, 7, true);
    
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (board[row][col] != null) {
          // Add the piece to the cell
          cells[row][col].getChildren().add(board[row][col].getImage().getView());
        }
      }
    }
  }

  public Piece getPiece(int x, int y) {
    return board[x][y];
  }

  public void removePiece(int x, int y) {
    board[x][y] = null;
  }

  public boolean isPathClear(int startX, int startY, int endX, int endY) {
    int dx = Integer.compare(endX, startX);
    int dy = Integer.compare(endY, startY);

    int currX = startX + dx;
    int currY = startY + dy;

    while (currX != endX || currY != endY) {
      if (board[currY][currX] != null) {
        return false;
      }
      currX += dx;
      currY += dy;
    }

    return true;
  }

  public GridPane getGrid() {
    return grid;
  }

  public void movePiece(int fromX, int fromY, int toX, int toY) {
    Piece piece = board[fromX][fromY];
    if (piece == null) {
      return;
    }

    // Check if there's a piece at the destination to capture
    Piece capturedPiece = board[toX][toY];
    if (capturedPiece != null) {
      // Remove captured piece from its cell
      cells[toX][toY].getChildren().remove(capturedPiece.getImage().getView());
    }

    // Remove piece from the old cell
    cells[fromX][fromY].getChildren().remove(piece.getImage().getView());

    // Update board array
    board[fromX][fromY] = null;
    board[toX][toY] = piece;

    // Move the piece
    piece.jump(toX, toY, capturedPiece != null);

    // Add piece to the new cell
    cells[toX][toY].getChildren().add(piece.getImage().getView());
  }
}
