package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.SprintAppClient;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.SprintModel;
import kamban.com.bbva.CyAapp.service.SprintAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintAppServiceImpl implements SprintAppService {

    @Autowired
    private SprintAppClient _SprintAppClient;

    @Override
    public ResponseDataModel<SprintModel> create(SprintModel data) {
        return _SprintAppClient.createSprint(data);
    }

    @Override
    public ResponseDataModel<SprintModel> alter(SprintModel data) {
        return _SprintAppClient.alterSprint(data);
    }

    @Override
    public ResponseDataModel<SprintModel> processDelete(String id) {
        return _SprintAppClient.processDeleteSprint(id);
    }

    @Override
    public ResponseDataModel<List<SprintModel>> getAll() {
        return _SprintAppClient.getAll();
    }

    @Override
    public ResponseDataModel<SprintModel> getById(String id) {
        return _SprintAppClient.getById(id);
    }
}
