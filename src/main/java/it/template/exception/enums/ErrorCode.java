package it.template.exception.enums;

public enum ErrorCode {
    HTTP_400("BAD_REQUEST"),
    HTTP_500("INTERNAL_SERVER_ERROR");

    private String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
