package cn.ncu.edu.onlineshopmall.Dao;


import cn.ncu.edu.onlineshopmall.entity.Order;
import org.apache.ibatis.annotations.*;

import javax.annotation.Resource;
import java.util.List;

@Mapper
public interface OrderDao {



    /*
    **查询所有的订单信息
     */
    @Select("select * from indent")
    List<Order>  findAllOrder();



    /*
    **通过用户名username查询该用户的订单信息
     */
    @Select("select * from indent where username=#{username}")
    List<Order> findOrderByUsername(@Param("username") String username);



    /*
    **通过商品编号commodityid查询该商品的订单信息
     */
    @Select("select * from indent where commodityid=#{commodityid}")
    Order findOrderByCommodity(@Param("commodityid") String commodityid);


    /*
     **通过店铺编号shopid查询该商品的订单信息
     */
    @Select("SELECT * FROM indent WHERE shopid=#{shopid}")
    List<Order> findOrderByShopid(@Param("shopid") String shopid);



    /*
    **插入订单信息，oid是自增，无需提前设置
     */

    @Insert("insert into indent(oid,username,commodityid,shopid)"+
              "values(#{oid},#{username},#{commodityid},#{shopid})")
    void insertOrder(@Param("oid")String oid, @Param("username") String username, @Param("commodityid") String commodityid, @Param("shopid") String shopid);



    /*
    **通过商品编号commodityid删除该商品的订单信息
     */
    @Delete("delete from indent where commodityid=#{commodityid}")
    void deleteOrderByCommodityid(@Param("commodityid") String commodityid);





}
