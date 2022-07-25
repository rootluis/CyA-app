package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.ContinuityModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;

import java.util.List;

public interface ContinuityAppService {
    public ResponseDataModel<ContinuityModel> create(ContinuityModel data);
    public ResponseDataModel<ContinuityModel> alter(ContinuityModel data);
    public ResponseDataModel<ContinuityModel> processDelete(String id);
    public ResponseDataModel<List<ContinuityModel>> getAll();
    public ResponseDataModel<ContinuityModel> getById(String id);

}
