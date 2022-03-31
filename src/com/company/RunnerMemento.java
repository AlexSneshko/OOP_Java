package com.company;

import java.util.Scanner;

public class RunnerMemento {

    public static void main(String[] args) {
        var tic = new TicTacToe();
        var caretaker = new Caretaker(tic.createMemento());
        int x, y;
        var scanner = new Scanner(System.in);
/*
        tic.print();
        tic.makeMove(2,2);
        tic.makeMove(1,2);
        caretaker.setMemento(tic.createMemento());
        tic.makeMove(1,3);

        tic.print();
        tic.setMemento(caretaker.getMemento());
        tic.makeMove(3,3);
        tic.print();
        */
        while (tic.status) {
            System.out.print("Print x: ");
            x = scanner.nextInt();
            System.out.print("Print y: ");
            y = scanner.nextInt();
            caretaker.setMemento(tic.createMemento());
            tic.makeMove(y, x);
            tic.print();

            System.out.print("Print u to undo last move: ");
            if (scanner.next().charAt(0) == 'u') {
                tic.setMemento(caretaker.getMemento());
                tic.print();
            }

            System.out.println();
        }


    }
}
