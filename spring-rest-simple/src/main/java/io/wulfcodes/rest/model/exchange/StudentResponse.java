package io.wulfcodes.rest.model.exchange;

import java.util.List;
import io.wulfcodes.rest.model.data.StudentData;

public record StudentResponse(String status, String message, Object payload) {
    private static final String SUCCESS = "success";
    private static final String ERROR = "error";

    public static StudentResponse successResponse(String message, StudentData payload) {
        return new StudentResponse(SUCCESS, message, payload);
    }

    public static StudentResponse errorResponse(String message, StudentData payload) {
        return new StudentResponse(ERROR, message, payload);
    }

    public static StudentResponse successResponse(String message, List<StudentData> payload) {
        return new StudentResponse(SUCCESS, message, payload);
    }

    public static StudentResponse errorResponse(String message, List<StudentData> payload) {
        return new StudentResponse(ERROR, message, payload);
    }
}
