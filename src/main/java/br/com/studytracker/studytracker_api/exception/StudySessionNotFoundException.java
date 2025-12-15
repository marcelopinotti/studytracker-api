package br.com.studytracker.studytracker_api.exception;

public class StudySessionNotFoundException extends RuntimeException{
    public StudySessionNotFoundException(String message) {
        super(message);
    }
}
