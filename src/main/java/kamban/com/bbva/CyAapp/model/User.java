package kamban.com.bbva.CyAapp.model;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private String id;

    private String netUser;

    private String name;

    private String apPaterno;

    private String apMaterno;

    private String shortUser;

    private String email;

    private int porcentajeAsignacion;

    private int porcentajeDisponible;

    private boolean techReview;

    private List<Disciplina> disciplinas;

}
