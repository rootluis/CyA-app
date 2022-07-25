package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.DependencyStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;

import java.util.List;

public interface DependencyStatusAppService {
    public ResponseDataModel<DependencyStatusModel> create(DependencyStatusModel data);
    public ResponseDataModel<DependencyStatusModel> alter(DependencyStatusModel data);
    public ResponseDataModel<DependencyStatusModel> processDelete(String id);
    public ResponseDataModel<List<DependencyStatusModel>> getAll();
    public ResponseDataModel<DependencyStatusModel> getById(String id);
}
