package kamban.com.bbva.CyAapp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MDLDisciplina implements Serializable {
    private String id;
    private String name;
    private String description;
    private boolean active;
}
