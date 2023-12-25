package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.entity.Address;
import uz.pdp.appstudentcrud.payload.AddressDTO;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class AddressImpl implements AddressService{
    public static AddressImpl instance;
    private static Lock lock = new ReentrantLock();
    public AddressImpl(){
    }

    public List<Address> addresses= Collections.synchronizedList(new ArrayList<>());
    public static AddressImpl getInstance(){
        if(Objects.isNull(instance)){
            lock.lock();
            if(Objects.isNull(instance))
                instance = new AddressImpl();
        }
        return instance;
    }
    @Override
    public List<AddressDTO> all() {
        List<AddressDTO> collection = addresses
                .stream()
                .map(address -> new AddressDTO(address.getCity(),
                        address.getRegion(),
                        address.getStreet(),
                        address.getId()))
                .collect(Collectors.toList());
        return collection;
    }

    @Override
    public AddressDTO add(AddressDTO genreDTO) {

        return genreDTO;
    }

    @Override
    public AddressDTO edit(Integer id, AddressDTO addressDTO) {
        Address address = getByIdOrElseThrow(id);
        address.setRegion(addressDTO.getRegion());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        return addressDTO;
    }

    @Override
    public boolean delete(Integer id) {
        Address address = getByIdOrElseThrow(id);
        addresses.remove(address);
        return true;
    }

    @Override
    public Address getByIdOrElseThrow(Integer id) {
        Address address = addresses
                .stream()
                .filter(address1 -> address1.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Given id is not found..."));
        return address;
    }
}
