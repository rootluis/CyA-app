package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.appClients.DisciplinaAppClient;
import kamban.com.bbva.CyAapp.model.Disciplina;
import kamban.com.bbva.CyAapp.model.MDLDisciplina;
import kamban.com.bbva.CyAapp.model.ResponseDataModel;
import kamban.com.bbva.CyAapp.service.DisciplinaAppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class DisciplinaAppServiceImpl implements DisciplinaAppService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisciplinaAppServiceImpl.class);

    @Autowired
    private DisciplinaAppClient _disciDisciplinaAppClient;

    @Override
    public ResponseDataModel<MDLDisciplina> create(MDLDisciplina data) {
        return _disciDisciplinaAppClient.createDisciplina(data);
    }

    @Override
    public ResponseDataModel<MDLDisciplina> alter(MDLDisciplina data) {
        return _disciDisciplinaAppClient.updateDisciplina(data);
    }

    @Override
    public ResponseDataModel<MDLDisciplina> processDelete(String id) {
        return _disciDisciplinaAppClient.processDeleteDiscipline(id);
    }

    @Override
    public ResponseDataModel<List<MDLDisciplina>> getAll() {
        return _disciDisciplinaAppClient.getAll();
    }

    @Override
    public ResponseDataModel<MDLDisciplina> getById(String id) {
        return _disciDisciplinaAppClient.getById(id);
    }
}
