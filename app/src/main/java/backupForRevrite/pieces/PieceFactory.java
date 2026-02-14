package pieces;

public class PieceFactory {

    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    private static final String IMAGE_BASE_PATH = "/chess_pieces/";

    public static Piece createPiece(PieceType type, int x, int y, boolean isWhite) {
        String imageAddress = getImagePath(type, isWhite);
        
        return switch (type) {
            case PAWN -> new Pawn(x, y, imageAddress, isWhite);
            case ROOK -> new Rook(x, y, imageAddress, isWhite);
            case KNIGHT -> new Knight(x, y, imageAddress, isWhite);
            case BISHOP -> new Bishop(x, y, imageAddress, isWhite);
            case QUEEN -> new Queen(x, y, imageAddress, isWhite);
            case KING -> new King(x, y, imageAddress, isWhite);
        };
    }

    private static String getImagePath(PieceType type, boolean isWhite) {
        String color = isWhite ? "white" : "black";
        String pieceName = switch (type) {
            case PAWN -> "Pawn";
            case ROOK -> "Rook";
            case KNIGHT -> "Knight";
            case BISHOP -> "Bishop";
            case QUEEN -> "Queen";
            case KING -> "King";
        };
        return IMAGE_BASE_PATH + color + pieceName + ".png";
    }
}
