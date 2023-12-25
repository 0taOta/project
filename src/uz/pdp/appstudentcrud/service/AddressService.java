package uz.pdp.appstudentcrud.service;

import java.util.List;
import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.payload.AddressDTO;


public interface AddressService {

    List<AddressDTO> all();

    AddressDTO add(AddressDTO genreDTO);

    AddressDTO edit(Integer id, AddressDTO genreDTO);

    boolean delete(Integer id);

    Address getByIdOrElseThrow(Integer id);

}
