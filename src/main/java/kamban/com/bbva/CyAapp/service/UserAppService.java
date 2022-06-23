package kamban.com.bbva.CyAapp.service;

import kamban.com.bbva.CyAapp.model.User;

import java.util.List;

public interface UserAppService {

    public List<User> users();

    public User user(String id);

}
