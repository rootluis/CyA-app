package kamban.com.bbva.CyAapp.model;

import lombok.Data;

import java.util.List;

@Data
public class ResponseDataModel<T> {
    private String code;
    private String msn;
    private List<ErrorModel> errors;
    private T result;
}
