package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.AreaAppClient;
import kamban.com.bbva.CyAapp.model.AreaModel;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.AreaAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AreaAppServiceImp implements AreaAppService {

    @Autowired
    private AreaAppClient _areaAppClient;

    @Override
    public ResponseDataModel<AreaModel> createArea(AreaModel areaData) {
        return _areaAppClient.createArea(areaData);
    }

    @Override
    public ResponseDataModel<AreaModel> alterArea(AreaModel areaData) {
        return _areaAppClient.updateArea(areaData);
    }

    @Override
    public ResponseDataModel<AreaModel> disabledArea(String areaId) {
        return _areaAppClient.processDisableArea(areaId);
    }

    @Override
    public ResponseDataModel<List<AreaModel>> getAll() {
        return  _areaAppClient.getAll();
    }

    @Override
    public ResponseDataModel<AreaModel> getById(String id) {
        return _areaAppClient.getById(id);
    }
}
