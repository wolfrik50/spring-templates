package io.wulfcodes.rest.model.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import io.wulfcodes.rest.model.value.Gender;

public class StudentData {
    private String id;
    private String name;
    private Integer rollNo;
    private String email;
    private Long phoneNo;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static class StudentDataBuilder {
        private String id;
        private String name;
        private Integer rollNo;
        private String email;
        private Long phoneNo;
        private Gender gender;
        private LocalDate dateOfBirth;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private StudentDataBuilder() {}

        public StudentDataBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public StudentDataBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentDataBuilder setRollNo(Integer rollNo) {
            this.rollNo = rollNo;
            return this;
        }

        public StudentDataBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentDataBuilder setPhoneNo(Long phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public StudentDataBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public StudentDataBuilder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public StudentDataBuilder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public StudentDataBuilder setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public StudentData build() {
            return new StudentData(id, name, rollNo, email, phoneNo, gender, dateOfBirth, createdAt, updatedAt);
        }
    }

    public StudentData(String id, String name, Integer rollNo, String email, Long phoneNo, Gender gender, LocalDate dateOfBirth, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.rollNo = rollNo;
        this.email = email;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static StudentDataBuilder getBuilder() {
        return new StudentDataBuilder();
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

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "StudentData{" +
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
