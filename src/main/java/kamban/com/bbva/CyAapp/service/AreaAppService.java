package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.AreaModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;

import java.util.List;

public interface AreaAppService {
    public ResponseDataModel<AreaModel> createArea(AreaModel areaData);
    public ResponseDataModel<AreaModel> alterArea(AreaModel areaData);
    public ResponseDataModel<AreaModel> disabledArea(String areaId);

    public ResponseDataModel<List<AreaModel>> getAll();
    public ResponseDataModel<AreaModel> getById(String id);
}
