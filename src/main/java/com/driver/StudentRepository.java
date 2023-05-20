package com.driver;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class StudentRepository {
    private HashMap<String,Student> studentMap;
    private HashMap<String,Teacher> teacherMap;
    private HashMap<String,List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap=new HashMap<String,Student>();
        this.teacherMap=new HashMap<String,Teacher>();
        this.teacherStudentMapping=new HashMap<String,List<String>>();
    }
    public void saveStudent(Student student){
        studentMap.put(student.getName(),student);
    }
    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void saveStudentTeacherPair(String student,String teacher){
        if(studentMap.containsKey(student)&&teacherMap.containsKey(teacher)){
            studentMap.put(student,studentMap.get(student));
            teacherMap.put(teacher,teacherMap.get(teacher));
            List<String> currentStudents=new ArrayList<>();
            if(teacherStudentMapping.containsKey(teacher)) currentStudents=teacherStudentMapping.get(teacher);
            currentStudents.add(student);
            teacherStudentMapping.put(teacher,currentStudents);
        }
    }
    public Student getStudentByName(String student){
        return studentMap.get(student);
    }
    public Teacher getTeacherbyName(String teacher){
        return teacherMap.get(teacher);
    }
    public List<String> getStudentbyTeacherName(String teacher){
        List<String> studentList=new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)) studentList=teacherStudentMapping.get(teacher);
        return studentList;
    }
    public List<String> getAllstudents(){
        return new ArrayList<>(studentMap.keySet());
    }
    public void deleteTeacherbyName(String teacher){
        List<String> students=new ArrayList<>();
        if(teacherStudentMapping.containsKey(teacher)){
            students=teacherStudentMapping.get(teacher);
            for(String stu:students){
                if(studentMap.containsKey(stu))
                    studentMap.remove(stu);
            }
            teacherStudentMapping.remove(teacher);
        }
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
        }
    }
    public void deleteAllTeachers(){
        HashSet<String> studentSet=new HashSet<>();

        for(String teacher:teacherStudentMapping.keySet()){
            for(String student:teacherStudentMapping.get(teacher)){
                studentSet.add(student);
            }
        }
        for(String student:studentSet){
            if(studentMap.containsKey(student)){
                studentMap.remove(student);
            }
        }
    }
}