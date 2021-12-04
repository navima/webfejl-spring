package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(IdNotFoundException::new);
    }

    public void addNewStudent(Student student) {
        var st = studentRepository.findStudentByEmail(student.getEmail());
        if (st.isPresent()) {
            throw new EmailTakenException();
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id))
            throw new IdNotFoundException();
        studentRepository.deleteById(id);
    }

    @Transactional
    public Student updateStudent(Student student) {
        var studentOpt = studentRepository.findById(student.getId());
        Student student2 = studentOpt.orElseThrow(IdNotFoundException::new);
        if (student.getDob() != null) student2.setDob(student.getDob());
        if (student.getEmail() != null) student2.setEmail(student.getEmail());
        if (student.getName() != null) student2.setName(student.getName());
        return student2;
    }

}
