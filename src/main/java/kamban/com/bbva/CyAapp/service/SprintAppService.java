package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.SprintModel;

import java.util.List;

public interface SprintAppService {
    public ResponseDataModel<SprintModel> create(SprintModel data);
    public ResponseDataModel<SprintModel> alter(SprintModel data);
    public ResponseDataModel<SprintModel> processDelete(String id);
    public ResponseDataModel<List<SprintModel>> getAll();
    public ResponseDataModel<SprintModel> getById(String id);
}
