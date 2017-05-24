package balls.controllers;

import balls.model.Student;
import balls.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    private StudentsServices studentsServices;

    @Autowired(required = true)
    @Qualifier(value = "studentsServices")
    public void setStudentsServices(StudentsServices studentsServices) {
        this.studentsServices = studentsServices;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("listStudents", studentsServices.listStudents());
        model.addAttribute("student", new Student());
        return "index";
    }

    @RequestMapping(value = "/index/addSt", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student){
        if (student.getId() == 0) {
            this.studentsServices.addStudent(student);
        } else {
            this.studentsServices.updateStudent(student);
        }

        return "redirect:/index";
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    public String removeStudent(@PathVariable("id") int id){
        this.studentsServices.removeStudent(id);

        return "redirect:/index";
    }

    @RequestMapping("edit/{id}")
    public String editStudents(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentsServices.getStudentId(id));
        model.addAttribute("listStudents", this.studentsServices.listStudents());

        return "index";
    }
}
