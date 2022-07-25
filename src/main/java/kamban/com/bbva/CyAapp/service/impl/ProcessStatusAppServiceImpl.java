package kamban.com.bbva.CyAapp.service.impl;


import kamban.com.bbva.CyAapp.appClients.ProcessStatusAppClient;
import kamban.com.bbva.CyAapp.model.ProcessStatusModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.ProcessStatusAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessStatusAppServiceImpl implements ProcessStatusAppService {

    @Autowired
    private ProcessStatusAppClient _ProcessStatusAppClient;

    @Override
    public ResponseDataModel<ProcessStatusModel> create(ProcessStatusModel data) {
        return _ProcessStatusAppClient.createProcessStatus(data);
    }

    @Override
    public ResponseDataModel<ProcessStatusModel> alter(ProcessStatusModel data) {
        return _ProcessStatusAppClient.alter(data);
    }

    @Override
    public ResponseDataModel<ProcessStatusModel> processDelete(String id) {
        return _ProcessStatusAppClient.processDelete(id);
    }

    @Override
    public ResponseDataModel<List<ProcessStatusModel>> getAll() {
        return _ProcessStatusAppClient.retrieveAll();
    }

    @Override
    public ResponseDataModel<ProcessStatusModel> getById(String id) {
        return _ProcessStatusAppClient.retrieveById(id);
    }
}
