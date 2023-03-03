package noroff.assignment.moviecharactersapi.customexceptions;

import lombok.Getter;

@Getter
public class ApiErrorResponse {
    private String timestamp;
    private Integer status;
    private String error;
    private String trace;
    private String message;
    private String path;


}