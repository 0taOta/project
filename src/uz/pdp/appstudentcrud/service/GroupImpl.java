package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.entity.Group;
import uz.pdp.appstudentcrud.payload.AddressDTO;
import uz.pdp.appstudentcrud.payload.GroupDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class GroupImpl implements GroupService{
    private static GroupImpl instance;
    static Lock lock =new ReentrantLock();
    public List<Group>groups= Collections.synchronizedList(new ArrayList<>());
    private GroupImpl() {}
    public static GroupImpl getInstance(){
        if(Objects.isNull(instance)){
            lock.lock();
            if(Objects.isNull(instance))
                instance=new GroupImpl();
            lock.unlock();
        }
        return instance;
    }

    @Override
    public List<GroupDTO> all() {
        return groups
                .stream()
                .map(group -> new GroupDTO(group.getId(), group.getName()))
                .toList();
    }

    @Override
    public GroupDTO add(GroupDTO groupDTO) {
        int id = groups.size()+1;
        Group group=new Group(id, groupDTO.getName());
        groups.add(group);
        return groupDTO;
    }

    @Override
    public GroupDTO edit(Integer id, GroupDTO genreDTO) {
        Group index = getByIdOrElseThrow(id);
        Group group=new Group(id, genreDTO.getName());
        groups.add(group);
        return genreDTO;
    }

    @Override
    public boolean delete(Integer id) {
        Group index = getByIdOrElseThrow(id);
        groups.remove(index);
        return true;
    }

    @Override
    public Group getByIdOrElseThrow(Integer id) {
        Group group = groups
                .stream()
                .filter(group1 -> groups.equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("Id is not found...."));
        return group;
    }
}
