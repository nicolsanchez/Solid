package main.excepciones

class ApiException extends RuntimeException{
    private static final long serialVersionUID = 1L

    private final String code
    private final String description
    private final Integer statusCode

    ApiException(String code, String description, Integer statusCode) {
        super(description)
        this.code = code
        this.description = description
        this.statusCode = statusCode
    }

     ApiException(String code, String description, Integer statusCode, Throwable cause) {
        super(description, cause)
        this.code = code
        this.description = description
        this.statusCode = statusCode
    }

     String getCode() {
        return this.code
    }

     String getDescription() {
        return this.description
    }

     Integer getStatusCode() {
        return this.statusCode
    }
}