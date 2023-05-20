package com.driver;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private StudentRepository studentRepository=new StudentRepository();
    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.adding(teacher);
    }

    public void addStudentTeacherPair(String student, String teacher) {
        Optional<Student> studentAdd=studentRepository.getStudentByName(student);
        Optional<Teacher> teacherAdd=studentRepository.getTeacherByName(teacher);
        if(studentAdd.isPresent() && teacherAdd.isPresent()){
            Teacher t = teacherAdd.get();
            Integer initialStudents=t.getNumberOfStudents();
            initialStudents++;
            t.setNumberOfStudents(initialStudents);
            studentRepository.adding(t);
            studentRepository.addStudentTeacherPair(student, teacher);
        }
    }

    public Teacher getStudentByName(String name) {
        Optional<Teacher> teacherOpt=studentRepository.getTeacherByName(name);
        if(teacherOpt.isPresent()){
            return teacherOpt.get();
        }
        throw new RuntimeException("Order Not Found");
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacher(String teacher) {
        List<String> students = studentRepository.getAllStudentForTeacher(teacher);
        studentRepository.deleteTeacher(teacher);
        for(String student:students) {
            studentRepository.removeTeacher(student);
        }
    }

    public void deleteAllteachers() {
        studentRepository.deleteAllTeachers();
    }
}
