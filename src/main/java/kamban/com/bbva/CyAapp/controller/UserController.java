package kamban.com.bbva.CyAapp.controller;

import kamban.com.bbva.CyAapp.model.User;
import kamban.com.bbva.CyAapp.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserAppService userService;

//    @Autowired
//    public UserController(UserAppService userService) {
//        this.userService = userService;
//    }
//
//    public String getUsers(Model theModel){
//        List<User> listUsers = userService.users();
//        theModel.addAttribute("users",listUsers);
//        return "user/users";
//    }
//
//    public String getUser(Model theModel){
//        List<User> listUsers = userService.users();
//        theModel.addAttribute("users",listUsers);
//        return "user/user";
//    }

}
