package nets.suncaper.bootdemo.service;

import nets.suncaper.bootdemo.domain.Student;
import nets.suncaper.bootdemo.domain.StudentExample;
import nets.suncaper.bootdemo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAllStudents() {
        return studentMapper.selectByExample(new StudentExample());
    }

    public Student getById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    public void deleteStudent(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public void saveOrUpdate(Student student) {
        if(student.getId() != null) {
            studentMapper.updateByPrimaryKey(student);
        } else {
            studentMapper.insert(student);
        }
    }
}
