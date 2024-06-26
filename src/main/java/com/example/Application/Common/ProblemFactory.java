package com.example.Application.Common;

import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.Collections;
import java.util.Map;

@Component
public class ProblemFactory {

    public CustomProblem createCustomProblem(URI type, String title, String detail, Status status, URI instance, Map<String, Object> parameters) {
        return new CustomProblem(type, status, title, detail, instance, parameters);
    }

    public CustomProblem createUnauthorizedProblem(String detail) {
        return createCustomProblem(
                Problem.DEFAULT_TYPE,
                "Unauthorized",
                detail,
                Status.UNAUTHORIZED,
                null,
                Collections.emptyMap()
        );
    }

    public CustomProblem createBadRequestProblem(String detail) {
        return createCustomProblem(
                Problem.DEFAULT_TYPE,
                "Bad Request",
                detail,
                Status.BAD_REQUEST,
                null,
                Collections.emptyMap()
        );
    }

    public CustomProblem createNotFoundProblem(String detail) {
        return createCustomProblem(
                Problem.DEFAULT_TYPE,
                "Not Found",
                detail,
                Status.NOT_FOUND,
                null,
                Collections.emptyMap()
        );
    }

    public CustomProblem createInternalServerErrorProblem(String detail) {
        return createCustomProblem(
                Problem.DEFAULT_TYPE,
                "Internal Server Error",
                detail,
                Status.INTERNAL_SERVER_ERROR,
                null,
                Collections.emptyMap()
        );
    }

    // Additional methods for other common HTTP statuses

    // Example method for creating a custom problem
    public CustomProblem createCustomProblem(Status status, String detail) {
        return createCustomProblem(
                Problem.DEFAULT_TYPE,
                status.getReasonPhrase(),
                detail,
                status,
                null,
                Collections.emptyMap()
        );
    }
}
