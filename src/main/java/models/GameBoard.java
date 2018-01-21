package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

public class GameBoard {

    @Getter
    private GameConfig gameConfig;
    @Getter
    private GridElement[][] gameBoard;

    public GameBoard(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        this.gameBoard = new GridElement[gameConfig.getNumRows()][gameConfig.getNumRows()];

        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard[row].length; col++) {
                gameBoard[row][col] = new GridElement();
            }
        }
    }

    public GameBoard() {
        gameConfig = GameConfig.defaultConfig();
    }

    @JsonIgnore
    public boolean isEmpty() {
        for (int row = 0; row < gameBoard.length; row++) {
            for (int col = 0; col < gameBoard.length; col++) {
                if (!gameBoard[row][col].isEmpty()) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isEmpty(int row, int col) {
        return gameBoard[row][col].isEmpty();
    }

    public GameBoard newGameBoard() {
        return new GameBoard();
    }

    public void setGameGrid(GridElementMark playerMark, int row, int col) {
        gameBoard[row][col].setCurrentValue(playerMark);
    }
}
