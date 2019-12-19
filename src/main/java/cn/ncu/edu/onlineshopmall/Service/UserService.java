package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.UserDao;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserDao userDao;

    /**
     * 查询所有用户
     * @return List<User>
     */
    public List<User> findAll(){
        return userDao.findAllUser();
    }

    /**通过用户名查询用户信息
     * @return user
     */
    public User findUserByUsername(String name){
        return userDao.findUserByUsername(name);
    }

    /**
     * 判断用户是否存在
     * @param name
     * @return
     */
    public boolean isUserExist(String name){
        if (userDao.findUserByUsername(name)!=null){
            return true;
        }else
            return false;
    }

    /**
     * 添加用户
     * @param user
     * @return boolean
     */
    public boolean InsertUser(User user){
        return userDao.InsertUser(
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getSex(),
                user.getAddress(),
                user.getPhone(),
                user.getName(),
                user.getIdcard()
        );
    }

    /**
     * 注册成为会员
     * @param name
     * @param role
     * @return
     */
    public boolean updateUserRole(String name,int role){

        return userDao.updateUserByUR(name,role);
    }

    /**
     * 注销用户
     * @param name
     * @return
     */
    public boolean deleteUserByUsername(String name){

        return userDao.deleteUserByUsername(name);
    }
}
