package com.driver;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student){
        studentRepository.saveStudent(student);
    }
    public void addTeacher(Teacher teacher){
        studentRepository.saveTeacher(teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        studentRepository.saveStudentTeacherPair(student,teacher);
    }
    public Student getStudentByName(String studentName){
        return studentRepository.getStudentByName(studentName);
    }
    public Teacher getTeacherByName(String teacherName){
        return studentRepository.getTeacherbyName(teacherName);
    }
    public List<String> addStudentByTeacherName(String teacher){
        return studentRepository.getStudentbyTeacherName(teacher);
    }
    public List<String> getAllStudents(){
        return studentRepository.getAllstudents();
    }
    public void deleteteacherByName(String teacher){
        studentRepository.deleteTeacherbyName(teacher);
    }
    public void deleteAllTeachers(){
        studentRepository.deleteAllTeachers();
    }
}