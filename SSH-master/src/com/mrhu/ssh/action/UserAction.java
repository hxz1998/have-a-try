package com.mrhu.ssh.action;

import com.mrhu.ssh.model.User;
import com.mrhu.ssh.service.UserService;
import com.mrhu.ssh.vo.UserDto;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<UserDto>{

    private UserService userService;
    private UserDto userDto = new UserDto();
    private List<User> users;

    private User user;

    @Override
    public String execute() {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        if(userService.exist(user) || !userDto.getPassword().equals(userDto.getPassword2())) {
            return ERROR;
        } else {
            userService.save(user);
            return SUCCESS;
        }
    }

    public String getUserList() {
        users = userService.getUserList();
        return "list";
    }

    public String getUserById() {
        user = userService.getUserById(userDto.getId());
        return "getUser";
    }

    public UserService getUserService() {
        return userService;
    }

    @Resource(name="userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public UserDto getModel() {
        return userDto;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
