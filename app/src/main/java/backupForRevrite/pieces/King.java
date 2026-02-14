package pieces;

public class King extends Piece {
  public King(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }
    int dx = x - this.getX();
    int dy = y - this.getY();
    if ((dx >= -1 && dx <= 1) && (dy >= -1 && dy <= 1)) {
      return true;
    }
    return false;
  }
}
