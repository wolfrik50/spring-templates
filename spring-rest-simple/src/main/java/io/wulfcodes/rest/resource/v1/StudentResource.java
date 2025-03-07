package io.wulfcodes.rest.resource.v1;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import io.wulfcodes.rest.model.data.StudentData;
import io.wulfcodes.rest.model.exchange.GenericResponse;
import io.wulfcodes.rest.model.exchange.StudentRequest;
import io.wulfcodes.rest.model.exchange.StudentResponse;
import io.wulfcodes.rest.model.entity.Student;
import io.wulfcodes.rest.service.StudentService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController("studentsV1")
@RequestMapping(
    path = "/v1/students",
    consumes = APPLICATION_JSON_VALUE,
    produces = APPLICATION_JSON_VALUE
)
public class StudentResource {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<GenericResponse> insertStudent(
        @RequestBody
        StudentRequest newStudent,
        @Autowired
        UriComponentsBuilder uriBuilder,
        @Autowired
        HttpServletRequest servletRequest
    ) {
        try {
            String studentId = studentService.addStudent(newStudent.getStudentData());
            URI location = uriBuilder.path(servletRequest.getRequestURI().concat("/{studentId}"))
                .buildAndExpand(studentId)
                .toUri();

            return ResponseEntity.created(location).body(GenericResponse.successResponse(String.format("Student created successfully with id: %s", studentId)));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<StudentResponse> fetchAllStudents() {
        try {
            List<StudentData> students = studentService.getStudents();
            return students.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(StudentResponse.successResponse(students));
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentResponse> fetchStudent(@PathVariable("studentId") String id) {
        try {
            Optional<StudentData> fetchedStudent = studentService.getStudentById(id);
            return fetchedStudent.map(student -> ResponseEntity.ok(StudentResponse.successResponse(student)))
                .orElse(ResponseEntity.notFound().build());
        } catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping
    public void changeStudent(@RequestBody Student updatedStudent) {}

    @PatchMapping("/{studentId}")
    public void reviseStudent(
        @PathVariable("studentId")
        String id,
        @RequestBody
        Student updatedStudent
    ) {}

    @DeleteMapping
    public void removeStudent() {}
}
