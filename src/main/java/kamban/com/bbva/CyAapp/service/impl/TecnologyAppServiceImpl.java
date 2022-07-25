package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.TechnologyAppClient;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.model.TechnologyModel;
import kamban.com.bbva.CyAapp.service.TecnologyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologyAppServiceImpl implements TecnologyAppService {

    @Autowired
    private TechnologyAppClient _TechnologyAppClient;

    @Override
    public ResponseDataModel<TechnologyModel> create(TechnologyModel data) {
        return _TechnologyAppClient.createTecnology(data);
    }

    @Override
    public ResponseDataModel<TechnologyModel> alter(TechnologyModel data) {
        return _TechnologyAppClient.alterTecnologi(data);
    }

    @Override
    public ResponseDataModel<TechnologyModel> processDelete(String id) {
        return _TechnologyAppClient.processDeleteTecnologi(id);
    }

    @Override
    public ResponseDataModel<List<TechnologyModel>> getAll() {
        return _TechnologyAppClient.getTechnologies();
    }

    @Override
    public ResponseDataModel<TechnologyModel> getById(String id) {
        return _TechnologyAppClient.getTechnologyById(id);
    }
}
