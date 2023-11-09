package com.soit23.enterprise.service;

import com.soit23.enterprise.dao.FacultyRepository;
import com.soit23.enterprise.entity.Faculty;

import java.util.List;

public interface FacultyService {

    public default List<Faculty> findAll(){
        FacultyRepository facultyRepository = null;
        return facultyRepository.findAllByOrderByLastNameAsc();
    }


    public default Faculty findById(int theId){
        FacultyService facultyRepository = null;
        return facultyRepository.findById(theId).get();
    }



    public void save(Faculty theFaculty);


    public void deleteById(int theId);





}
