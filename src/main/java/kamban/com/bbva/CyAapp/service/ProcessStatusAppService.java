package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.ProcessStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;

import java.util.List;

public interface ProcessStatusAppService {
    public ResponseDataModel<ProcessStatusModel> create(ProcessStatusModel data);
    public ResponseDataModel<ProcessStatusModel> alter(ProcessStatusModel data);
    public ResponseDataModel<ProcessStatusModel> processDelete(String id);
    public ResponseDataModel<List<ProcessStatusModel>> getAll();
    public ResponseDataModel<ProcessStatusModel> getById(String id);
}
