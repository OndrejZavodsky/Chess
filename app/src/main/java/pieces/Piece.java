package pieces;

import utils.PieceImage;

public abstract class Piece {
  private int row;
  private int col;
  private PieceImage image;

  public Piece(int row, int col, String imageAddress) {
    this.row = row;
    this.col = col;
    this.image = new PieceImage(imageAddress);
    this.image.show();
  }

  public boolean isValidMove(int row, int col) {
    if (row < 0 || row > 7) {
      return false;
    }
    if (col < 0 || col > 7) {
      return false;
    }
    if (this.row - row == 0 || this.col - col == 0) {
      return false;
    }
    return true;
  }

  public void move(int row, int col) {
    if (this.isValidMove(row, col)) {
      this.row = row;
      this.col = col;
    }
  }

  public int getRow() {
    return this.row;
  }

  public int gerCol() {
    return this.col;
  }
}
