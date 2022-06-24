package kamban.com.bbva.CyAapp.service.impl;

import kamban.com.bbva.CyAapp.model.Disciplina;
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
    private RestTemplate restTemplate;

    @Autowired
    @Value("${disciplina.rest.all}")
    private String urlrest;

    @Autowired
    @Value("${disciplina.rest.getById}")
    private String urlRestFindById;

    @Autowired
    @Value("${disciplina.rest.getByCod}")
    private String urlrestfindByCod;

    @Autowired
    @Value("${disciplina.rest.add}")
    private String urlRestAddDiscipline;

    @Autowired
    @Value("${disciplina.rest.delete}")
    private String urlRestDeleteById;

    @Override
    public List<Disciplina> getdisciplinas() {
        ResponseEntity<List<Disciplina>> responseEntity = restTemplate.exchange(urlrest, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Disciplina>>() {
                });
        List<Disciplina> disciplinas = responseEntity.getBody();
        LOGGER.info(MessageFormatter.format(">>>>>[DisciplinaServicio] {} : {}<<<<<","Valor recuperado desde el Front", disciplinas).getMessage());
        return disciplinas;
    }

    @Override
    public Disciplina getDisciplinaById(String idDisciplina) {
        LOGGER.info(MessageFormatter.format(">>>>>[DisciplinaServicio] {} : {}<<<<<","Valor a recuperar", idDisciplina).getMessage());
        Disciplina disciplina = restTemplate.getForObject(urlRestFindById + "/" + idDisciplina, Disciplina.class);
        LOGGER.info(MessageFormatter.format(">>>>>[DisciplinaServicio] {} : {}<<<<<","Valor recuperado", disciplina).getMessage());
        return disciplina;
    }

    @Override
    public Disciplina getDisciplinaByCod(String codDisciplina) {
        return null;
    }

    @Override
    public void addDisciplina(Disciplina objDisciplina) {

        restTemplate.postForEntity(urlRestAddDiscipline, objDisciplina, String.class);
    }

    @Override
    public void deleteDisciplina(String idDisciplina) {
        restTemplate.delete(urlRestDeleteById + "/"+ idDisciplina);
    }
}
