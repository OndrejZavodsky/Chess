package pieces;

import utils.PieceImage;

public abstract class Piece {
  private int x;
  private int y;
  private PieceImage image;
  private boolean white;

  public Piece(int x, int y, String imageAddress, boolean white) {
    this.x = x;
    this.y = y;
    this.image = new PieceImage(imageAddress);
    this.white = white;
  }

  public void jump(int x, int y, boolean capture) {
    if (isValidMove(x, y, capture)) {
      this.x += x;
      this.y += y;
    }
  }

  public boolean isValidMove(int x, int y, boolean capture) {
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

  public boolean isWhite() {
    return this.white;
  }
}
