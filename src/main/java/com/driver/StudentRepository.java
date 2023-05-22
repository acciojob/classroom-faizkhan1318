package com.driver;

import java.util.*;

public class StudentRepository {
    private Map<String, Student> studentData=new HashMap<>();
    private Map<String, Teacher> teacherData=new HashMap<>();
    private Map<String, ArrayList<String>> teacherStudentsMap = new HashMap<>();
    public void add(Student student) {
        studentData.put(student.getName(), student);
    }
    public void adding(Teacher teacher){
        teacherData.put(teacher.getName(), teacher);
    }
    public void add(String student, String teacher) {
        //add student to list for a particular teacher
        ArrayList<String> students = teacherStudentsMap.getOrDefault(teacher, new ArrayList<String>());
        students.add(student);
        teacherStudentsMap.put(teacher, students);
    }
    public Optional<Student> getStudent(String student) {
        if(studentData.containsKey(student)){
            return Optional.of(studentData.get(student));
        }
        return Optional.empty();
    }
    public Teacher getTeacherByName(String name) {
        if(teacherData.containsKey(name)) {
            return teacherData.get(name);
        }
        return null;
    }
    public Optional<Teacher> getTeacher(String teacher) {
        if(teacherData.containsKey(teacher)){
            return Optional.of(teacherData.get(teacher));
        }
        return Optional.empty();
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentData.keySet());
    }

    public List<String> getAllStudentForTeacher(String teacher) {
        return teacherStudentsMap.get(teacher);
    }

    public void deleteAllTeachers() {

    }

    public List<String> getStudentsByTeacher(String teacher) {
        return teacherStudentsMap.getOrDefault(teacher, new ArrayList<>());
    }

    public void deleteStudent(String student) {
        studentData.remove(student);
    }

    public void deleteTeacher(String teacher) {
        teacherData.remove(teacher);
        teacherStudentsMap.remove(teacher);
    }

    public List<String> getAllTeachers() {
        return new ArrayList<>(teacherData.keySet());
    }
}
