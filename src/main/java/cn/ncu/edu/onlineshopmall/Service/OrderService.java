package cn.ncu.edu.onlineshopmall.Service;


import cn.ncu.edu.onlineshopmall.Dao.OrderDao;
import cn.ncu.edu.onlineshopmall.entity.Order;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
     private OrderDao  orderDao;

    /*
     *查询所有订单信息
     *
     */
    public List<Order> findAllOrder(){
        return orderDao.findAllOrder();
    }



    /*
    **通过用户名username查询该用户的订单信息
     */
    public List<Order> findOrderByUsername(String username){
        return orderDao.findOrderByUsername(username);
    }



     /*
    **通过店铺编号shopid查询该商品的订单信息
     */
    public List<Order> findOrderByShopid(String shopid){
        return orderDao.findOrderByShopid(shopid);
    }



    /*
     **插入订单信息，oid是自增，无需提前设置
     */
    public void insertOrder(String oid, String username,String commodityid, String shopid){
        orderDao.insertOrder(oid,username,commodityid,shopid);
    }



    /*
     **通过商品编号commodityid删除该商品的订单信息
     */
    public void deleteOrderByCommodityid(String commodityid){
        orderDao.deleteOrderByCommodityid(commodityid);
    }


}
