package com.example.Application.Common;

import org.zalando.problem.Problem;
import org.zalando.problem.Status;

import java.net.URI;
import java.util.Map;

public class CustomProblem implements Problem {
    
    private final URI type;
    private final Status status;
    private final String title;
    private final String detail;
    private final URI instance;
    private final Map<String, Object> parameters;

    public CustomProblem(URI type, Status status, String title, String detail, URI instance, Map<String, Object> parameters) {
        this.type = type;
        this.status = status;
        this.title = title;
        this.detail = detail;
        this.instance = instance;
        this.parameters = parameters;
    }

    @Override
    public URI getType() {
        return type;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public String getDetail() {
        return detail;
    }

    @Override
    public URI getInstance() {
        return instance;
    }

    @Override
    public Map<String, Object> getParameters() {
        return parameters;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
          .append("\"type\": \"").append(type.toString()).append("\", ")
          .append("\"title\": \"").append(title).append("\", ")
          .append("\"status\": \"").append(status.getStatusCode()).append(" ").append(status.getReasonPhrase()).append("\", ")
          .append("\"detail\": \"").append(detail).append("\", ")
          .append("\"instance\": ").append(instance != null ? "\"" + instance.toString() + "\"" : null).append(", ")
          .append("\"parameters\": ").append(parameters)
          .append("}");
        return sb.toString();
    }
}
