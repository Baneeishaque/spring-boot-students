package nets.suncaper.bootdemo.controller;

import nets.suncaper.bootdemo.domain.Student;
import nets.suncaper.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//If your class has annotation like @RestController, all your functions return will seriablize to json.
@RestController
@RequestMapping("/api/students")
public class RestStudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/list")
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/detail")
    public Student findStudentById(@RequestParam("id") Integer id) {
        System.out.println("Id:" + id);
        return studentService.getById(id);
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam("username") String username,
                         @RequestParam("password") String password) {
        System.out.println(username + " " + password);

        return true;
    }
}
