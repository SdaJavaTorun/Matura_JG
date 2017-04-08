package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-04-08.
 */
public class Student {

    private long pesel;
    private String lastName;
    private String name;
    private int roomId;
    private int lp;
    private List<String> title = new ArrayList<>();

    public Student(long pesel, String lastName, String name, int roomId, int lp, List<String> title) {
        this.pesel = pesel;
        this.lastName = lastName;
        this.name = name;
        this.roomId = roomId;
        this.lp = lp;
        this.title.addAll(title);
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public void setLp(int lp) {
        this.lp = lp;
    }

    public void setTitle(List<String> lista) {
        this.title.addAll(lista);
    }

    public long getPesel() {
        return pesel;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getLp() {
        return lp;
    }

    public List<String> getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Student{" +
                "pesel=" + pesel +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", roomId=" + roomId +
                ", lp=" + lp +
                ", title=" + title +
                '}';
    }
}
