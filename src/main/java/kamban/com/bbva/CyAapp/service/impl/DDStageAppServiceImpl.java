package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.DDStageAppClient;
import kamban.com.bbva.CyAapp.model.DDStageModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.DDStageAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DDStageAppServiceImpl implements DDStageAppService {

    @Autowired
    private DDStageAppClient _ddStageAppClient;

    @Override
    public ResponseDataModel<DDStageModel> create(DDStageModel data) {
        return _ddStageAppClient.createStage(data);
    }

    @Override
    public ResponseDataModel<DDStageModel> alter(DDStageModel data) {
        return _ddStageAppClient.alterStage(data);
    }

    @Override
    public ResponseDataModel<DDStageModel> processDelete(String id) {
        return _ddStageAppClient.disableStage(id);
    }

    @Override
    public ResponseDataModel<List<DDStageModel>> getAll() {
        return _ddStageAppClient.retrieveAll();
    }

    @Override
    public ResponseDataModel<DDStageModel> getById(String id) {
        return _ddStageAppClient.retrieveById(id);
    }
}
