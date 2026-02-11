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
      this.x += x;
      this.y += y;
    }
  }

  public boolean isValidMove(int x, int y) {
    if ((this.x + x < 1 || this.x + x > 8) && (this.y + y < 1 || this.y + y > 8) && (x == 0 && y == 0)) {
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
