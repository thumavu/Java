package main.java.co.za.sizwe;

import java.io.Serializable;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "joe")
class StudentMarks implements Serializable {

    private static final long serialID = 1L;

    private String name;
    private String surname;
    private String marks;

    public StudentMarks(){
        super();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getMarks() {
        return this.marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Employee [Name = " + name + ", Surname = " + surname + ", Results = " + marks + "]";
    }

}
