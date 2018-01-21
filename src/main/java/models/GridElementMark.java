package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GridElementMark {
    X("X"),
    O("O"),
    NONE("");

    private static final Map<String, GridElementMark> PLAYER_MARK_MAP = Stream.of(GridElementMark.values()).collect(Collectors.toMap
            (gridElementMark -> gridElementMark.getMark().toLowerCase(), Function.identity()));
    private final String mark;

    GridElementMark(String mark) {
        this.mark = mark;
    }

    @JsonCreator
    public static GridElementMark forValue(String value) {
        if (!PLAYER_MARK_MAP.containsKey(value.toLowerCase())) {
            return NONE;
        }

        return PLAYER_MARK_MAP.get(value.toLowerCase());
    }

    @JsonValue
    public String getMark() {
        return this.mark;
    }

    public boolean equals(GridElementMark gridElementMark) {
        return gridElementMark.getMark().compareToIgnoreCase(mark) == 0;
    }
}
