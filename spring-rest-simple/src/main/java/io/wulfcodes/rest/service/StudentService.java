package io.wulfcodes.rest.service;

import java.time.LocalDateTime;
import java.util.*;
import org.springframework.stereotype.Service;
import io.wulfcodes.rest.model.Student;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public Student addStudent(Student student) {
        // System.out.println(student);
        student.setId(UUID.randomUUID().toString());
        students.add(student);
        System.out.println(students);
        return student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Optional<Student> getStudentById(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findAny();
    }

    public Optional<Student> updateStudent(String id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getId().equals(id)) {
                updatedStudent.setId(id);
                updatedStudent.setUpdatedAt(LocalDateTime.now());
                students.set(i, updatedStudent);
                return Optional.of(updatedStudent);
            }
        return Optional.empty();
    }

    public Optional<Student> modifyStudent(String id, Student updatedStudent) {
        for (Student currentStudent : students)
            if (currentStudent.getId().equals(id)) {
                updatedStudent.setId(id);
                return Optional.of(currentStudent.modify(updatedStudent));
            }
        return Optional.empty();
    }

    public Optional<Student> deleteStudent(String id) {
        Integer index = null;
        Optional<Student> deletedStudent = Optional.empty();

        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getId().equals(id)) {
                deletedStudent = Optional.of(students.get(index = i));
                break;
            }

        if (Objects.nonNull(index))
            students.remove(index);

        return deletedStudent;
    }

}
