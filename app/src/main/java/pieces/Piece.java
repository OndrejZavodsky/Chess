package pieces;

import utils.PieceImage;

public abstract class Piece {
  private int x;
  private int y;
  private PieceImage image;

  public Piece(int x, int y, String imageAddress) {
    this.x = x;
    this.y = y;
    this.image = new PieceImage(imageAddress);
  }

  public void jump(int x, int y) {
    if (isValidMove(x, y)) {
      this.x = x;
      this.y = y;
    }
  }

  public boolean isValidMove(int x, int y) {
    if ((x < 1 || x > 8) && (y < 1 || y > 8)) {
      return false;
    }
    return true;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public PieceImage getImage() {
    return this.image;
  }

}
