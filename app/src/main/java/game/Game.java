package game;

public class Game {
  private Board board;
  private static Game instance;

  private Game() {
    this.board = Board.getInstance();
    this.board.setBoard();
  }

  public Game getInstance() {
    if (instance == null) {
      instance = new Game();
    }
    return instance;
  }

  public void makeMove(int x, int y, int nx, int ny) {

  }
}
