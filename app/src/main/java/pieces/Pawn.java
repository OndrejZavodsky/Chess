package pieces;

public class Pawn extends Piece {
  private boolean hasMoved;

  public Pawn(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
    this.hasMoved = false;
  }

  @Override
  public void jump(int x, int y, boolean capture) {
    this.hasMoved = true;
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    // Check bounds first
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }

    int direction = isWhite() ? -1 : 1;

    int dx = x - this.getX();
    int dy = y - this.getY();
    if (capture) {
      return Math.abs(dx) == 1 && dy == direction;
    }
    if (dx != 0) {
      return false;
    }
    if (dy == direction) {
      return true;
    }
    if (!this.hasMoved && dy == 2 * direction) {
      return true;
    }

    return false;
  }

}
