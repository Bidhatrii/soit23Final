package com.soit23.enterprise;

import com.soit23.enterprise.entity.Faculty;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {

    //Upload faculty info
    private List<Faculty> theFaculties;


    //Mapping for "/list"

    @GetMapping("/list")
    public String listFaculties(Model theModel){



        //Add Faculties to the Spring Model
        theModel.addAttribute("faculties", theFaculties);

        return "list-faculties";
    }



    @PostConstruct
    private void loadData(){

        //Create Faculties
        Faculty fac1 = new Faculty(1, "Kelly", "Miller", "Assistant-Professor", "Kelly@uc.edu");
        Faculty fac2 = new Faculty(2, "Robert", "Lee", "Assistant-Educator", "Robert@uc.edu");
        Faculty fac3 = new Faculty(3, "Laura", "West", "Adjunct-Professor", "Laura@uc.edu");


        //Create our lists
        theFaculties = new ArrayList<>();


        //Add to our List
        theFaculties.add(fac1);
        theFaculties.add(fac2);
        theFaculties.add(fac3);

    }

}
