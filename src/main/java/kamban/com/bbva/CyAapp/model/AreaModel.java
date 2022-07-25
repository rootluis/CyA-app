package kamban.com.bbva.CyAapp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class AreaModel implements Serializable {
    private String id;
    private String code;
    private String name;
    private boolean active;
    private String description;

}
