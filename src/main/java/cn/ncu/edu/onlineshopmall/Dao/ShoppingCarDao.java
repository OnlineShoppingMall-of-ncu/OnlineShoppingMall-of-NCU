package cn.ncu.edu.onlineshopmall.Dao;

import cn.ncu.edu.onlineshopmall.entity.ShoppingCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCarDao {

//    /*
//     **查询所有的购物车信息
//     */
//    @Select("select * from shoppingcar ")
//    List<ShoppingCar> findAllShoppingCar();



    /*
     **通过用户名username来查询该用户的购物车信息
     */
    @Select("select * from shoppingcar where username=#{username}")
    List<ShoppingCar> findShoppingCarByUsername(@Param("username") String username);



//    !!!!!!!!!!!!!!查询商品信息应该去Commodity里去查，不要来这里找!!!!!!!!!!!!!!!这里只提供商品唯一编号，即商品的主键
//    /*
//     **通过用户名username和商品唯一编号commodityid来查询该用户购物车的一个商品信息？？？？
//     */
//    @Select("select * from shoppingchar where username=#{username} and shopid=#{shopid}")
//    ShoppingChar findShoppingCharByUC(@Param("username") String username,@Param("shopid") int shopid);



    /*
     **插入购物车信息
     */
    @Insert("insert into shoppingcar(username，commodityid)" +
            "values(#{username}，#{commodityid})")
    void InsertShoppingCar(@Param("username") String username, @Param("commodityid") int commodityid);



    /**
     * 通过用户名username在表中清空该用户的购物车
     */
    @Delete("DELETE from shoppingcar WHERE username = #{username}")
    void deleteShoppingCarByUsername(@Param("username") String username);



    /**
     * 通过用户名username和商品编号commodityid在表中删除该条购物车消息
     */
    @Delete("DELETE from shoppingcar WHERE username = #{username} commodityid=#{commodityid}")
    void deleteShoppingCarByUC(@Param("username") String username,@Param("commodityid") int commodityid);




}
