package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.AreaModel;
import kamban.com.bbva.CyAapp.model.MDLDisciplina;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;

import java.util.List;

public interface DisciplinaAppService {
    public ResponseDataModel<MDLDisciplina> create(MDLDisciplina areaData);
    public ResponseDataModel<MDLDisciplina> alter(MDLDisciplina areaData);
    public ResponseDataModel<MDLDisciplina> processDelete(String areaId);
    public ResponseDataModel<List<MDLDisciplina>> getAll();
    public ResponseDataModel<MDLDisciplina> getById(String id);
}
