package utils;

import pieces.Piece;

public class CmdMove {
  private boolean pawnMove;
  private int x;
  private int y;

  public CmdMove(boolean pawnMove, int x, int y) {
    this.pawnMove = pawnMove;
    this.x = x;
    this.y = y;
  }

  public boolean getPawnMove() {
    return this.pawnMove;
  }

  public void jump(Piece p, boolean capture) {
    p.jump(x, y, capture);
  }

}
