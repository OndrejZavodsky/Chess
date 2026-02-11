package pieces;

public class Pawn extends Piece {
  public Pawn(int x, int y, String imageAddress, boolean white) {
    super(x, y, imageAddress, white);
  }

  @Override
  public void jump(int x, int y, boolean capture) {

  }

  @Override
  public boolean isValidMove(int x, int y, boolean capture) {
    // Check bounds first
    if (!super.isValidMove(x, y, capture)) {
      return false;
    }

    int direction = isWhite() ? -1 : 1;
    int startY = isWhite() ? 7 : 2;

    // Calculate effective Y movement based on pawn color
    int effectiveY = y * direction;

    // Diagonal capture: 1 square diagonally forward when capture=true
    if (capture) {
      return (Math.abs(x) == 1 && effectiveY == 1);
    }

    // Non-capture moves must be straight forward (x == 0)
    if (x != 0) {
      return false;
    }

    // Forward 1 square
    if (effectiveY == 1) {
      // TODO: Check if target square is blocked (requires board state)
      return true;
    }

    // Forward 2 squares from starting position
    if (effectiveY == 2 && getY() == startY) {
      // TODO: Check if path is clear (requires board state)
      return true;
    }

    return false;
  }

  // TODO: En passant capture - requires access to move history or game state
  // TODO: Pawn promotion detection - requires knowing when pawn reaches the end
}
