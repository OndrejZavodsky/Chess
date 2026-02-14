package pieces;

public class Queen extends Piece {
  public Queen(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }
    int dx = x - this.getX();
    int dy = y - this.getY();
    if (((dx == 0) || (dy == 0)) || ((dx == dy) || (dx == -dy))) {
      return true;
    }
    return false;
  }
}
