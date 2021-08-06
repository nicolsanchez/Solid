package main.excepciones

class ApiError {
    private String error
    private String message
    private Integer status

    ApiError() {
    }

    ApiError(String error, String message, Integer status) {
        super()
        this.error = error
        this.message = message
        this.status = status
    }

    String getError() {
        return this.error
    }

    void setError(String error) {
        this.error = error
    }

    String getMessage() {
        return this.message
    }

    void setMessage(String message) {
        this.message = message
    }

    Integer getStatus() {
        return this.status
    }

    void setStatus(Integer status) {
        this.status = status
    }
}
