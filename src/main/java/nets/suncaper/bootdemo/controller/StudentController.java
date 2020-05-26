package nets.suncaper.bootdemo.controller;

import nets.suncaper.bootdemo.domain.Student;
import nets.suncaper.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("list")
    public String listPage(Model model) {
        //How to write value to the page
        //Model and View
        // View: student/student-list
        // Model: Model to store the value
        List<Student> allStudents = studentService.findAllStudents();
        model.addAttribute("students", allStudents);
        return "student/student-list";
    }

    @GetMapping("add")
    public String addPage(Model model) {
        model.addAttribute("student", new Student());
        return "student/student-add";
    }

    @PostMapping("save")
    public String saveStudent(Student student) {
        studentService.saveOrUpdate(student);

        //View, model
        return "redirect:/students/list";
    }

    @GetMapping("edit")
    public String editPage(@RequestParam("id") Integer id, Model model) {
        Student student = studentService.getById(id);

        model.addAttribute("student", student);

        return "student/student-add";
    }

    @GetMapping("delete")
    public String deleteStudent(@RequestParam("id") Integer id) {
        //Delete the student by id
        studentService.deleteStudent(id);

        return "redirect:/students/list";
    }
}
