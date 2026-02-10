package pieces;

public abstract class Piece {
  private int x;
  private int y;

  // private image;
  public Piece(int x, int y, String imageAddress) {
    this.x = x;
    this.y = y;
    // this.image = new image(imageAddress);
  }

  public abstract void jump(int x, int y);

  public int[] getPossicion() {
    int[] pos = new int[2];
    pos[0] = this.x;
    pos[1] = this.y;
    return pos;
  }

}
