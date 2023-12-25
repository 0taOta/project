package uz.pdp.appstudentcrud.service;

import uz.pdp.appstudentcrud.entity.Group;
import uz.pdp.appstudentcrud.payload.GroupDTO;

import java.util.List;


public interface GroupService {

    List<GroupDTO> all();

    GroupDTO add(GroupDTO groupDTO);

    GroupDTO edit(Integer id, GroupDTO genreDTO);

    boolean delete(Integer id);

    Group getByIdOrElseThrow(Integer id);

}
