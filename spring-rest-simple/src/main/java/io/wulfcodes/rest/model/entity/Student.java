package io.wulfcodes.rest.model.entity;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.logging.Logger;
import io.wulfcodes.rest.model.data.StudentData;
import io.wulfcodes.rest.model.value.Gender;

public class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());

    private final LocalDateTime createdAt;

    private String id;
    private String name;
    private Integer rollNo;
    private String email;
    private Long phoneNo;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDateTime updatedAt;

    public Student() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Student(StudentData studentData) {
        this();
        this.id = studentData.getId();
        this.name = studentData.getName();
        this.rollNo = studentData.getRollNo();
        this.email = studentData.getEmail();
        this.phoneNo = studentData.getPhoneNo();
        this.gender = studentData.getGender();
        this.dateOfBirth = studentData.getDateOfBirth();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(Long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public StudentData convertToStudentData() {
        return new StudentData(id, name, rollNo, email, phoneNo, gender, dateOfBirth, createdAt, updatedAt);
    }

    public Student modify(Student that) {
        Field[] fields = that.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                Object thisValue = field.get(this);
                Object thatValue = field.get(that);

                if (Objects.nonNull(thatValue) && !Objects.equals(thatValue, thisValue))
                    field.set(this, thatValue);

            } catch (IllegalAccessException e) {
                logger.warning(e.getMessage());
            } finally {
                field.setAccessible(false);
                this.updatedAt = LocalDateTime.now();
            }
        }

        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", rollNo=" + rollNo +
            ", email='" + email + '\'' +
            ", phoneNo=" + phoneNo +
            ", gender=" + gender +
            ", dateOfBirth=" + dateOfBirth +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
