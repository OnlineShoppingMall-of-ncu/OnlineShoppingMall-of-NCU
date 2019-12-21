package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.ShoppingCarDao;
import cn.ncu.edu.onlineshopmall.entity.ShoppingCar;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingCarService {
    @Resource
    private ShoppingCarDao ShoppingCarDao;

    /**
     *通过用户名username来查询该用户的购物车信息
     * @return List<ShoppingCar>
     */
    public List<ShoppingCar> findShoppingCarByUsername(String username){
        return ShoppingCarDao.findShoppingCarByUsername(username);
    }

    /**
     *插入购物车信息
     * @param username
     * @param commodityid
     */
    public void InsertShoppingCar(String username, String commodityid){
        ShoppingCarDao.InsertShoppingCar(username,commodityid);
    }

    /**
     * 通过用户名username在表中清空该用户的购物车
     * @param username
     */
    public void deleteShoppingCarByUsername(String username){
        ShoppingCarDao.deleteShoppingCarByUsername(username);
    }

    /**
     * 通过用户名username和商品编号commodityid在表中删除该条购物车消息
     * @param username
     * @param commodityid
     */
    public void deleteShoppingCarByUC(String username,String commodityid){
        ShoppingCarDao.deleteShoppingCarByUC(username,commodityid);
    }

    /**
     * by shopid find
     * @param shopid
     */
    public ShoppingCar findShopCarbyShopid(Integer shopid){
        return ShoppingCarDao.findShopcarByShopid(shopid);
    }

    /**
     *
     * @param goodsid
     */
    public ShoppingCar  findShopCarShopByGoodsId(String goodsid){
        return  ShoppingCarDao.findShopcarByGoodsId(goodsid);
    }
}
