package pieces;

public class Bishop extends Piece {
  public Bishop(int x, int y, String imageaddress, boolean white) {
    super(x, y, imageaddress, white);
  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }
    int dx = x - this.getX();
    int dy = y - this.getY();
    if ((dx == dy) || (dx == -dy)) {
      return true;
    }
    return false;
  }
}
