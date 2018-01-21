package models;

import java.util.Random;

public class PlayerImpl implements Player {

    protected GameConfig gameConfig;
    protected GridElementMark gridElementMark;
    protected Random random = new Random();

    public PlayerImpl(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }

    @Override
    public GameBoard takeTurn(GameBoard gameBoard, int row, int col) {
        gameBoard.setGameGrid(gridElementMark, row, col);

        return gameBoard;
    }

    protected boolean flipCoin() {
        return random.nextInt(2) == 0;
    }
}
