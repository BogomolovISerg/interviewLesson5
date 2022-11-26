package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.repository.StudentRepository;
import ru.geekbrains.entities.Student;

import java.util.List;

public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value="/ping", method= RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return "Всё ОК";
    }


    @RequestMapping(value="/students", method=RequestMethod.GET)
    @ResponseBody
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value="/student", method=RequestMethod.POST)
    @ResponseBody
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @RequestMapping(value="/findstudent", method = RequestMethod.GET)
    @ResponseBody
    public Student findStudent(@RequestParam("studentId") int studentId) {
        return studentRepository.findById(studentId);
    }

    @RequestMapping(value= "/updatestudent", method = RequestMethod.GET)
    @ResponseBody
    public Student updateStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @RequestMapping(value="/deletestudent", method = RequestMethod.GET)
    @ResponseBody
    public void deleteStudent(@RequestParam("studentId") Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
