package uz.pdp.appstudentcrud;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.entity.Group;
import uz.pdp.appstudentcrud.entity.Student;
import uz.pdp.appstudentcrud.payload.AddressDTO;
import uz.pdp.appstudentcrud.service.AddressImpl;
import uz.pdp.appstudentcrud.service.StudentImpl;

import java.time.LocalDate;


public class App {

    public static void main(String[] args) {

    StudentImpl student = StudentImpl.getInstance();

    student.deserialize();

    }

}
