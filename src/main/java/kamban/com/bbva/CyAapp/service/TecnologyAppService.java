package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.TechnologyModel;

import java.util.List;

public interface TecnologyAppService {
    public ResponseDataModel<TechnologyModel> create(TechnologyModel data);
    public ResponseDataModel<TechnologyModel> alter(TechnologyModel data);
    public ResponseDataModel<TechnologyModel> processDelete(String id);
    public ResponseDataModel<List<TechnologyModel>> getAll();
    public ResponseDataModel<TechnologyModel> getById(String id);
}
