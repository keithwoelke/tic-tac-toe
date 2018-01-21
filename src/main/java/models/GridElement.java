package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

public class GridElement {

    @Getter
    private GridElementMark currentValue;

    public GridElement() {
        currentValue = GridElementMark.NONE;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return currentValue.equals(GridElementMark.NONE);
    }

    public void setCurrentValue(GridElementMark mark) {
        currentValue = mark;
    }
}
