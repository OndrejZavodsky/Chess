package game;

import utils.CmdMove;
import pieces.Pawn;
import pieces.Piece;
import pieces.Rook;
import pieces.Bishop;
import pieces.Queen;
import pieces.King;
import pieces.Knight;
import java.util.ArrayList;

public class Game {
  private Board board;
  private static Game instance;
  private ArrayList<CmdMove> moves;

  private Game() {
    this.board = Board.getInstance();
    this.board.setBoard();
    this.moves = new ArrayList<>();
  }

  public static Game getInstance() {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }

  public boolean isSquareUnderAttack(int x, int y, boolean byWhite) {
    // Check all opponent pieces to see if any can attack square (x, y)
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        Piece piece = board.getPiece(row, col);
        if (piece != null && piece.isWhite() == byWhite) {
          int dx = x - piece.getX();
          int dy = y - piece.getY();

          // Check if this piece can move to (x, y)
          boolean canAttack = false;

          if (piece instanceof Pawn) {
            int direction = byWhite ? -1 : 1;
            canAttack = (dy == direction) && (Math.abs(dx) == 1);
          } else if (piece instanceof Knight) {
            canAttack = piece.isValidMove(dx, dy, true);
          } else if (piece instanceof King) {
            canAttack = (Math.abs(dx) <= 1 && Math.abs(dy) <= 1);
          } else {
            // For sliding pieces (Rook, Bishop, Queen), check both valid move and clear
            // path
            if (piece.isValidMove(dx, dy, true)) {
              canAttack = board.isPathClear(piece.getX(), piece.getY(), x, y);
            }
          }

          if (canAttack) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public void makeMove(int x, int y, int nx, int ny) {
    Piece p = board.getPiece(x, y);
    if (p == null) {
      return;
    }

    // Check if there's a piece at the destination
    Piece targetPiece = board.getPiece(nx, ny);
    boolean isCapture = (targetPiece != null && targetPiece.isWhite() != p.isWhite());

    // Check if the move is valid for this piece
    if (!p.isValidMove(nx, ny, isCapture)) {
      return;
    }

    // Check if path is blocked for pieces that cannot jump (Rook, Bishop, Queen)
    if (p instanceof Rook || p instanceof Bishop || p instanceof Queen) {
      if (!board.isPathClear(x, y, nx, ny)) {
        return; // Path is blocked, cannot make this move
      }
    }

    // Check if King is moving into check
    if (p instanceof King) {
      boolean opponentColor = !p.isWhite();
      if (isSquareUnderAttack(nx, ny, opponentColor)) {
        return; // King cannot move into check
      }
    }

    // Execute the move
    board.movePiece(x, y, nx, ny);

    CmdMove cmd = null;
    if (p instanceof Pawn) {
      cmd = new CmdMove(true, nx, ny);
    } else {
      cmd = new CmdMove(false, nx, ny);
    }
    this.moves.add(cmd);
  }
}
