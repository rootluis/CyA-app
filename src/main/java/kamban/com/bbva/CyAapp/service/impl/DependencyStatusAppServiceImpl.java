package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.DependencyAppClient;
import kamban.com.bbva.CyAapp.model.DependencyStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.DependencyStatusAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependencyStatusAppServiceImpl implements DependencyStatusAppService {

    @Autowired
    private DependencyAppClient _DependencyAppClient;

    @Override
    public ResponseDataModel<DependencyStatusModel> create(DependencyStatusModel data) {
        return _DependencyAppClient.createDependencyStatus(data);
    }

    @Override
    public ResponseDataModel<DependencyStatusModel> alter(DependencyStatusModel data) {
        return _DependencyAppClient.alterDependencyStatus(data);
    }

    @Override
    public ResponseDataModel<DependencyStatusModel> processDelete(String id) {
        return _DependencyAppClient.processDeleteDependencyStatus(id);
    }

    @Override
    public ResponseDataModel<List<DependencyStatusModel>> getAll() {
        return _DependencyAppClient.retrieveAll();
    }

    @Override
    public ResponseDataModel<DependencyStatusModel> getById(String id) {
        return _DependencyAppClient.retrieveById(id);
    }
}
