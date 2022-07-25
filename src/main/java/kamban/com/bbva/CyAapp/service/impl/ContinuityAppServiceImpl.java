package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.ContinuityAppClient;
import kamban.com.bbva.CyAapp.model.ContinuityModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.ContinuityAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinuityAppServiceImpl implements ContinuityAppService {

    @Autowired
    private ContinuityAppClient _continuityAppClient;


    @Override
    public ResponseDataModel<ContinuityModel> create(ContinuityModel data) {
        return _continuityAppClient.createContinuity(data);
    }

    @Override
    public ResponseDataModel<ContinuityModel> alter(ContinuityModel data) {
        return _continuityAppClient.alterContinuity(data);
    }

    @Override
    public ResponseDataModel<ContinuityModel> processDelete(String id) {
        return _continuityAppClient.processDelete(id);
    }

    @Override
    public ResponseDataModel<List<ContinuityModel>> getAll() {
        return _continuityAppClient.getAll();
    }

    @Override
    public ResponseDataModel<ContinuityModel> getById(String id) {
        return _continuityAppClient.getById(id);
    }
}
