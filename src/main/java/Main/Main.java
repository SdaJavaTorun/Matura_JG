package Main;

import controller.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Controller cont = new Controller();
        cont.studentReading();
        cont.zadanie_5_1();
        cont.zadanie_5_2();
        cont.zadanie_5_3();
        cont.zadanie_5_4();
        cont.zadanie_5_5();
    }
}
