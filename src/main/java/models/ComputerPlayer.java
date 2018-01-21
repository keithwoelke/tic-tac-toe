package models;

public class ComputerPlayer extends PlayerImpl implements Player {

    private Difficulty difficulty;

    public ComputerPlayer(GameConfig gameConfig) {
        super(gameConfig);

        difficulty = this.gameConfig.getDifficulty();
        gridElementMark = this.gameConfig.getComputerMark();
    }

    public GameBoard takeTurn(GameBoard gameBoard) {

        if (difficulty == Difficulty.HARD) {
            if (gameBoard.isEmpty()) {
                gameBoard.setGameGrid(gridElementMark, 1, 1);
            }
        } else {
            int row = getRandomRow(gameBoard);
            int col = getRandomCol(gameBoard);

            while (!gameBoard.isEmpty(row, col)) {
                row = getRandomRow(gameBoard);
                col = getRandomCol(gameBoard);
            }

            gameBoard.setGameGrid(gridElementMark, row, col);
        }

        return gameBoard;
    }

    private int getRandomRow(GameBoard gameBoard) {
        return random.nextInt(gameConfig.getNumRows());
    }

    private int getRandomCol(GameBoard gameBoard) {
        return random.nextInt(gameConfig.getNumCols());
    }
}
