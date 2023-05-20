package com.driver;

import java.util.*;

public class StudentRepository {
    private Map<String, Student> studentData=new HashMap<>();
    private Map<String, Teacher> teacherData=new HashMap<>();
    private Map<String, String> studentTeacherMap=new HashMap<>();
    private Map<String, ArrayList<String>> teacherStudentsMap = new HashMap<>();
    public void add(Student student) {
        studentData.put(student.getName(), student);
    }
    public void adding(Teacher teacher){
        teacherData.put(teacher.getName(), teacher);
    }
    public Optional<Student> getStudentByName(String student) {
        if(studentData.containsKey(student)){
            return Optional.of(studentData.get(student));
        }
        return Optional.empty();
    }
    public Optional<Teacher> getTeacherByName(String teacher) {
        if(teacherData.containsKey(teacher)){
            return Optional.of(teacherData.get(teacher));
        }
        return Optional.empty();
    }
    public void addStudentTeacherPair(String student, String teacher) {
        studentTeacherMap.put(student, teacher);
        ArrayList<String> updateStudents=new ArrayList<>();
        if(teacherStudentsMap.containsKey(teacher)){
            updateStudents=teacherStudentsMap.get(student);
        }
        updateStudents.add(student);
        teacherStudentsMap.put(teacher, updateStudents);
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(studentData.keySet());
    }

    public List<String> getAllStudentForTeacher(String teacher) {
        return teacherStudentsMap.get(teacher);
    }

    public void deleteTeacher(String teacher) {
        teacherData.remove(teacher);
        teacherStudentsMap.remove(teacher);
    }

    public void removeTeacher(String student) {
        studentTeacherMap.remove(student);
    }

    public void deleteAllTeachers() {

    }
}
