package uz.pdp.appstudentcrud.payload;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.entity.Group;

import java.time.LocalDate;

public class StudentDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private LocalDate birthDate;
    private Integer group;
    private Integer address;
    private String biographyFilePath;

    public StudentDTO(Integer id, String firstName, String lastName,
                      String phoneNumber, LocalDate birthDate, Integer group,
                      Integer address, String biographyFilePath) {
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

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
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
