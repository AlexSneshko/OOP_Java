package com.company;

import javafx.util.Pair;

public class TicTacToe {
    private char[][] field;
    private char player;
    public boolean status;

    public TicTacToe() {
        field = new char[3][3];
        player = 'x';
        status = true;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field[i][j] = '_';
    }

    public void makeMove(int y, int x) {
        y--; x--;
        if (y < 0 || y > 2 || x < 0 || x > 2){
            System.out.println("This cell doesn`t exist, change your choice.");
            return;
        }
        if (field[y][x] != '_'){
            System.out.println("This cell is busy, change your choice.");
            return;
        }
        field[y][x] = player;

        checkWinner();
        changePlayer();
    }

    private void changePlayer() {
        if (player == 'x')
            player = 'o';
        else player = 'x';
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++){
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != '_') {
                System.out.println("\nPlayer " + player + " won!");
                status = false;
            }
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != '_') {
                System.out.println("\nPlayer " + player + " won!");
                status = false;
            }
        }

        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != '_') {
            System.out.println("\nPlayer " + player + " won!");
            status = false;
        }

        if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] != '_') {
            System.out.println("\nPlayer " + player + " won!");
            status = false;
        }
    }

    public void print() {
        System.out.println("-----Field-----");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print("\t" + field[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public void setMemento(Memento memento) {
        field = memento.getField();
        player = memento.getPlayer();
        status = memento.status;
    }

    public Memento createMemento() {
        var memento = new Memento();
        memento.setField(field);
        memento.setPlayer(player);
        memento.status = status;
        return memento;
    }
}
