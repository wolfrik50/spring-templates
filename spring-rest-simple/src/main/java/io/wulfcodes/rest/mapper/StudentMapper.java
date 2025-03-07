package io.wulfcodes.rest.mapper;

import org.springframework.stereotype.Component;
import io.wulfcodes.rest.model.data.StudentData;
import io.wulfcodes.rest.model.entity.Student;

@Component
public class StudentMapper {

    public StudentData toData(Student student) {
        return new StudentData(
            student.getId(),
            student.getName(),
            student.getRollNo(),
            student.getEmail(),
            student.getPhoneNo(),
            student.getGender(),
            student.getDateOfBirth(),
            student.getCreatedAt(),
            student.getUpdatedAt()
        );
    }

    public Student toEntity(StudentData studentData) {
        Student student = new Student();
        student.setId(studentData.getId());
        student.setName(studentData.getName());
        student.setRollNo(studentData.getRollNo());
        student.setEmail(studentData.getEmail());
        student.setPhoneNo(student.getPhoneNo());
        student.setGender();
    }

}
