package kamban.com.bbva.CyAapp.model;

import lombok.Data;

@Data
public class DependencyStatusModel {
    private String id;
    private String name;
    private String description;
    private boolean active;
}
