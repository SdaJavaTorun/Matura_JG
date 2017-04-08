package controller;

import model.Student;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class Controller {

    List<Student> listOfStudents = new ArrayList<Student>();
    List<Student> listRooms = new ArrayList<Student>();
    List<Student> listBooks = new ArrayList<Student>();
    File output = new File("C://Users//RENT//Desktop//output.txt");

    public Controller() throws IOException {
    }

    public void studentReading() {

        try {
            BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\RENT\\IdeaProjects\\Matura\\src\\main\\java\\controller\\studenci.txt"));
            listOfStudents = input.lines().skip(1).map(s -> {
                String[] tab = s.split("\\s+");
                List<String> lista = new ArrayList<String>();

                return new Student(parseLong(tab[0]), tab[1], tab[2], 0, 0, lista);
            }).collect(Collectors.toList());
        } catch (IOException f) {
            System.out.println("File not found");
        }

        try {
            BufferedReader input2 = new BufferedReader(new FileReader("C:\\Users\\RENT\\IdeaProjects\\Matura\\src\\main\\java\\controller\\meldunek.txt"));
            listRooms = input2.lines().skip(1).map(s -> {
                String[] tab = s.split("\\s+");
                List<String> lista = new ArrayList<String>();
                return new Student(parseLong(tab[0]), null, null, parseInt(tab[1]), 0, lista);
            }).collect(Collectors.toList());
        } catch (IOException f) {
            System.out.println("File not found");
        }

        try {
            BufferedReader input3 = new BufferedReader(new FileReader("C:\\Users\\RENT\\IdeaProjects\\Matura\\src\\main\\java\\controller\\wypozyczenia.txt"));
            listBooks = input3.lines().skip(1).map(s -> {
                String[] tab = s.split("\t");
                List<String> lista = new ArrayList<String>();
                lista.add(tab[2]);
                return new Student(parseLong(tab[1]), null, null, 0, 0, lista);
            }).collect(Collectors.toList());
        } catch (IOException f) {
            System.out.println("File not found");
        }
        for (Student p : listOfStudents) {
            for (Student k : listRooms) {
                if (p.getPesel() == (k.getPesel())) {
                    p.setRoomId(k.getRoomId());
                }
            }
        }
        for (Student p : listOfStudents) {
            for (Student a : listBooks) {
                if (p.getPesel() == (a.getPesel())) {
                    p.setTitle(a.getTitle());
                }
            }
        }
        for (Student p : listOfStudents) {
            System.out.println(p.getPesel() + " " + p.getTitle());
        }
    }

    public void zadanie_5_1() throws FileNotFoundException {
        Comparator<Student> byRents = (e1, e2) -> Integer.compare(e1.getTitle().size(), e2.getTitle().size());
        Optional<Student> maxRents = listOfStudents.stream().max(byRents);

        PrintWriter pw = new PrintWriter(output);
        System.out.println(maxRents);
        pw.println("zadanie_5_1");
        pw.println(maxRents);
        pw.close();
    }

    public void zadanie_5_2() throws IOException {
        int studentNumber = listOfStudents.size();
        int roomsNumber = (int) listOfStudents.stream().map(s -> s.getRoomId()).distinct().count();
        float averagePerRoom = studentNumber / roomsNumber;

        FileWriter fw = new FileWriter (output, true);
        PrintWriter pw = new PrintWriter(fw);
        System.out.println(averagePerRoom);
        pw.println("zadanie_5_2");
        pw.println(averagePerRoom);
        pw.close();
    }

    public void zadanie_5_3() throws IOException {
        int numberOfWoman = 0;
        int numberOfMan = 0;
        for (Student p : listOfStudents) {
            if (((int) (p.getPesel() / 10)) % 2 == 0) {
                numberOfWoman++;
            } else {
                numberOfMan++;
            }
        }

        FileWriter fw = new FileWriter (output, true);
        PrintWriter pw = new PrintWriter(fw);
        System.out.println(numberOfMan + " " + numberOfWoman);
        pw.println("zadanie_5_3");
        pw.println("LiczbaKobiet = " + numberOfWoman);
        pw.println("LiczbaMezczyzn = " + numberOfMan);

        pw.close();
    }

    public void zadanie_5_4() throws IOException {
        int numberOfWoman = 0;
        List<Student> listOutsideCity = new ArrayList<Student>();

        for (Student p : listOfStudents) {
            if (p.getRoomId() == 0) {
                listOutsideCity.add(p);
            }
        }
        Comparator<Student> byLastName = (e1, e2) -> e1.getLastName().compareTo(e2.getLastName());
        List<Student> listOutsideCity2 = new ArrayList<Student>();
        listOutsideCity2 = listOutsideCity.stream().sorted(byLastName).collect(Collectors.toList());

        FileWriter fw = new FileWriter (output, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("zadanie_5_4");

        for (Student p : listOutsideCity2) {
            pw.println(p.getLastName() + " " + p.getName());
        }
        pw.close();

    }

    public void zadanie_5_5() throws IOException {

        int suma = 0;
        Map<Integer, List<Student>> grouped = listOfStudents.stream()
                .collect(Collectors.groupingBy(x -> x.getRoomId()));


        for (Map.Entry<Integer, List<Student>> p : grouped.entrySet()) {
            Set<String> set = new HashSet<String>();
            for (int i = 0; i < p.getValue().size(); i++) {
                for (int j = 0; j < p.getValue().get(i).getTitle().size(); j++) {

                    set.add(p.getValue().get(i).getTitle().get(j));
                }
            }
            suma += set.size();
        }

        System.out.println(suma);

        FileWriter fw = new FileWriter (output, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println("zadanie_5_5");
        pw.println("Liczba wypozyczonych gdyby system dzialal teraz = " + suma);
        pw.close();


    }
}


