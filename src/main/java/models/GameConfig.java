package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.Random;

public class GameConfig {

    @Getter
    private Difficulty difficulty;
    @Getter
    private GridElementMark playerMark;
    @Getter
    @JsonIgnore
    private GridElementMark computerMark;
    @Getter
    @JsonIgnore
    private int numRows = 3;
    @Getter
    @JsonIgnore
    private int numCols = 3;

    private GameConfig() {
        this(null, null);
    }

    @Builder
    @JsonCreator
    public GameConfig(@JsonProperty("difficulty") Difficulty difficulty, @JsonProperty("playerMark") GridElementMark playerMark) {
        if (playerMark == null || playerMark.equals(GridElementMark.NONE)) {
            this.playerMark = GridElementMark.X;
        } else {
            this.playerMark = playerMark;
        }

        if (this.playerMark == GridElementMark.X) {
            this.computerMark = GridElementMark.O;
        } else {
            this.computerMark = GridElementMark.X;
        }

        if (difficulty == null) {
            Random random = new Random();
            Difficulty[] difficulties = Difficulty.values();
            this.difficulty = difficulties[random.nextInt(difficulties.length)];
        } else {
            this.difficulty = difficulty;
        }
    }

    public static GameConfig defaultConfig() {
        return GameConfig.builder().build();
    }
}
