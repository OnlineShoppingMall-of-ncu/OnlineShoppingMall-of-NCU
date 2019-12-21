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


    @Select("select *from shoppingcar where commodityid=#{commodityid}")
    ShoppingCar findShopcarByGoodsId(@Param("commodityid")String commodityid);
    /*
     **通过用户名username来查询该用户的购物车信息
     */
    @Select("select * from shoppingcar where username=#{username}")
    List<ShoppingCar> findShoppingCarByUsername(@Param("username") String username);


    /**
     *
     * @param shopid
     * @return
     */
    @Select("select *from shoppingcar where shopid=#{shopid}")
    ShoppingCar findShopcarByShopid(@Param("shopid")Integer shopid);

    /*
     **插入购物车信息
     */
    @Insert("insert into shoppingcar(username,commodityid)" +
            "values(#{username},#{commodityid})")
    void InsertShoppingCar(@Param("username") String username, @Param("commodityid") String commodityid);



    /**
     * 通过用户名username在表中清空该用户的购物车
     */
    @Delete("DELETE from shoppingcar WHERE username = #{username}")
    void deleteShoppingCarByUsername(@Param("username") String username);



    /**
     * 通过用户名username和商品编号commodityid在表中删除该条购物车消息
     */
    @Delete("DELETE from shoppingcar WHERE username = #{username} commodityid=#{commodityid}")
    void deleteShoppingCarByUC(@Param("username") String username,@Param("commodityid") String commodityid);




}
