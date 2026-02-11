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
    if ((x == y) || (x == -y)) {
      return true;
    }
    return false;
  }
}
