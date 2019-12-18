package cn.ncu.edu.onlineshopmall.Dao;

import cn.ncu.edu.onlineshopmall.entity.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingChar {

//    /*
//     **查询所有的购物车信息
//     */
//    @Select("select * from shoppingchar ")
//    List<ShoppingChar> findAllShoppingChar();



    /*
     **通过用户名username来查询该用户的购物车信息
     */
    @Select("select * from shoppingchar where username=#{username}")
    List<ShoppingChar> findShoppingCharByUsername(@Param("username") String username);


//    !!!!!!!!!!!!!!查询商品信息应该去Commodity里去查，不要来这里找!!!!!!!!!!!!!!!这里只提供商品唯一编号，即商品的主键
//    /*
//     **通过用户名username和商品唯一编号commodityid来查询该用户购物车的一个商品信息？？？？
//     */
//    @Select("select * from shoppingchar where username=#{username} and shopid=#{shopid}")
//    ShoppingChar findShoppingCharByUC(@Param("username") String username,@Param("shopid") int shopid);



    /*
     **插入购物车信息
     */
    @Insert("insert into shoppingchar(username，commodityid)" +
            "values(#{username}，#{commodityid})")
    void InsertShoppingChar(@Param("username") String username, @Param("commodityid") int commodityid);



    /**
     * 通过用户名username在表中清空该用户的购物车
     */
    @Delete("DELETE from shoppingchar WHERE username = #{username}")
    void deleteShoppingCharByUsername(@Param("username") String username);


    /**
     * 通过评价唯一编号shopid在表中删除一条店铺信息
     */
    @Delete("DELETE from shoppingchar WHERE shopid = #{shopid}")
    void deleteShoppingCharByShopid(@Param("shopid") int shopid);




}
