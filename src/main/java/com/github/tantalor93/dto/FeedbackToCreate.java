package com.github.tantalor93.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.Objects;

@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.NAME)
@JsonTypeName("feedback")
public class FeedbackToCreate {

    private String name;

    private String email;

    private String feedback;

    public FeedbackToCreate(String name, String email, String feedback) {
        this.name = name;
        this.email = email;
        this.feedback = feedback;
    }

    protected FeedbackToCreate() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return "FeedbackToCreate{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackToCreate that = (FeedbackToCreate) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(feedback, that.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, feedback);
    }
}
