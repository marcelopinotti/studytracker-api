package br.com.studytracker.studytracker_api.exception;

public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(String message) {
        super(message);
    }
}
