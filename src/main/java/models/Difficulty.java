package models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Difficulty {
    EASY,
    HARD;

    private static final Map<String, Difficulty> DIFFICULTY_MAP = Stream.of(Difficulty.values()).collect(Collectors.toMap(difficulty -> difficulty
            .name().toLowerCase(), Function.identity()));

    @JsonCreator
    public static Difficulty forValue(String value) {
        return DIFFICULTY_MAP.get(value.toLowerCase());
    }
}
