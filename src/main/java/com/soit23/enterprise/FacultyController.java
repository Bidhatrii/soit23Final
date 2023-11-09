package com.soit23.enterprise;

import com.soit23.enterprise.entity.Faculty;
import com.soit23.enterprise.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {

    public FacultyService facultyService;

    public FacultyController(FacultyService theFacultyService) {
        facultyService = theFacultyService;
    }

    //Upload faculty info
    //private List<Faculty> theFaculties;


    //Mapping for "/list"
    @GetMapping("/list")
    public String listFaculties(Model theModel) {
        //Retrieve faculties from the Database
        List<Faculty> theFaculties = facultyService.findAll();

        //Add Faculties to the Spring Model
        theModel.addAttribute("faculties", theFaculties);

        return "faculties/list-faculties";


    }

    @GetMapping("/viewAddForm")
    public String viewAddForm(Model theModel) {

        //Model attribute for the data binding
        Faculty theFaculty = new Faculty();


        theModel.addAttribute("faculty", theFaculty);

        return "faculties/faculty-form";
    }

    @PostMapping("/save")
    public String saveFaculty(@ModelAttribute("faculty") Faculty theFaculty){

        //Register the Faculty
        facultyService.save(theFaculty);

        //Block duplicate submission for accidental refresh
        return "redirect:/Faculties/list";
}


        //@PostConstruct
        //private void loadData(){

            //Create Faculties
            //Faculty fac1 = new Faculty(1, "Kelly", "Miller", "Assistant-Professor", "Kelly@uc.edu");
            //Faculty fac2 = new Faculty(2, "Robert", "Lee", "Assistant-Educator", "Robert@uc.edu");
            //Faculty fac3 = new Faculty(3, "Laura", "West", "Adjunct-Professor", "Laura@uc.edu");

            //Create our lists
            //theFaculties = new ArrayList<>();

            //Add to our List
            //theFaculties.add(fac1);
            //theFaculties.add(fac2);
            //theFaculties.add(fac3);

        }


