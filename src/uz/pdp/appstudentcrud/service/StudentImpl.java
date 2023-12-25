package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.entity.Group;
import uz.pdp.appstudentcrud.entity.Student;
import uz.pdp.appstudentcrud.payload.StudentDTO;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class StudentImpl implements StudentService {
    private static StudentImpl instance;
    static Lock lock = new ReentrantLock();

    private StudentImpl() {
    }

    static List<Student> students = Collections.synchronizedList(new ArrayList<>());

    public static StudentImpl getInstance() {
        if (Objects.isNull(instance)) {
            lock.lock();
            if (Objects.isNull(instance))
                instance = new StudentImpl();
            lock.unlock();
        }
        return instance;
    }

    @Override
    public List<StudentDTO> getByGroup(Integer groupId) {
        List<StudentDTO> list = students
                .stream()
                .filter(student -> student.getGroup().getId().equals(groupId))
                .map(this::toDTO)
                .toList();
        return list;
    }

    @Override
    public StudentDTO getById(Integer id) {
        return toDTO(getId(id));
    }

    @Override
    public StudentDTO add(StudentDTO studentDTO) {
        int id = students.size() + 1;
        Group group = GroupImpl.getInstance().groups
                .stream()
                .filter(group1 -> group1.getId().equals(studentDTO.getGroup()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("group id is not found..."));
        Address address = AddressImpl.getInstance().addresses
                .stream()
                .filter(address1 -> address1.getId().equals(studentDTO.getAddress()))
                .findFirst().orElseThrow(() -> new RuntimeException("Address id is not found...."));
        Student student = new Student(studentDTO.getId(),
                studentDTO.getFirstName(),studentDTO.getLastName(),
                studentDTO.getPhoneNumber(),studentDTO.getBirthDate(),group,address,studentDTO.getBiographyFilePath());
        students.add(student);
        return (toDTO(student));
    }

    @Override
    public StudentDTO edit(Integer id, StudentDTO studentDTO) {
        Student student = getId(id);
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setBirthDate(studentDTO.getBirthDate());
        student.setPhoneNumber(studentDTO.getPhoneNumber());

        GroupImpl group = GroupImpl.getInstance();
        Group index = group.groups
                .stream()
                .filter(group1 -> group1.getId().equals(studentDTO.getGroup()))
                .findFirst().orElseThrow(() -> new RuntimeException("id is not found..."));
        student.setGroup(index);

        AddressImpl address = AddressImpl.getInstance();
        Address addressIndex = address.addresses
                .stream()
                .filter(address1 -> address1.getId().equals(studentDTO.getAddress()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("address is not found... "));
        student.setAddress(addressIndex);
        StudentDTO dto = toDTO(student);
        return dto;
    }

    @Override
    public boolean delete(Integer id) {
        Student index = getId(id);
        students.remove(index);
        return true;
    }

    @Override
    public String read(Integer id) {
        Student index = getId(id);
        File file = new File(index.getBiographyFilePath());
        String str;
        try (InputStream inputStream=new FileInputStream(file)){
            byte[] bytes = inputStream.readAllBytes();
            str= new String(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }
    @Override
    public boolean serialize() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("db/serialize.txt"))) {
            outputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean deserialize() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("db/serialize.txt"))) {
            students = (List<Student>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    private Student getId(Integer id) {
        Student student = students
                .stream()
                .filter(student1 -> student1.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Id is not found..."));
        return student;
    }

    private StudentDTO toDTO(Student student) {
        return new StudentDTO(student.getId(), student.getFirstName(), student.getLastName()
                , student.getPhoneNumber(), student.getBirthDate(), student.getGroup().getId()
                , student.getAddress().getId(), student.getBiographyFilePath());
    }
}
