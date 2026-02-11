package pieces;

public class Bishop extends Piece {
  public Bishop(int x, int y, String imageaddress) {
    super(x, y, imageaddress);
  }

  @Override
  public boolean isValidMove(int x, int y) {
    if (!super.isValidMove(x, y)) {
      return false;
    }
    if ((x == y) || (x == -y)) {
      return true;
    }
    return false;
  }
}
