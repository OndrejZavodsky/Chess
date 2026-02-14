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
    this.image.show();
    this.white = white;
  }

  public void jump(int x, int y, boolean capture) {
    if (isValidMove(x, y, capture)) {
      this.x = x;
      this.y = y;
    }
  }

  public boolean isValidMove(int x, int y, boolean capture) {
    // Check if target position is within board bounds (0-7)
    if (x < 0 || x > 7 || y < 0 || y > 7) {
      return false;
    }
    // Can't move to the same position
    if (x == this.x && y == this.y) {
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
