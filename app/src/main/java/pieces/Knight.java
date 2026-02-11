package pieces;

public class Knight extends Piece {
  public Knight(int x, int y, String imageAddress) {
    super(x, y, imageAddress);
  }

  @Override
  public boolean isValidMove(int x, int y) {
    if (super.isValidMove(x, y)) {
      if ((this.getX() + 1 == x || this.getX() - 1 == x) && (this.getY() + 2 == y || this.getY() - 2 == y)) {
        return true;
      }
      if ((this.getX() + 2 == x || this.getX() - 2 == x) && (this.getY() + 1 == y || this.getY() - 1 == y)) {
        return true;
      }
    }
    return false;
  }
}
