package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.ShopDao;
import cn.ncu.edu.onlineshopmall.entity.Shop;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopService {
    @Resource
    private ShopDao shopDao;

    /**
     *查询所有的店铺信息
     * @return List<Shop>
     */
    public List<Shop> findAll(){
        return shopDao.findAllShop();
    }

    /**
     *通过店铺唯一编号shopid来查询店铺信息
     * @return Shop
     */
    public Shop findShopByShopid(String shopid){
        return shopDao.findShopByShopid(shopid);
    }

    /**
     *通过用户名username来查询该用户（所有）的一条店铺信息（一个用户只能有一个店铺的话就是一条，不然就是所有）
     * @return Shop
     */
    public Shop findShopByUsername(String username){
        return shopDao.findShopByUsername(username);
    }

    /**
     *插入店铺信息,店铺唯一编号不是自增，需要提前设置
     * @param shopid
     * @param username
     */
    public void InsertShop(String shopid, String username){
        shopDao.InsertShop(shopid,username);
    }

    /**
     * 通过评价唯一编号shopid在表中删除一条店铺信息
     * @param shopid
     */
    public void deleteShopByShopid(String shopid){
        shopDao.deleteShopByShopid(shopid);
    }

    /**
     * 通过用户名username在表中删除这一用户的所有店铺信息
     * @param username
     */
    public  void deleteShopByUsername(String username){
        shopDao.deleteShopByUsername(username);
    }
}
