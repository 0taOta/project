package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.payload.StudentDTO;

import java.util.List;

public interface StudentService {

    //1
    List<StudentDTO> getByGroup(Integer groupId);

    //2
    StudentDTO getById(Integer id);

    //3
    StudentDTO add(StudentDTO studentDTO);

    //4
    StudentDTO edit(Integer id, StudentDTO studentDTO);

    //5
    boolean delete(Integer id);

    //6
    String read(Integer id);

    //7
    boolean serialize();

    //8
    boolean deserialize();

}
