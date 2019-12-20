package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.UserDao;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.stereotype.Service;

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

    public void editUser(User user) {
        //TODO 编辑用户信息
    }

    public void multiDelUsers(String ids) {
        //TODO 批量删除用户
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    //TODO 分页查询
//    public SearchResponse listUser(Integer pageNum, Integer pageSize, String keyword) {
//        keyword="%"+keyword+"%";
//        PageHelper.startPage(pageNum,pageSize);
//        UserExample example = new UserExample();
//        example.or().andUsernameLike(keyword);
//        List<User> users = userMapper.selectByExample(example);
//        return new SearchResponse(((Page)users).getTotal(),users);
//    }
}
