package uz.pdp.appstudentcrud.entity;

import java.time.LocalDate;

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Group group;
    private Address address;
    private String biographyFilePath;


    public Student(Integer id, String firstName,
                   String lastName, String phoneNumber,
                   LocalDate birthDate, Group group,
                   Address address,
                   String biographyFilePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.group = group;
        this.address = address;
        this.biographyFilePath = biographyFilePath;
    }
    public String getBiographyFilePath() {
        return biographyFilePath;
    }

    public void setBiographyFilePath(String biographyFilePath) {
        this.biographyFilePath = biographyFilePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthDate=" + birthDate +
                ", group=" + group +
                ", address=" + address +
                '}';
    }
    
}
