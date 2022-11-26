package ru.geekbrains.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.repository.StudentRepository;
import ru.geekbrains.entities.Student;

import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public void saveStudent(Student student) {
        try{
            studentRepository.save(student);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void deleteStudent(Long id) {
        try{
            studentRepository.deleteById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
