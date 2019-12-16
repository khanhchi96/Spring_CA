package SpringCA.Service;

import SpringCA.Repository.StudentRepository;
import SpringCA.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student updateStudent(int student_id, Student student) {
        Student oldStudent = studentRepository.findById(student_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + student_id));
        oldStudent.setEmail(student.getEmail());
        oldStudent.setMobile(student.getMobile());
        oldStudent.setAddress(student.getAddress());
        studentRepository.save(oldStudent);
        return oldStudent;
    }

}
