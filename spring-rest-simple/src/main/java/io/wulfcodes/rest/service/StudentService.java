package io.wulfcodes.rest.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.wulfcodes.rest.model.data.StudentData;
import io.wulfcodes.rest.model.entity.Student;
import io.wulfcodes.rest.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentData newStudent) {
        newStudent.setId(UUID.randomUUID().toString());
        return studentRepository.addStudent(newStudent);
    }

    public List<StudentData> getStudents() {
        return studentRepository.getStudents();
    }

    public Optional<StudentData> getStudentById(String id) {
        return studentRepository.getStudentById(id);
    }

    public Optional<StudentData> updateStudent(String id, StudentData updatedStudent) {
        updatedStudent.setId(id);
        updatedStudent.setUpdatedAt(LocalDateTime.now());
        return studentRepository.updateStudent(updatedStudent);
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
