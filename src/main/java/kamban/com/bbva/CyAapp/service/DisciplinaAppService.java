package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.Disciplina;

import java.util.List;

public interface DisciplinaAppService {

    public List<Disciplina> getdisciplinas();

    public Disciplina getDisciplinaById(String idDisciplina);

    public Disciplina getDisciplinaByCod(String codDisciplina);

    public void addDisciplina(Disciplina objDisciplina);

    public void deleteDisciplina(String idDisciplina);
}
