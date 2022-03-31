package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Memento {
    private char[][] field;
    private char player;
    public boolean status;

    public char[][] getField() {
        return deepCopy(field);
    }

    public void setField(char[][] field) {
        this.field = deepCopy(field);
    }

    public char getPlayer() {
        return player;
    }

    public void setPlayer(char player) {
        this.player = player;
    }

    private char[][] deepCopy(char[][] matrix){
        return Arrays.stream(matrix)
                .map(arr -> arr.clone())
                .toArray(s -> matrix.clone());
    }
}
