package io.wulfcodes.rest.model.exchange;

import java.time.LocalDate;
import io.wulfcodes.rest.model.data.StudentData;
import io.wulfcodes.rest.model.value.Gender;

public record StudentRequest(
    String name,
    Integer rollNo,
    String email,
    Long phoneNo,
    Gender gender,
    LocalDate dateOfBirth
) {

    public StudentData getStudentData() {
        return StudentData.getBuilder()
            .setName(name)
            .setRollNo(rollNo)
            .setEmail(email)
            .setPhoneNo(phoneNo)
            .setGender(gender)
            .setDateOfBirth(dateOfBirth)
            .build();
    }

}
