package io.wulfcodes.rest.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.stereotype.Component;
import io.wulfcodes.rest.model.data.StudentData;
import io.wulfcodes.rest.model.entity.Student;

@Component
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    public String addStudent(StudentData newStudent) {
        Student student = new Student(newStudent);
        students.add(student);
        return student.getId();
    }

    public List<StudentData> getStudents() {
        return students.stream()
            .map(Student::convertToStudentData)
            .toList();
    }

    public Optional<StudentData> getStudentById(String id) {
        return students.stream()
            .filter(student -> student.getId().equals(id))
            .findAny()
            .map(Student::convertToStudentData);
    }

    public Optional<StudentData> updateStudent(StudentData updatedStudent) {
        for (int i = 0; i < students.size(); i++)
            if (students.get(i).getId().equals(updatedStudent.getId())) {
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
