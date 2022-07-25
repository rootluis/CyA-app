package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.DDStageModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;

import java.util.List;

public interface DDStageAppService {
    public ResponseDataModel<DDStageModel> create(DDStageModel data);
    public ResponseDataModel<DDStageModel> alter(DDStageModel data);
    public ResponseDataModel<DDStageModel> processDelete(String id);
    public ResponseDataModel<List<DDStageModel>> getAll();
    public ResponseDataModel<DDStageModel> getById(String id);
}
