package kamban.com.bbva.CyAapp.model;

import lombok.Data;

@Data
public class User {

    private String usuarioRed;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String usuarioCorto;
    private String email;
    private String porcentajeAsignacion;
    private String porcentajeDisponible;
    private boolean techReview;

}
