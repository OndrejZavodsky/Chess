package utils;

import pieces.Piece;

public class CmdMove {
  private int x;
  private int y;

  public CmdMove(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void jump(Piece p) {
    p.move(x, y);
  }

}
