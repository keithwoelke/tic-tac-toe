package models;

public interface Player {

    GameBoard takeTurn(GameBoard gameBoard, int row, int col);
}
