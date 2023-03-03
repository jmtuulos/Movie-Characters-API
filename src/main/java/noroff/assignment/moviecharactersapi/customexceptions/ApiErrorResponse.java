package noroff.assignment.moviecharactersapi.customexceptions;

import lombok.Getter;

/**
 * This class is used to create a custom error response.
 * It is used in the CustomExceptionHandler class.
 */
@Getter
public class ApiErrorResponse {
    private String timestamp;
    private Integer status;
    private String error;
    private String trace;
    private String message;
    private String path;


}