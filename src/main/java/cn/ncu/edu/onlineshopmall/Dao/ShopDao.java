package cn.ncu.edu.onlineshopmall.Dao;



import cn.ncu.edu.onlineshopmall.entity.Shop;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShopDao {
    /*
     **查询所有的店铺信息
     */
    @Select("select * from shop ")
    List<Shop> findAllShop();



    /*
     **通过店铺唯一编号shopid来查询店铺信息
     */
    @Select("select * from shop where shopid=#{shopid}")
    Shop findShopByShopid(@Param("shopid") int shopid);



    /*
     **通过用户名username来查询该用户（所有）的一条店铺信息（一个用户只能有一个店铺的话就是一条，不然就是所有）
     */
    @Select("select * from shop where username=#{username}")
    Shop findShopByUsername(@Param("username") String username);



    /*
     **插入店铺信息,店铺唯一编号不是自增，需要提前设置
     */
    @Insert("insert into shop(shopid,username)" +
            "values(#{shopid}, #{username})")
    void InsertShop(@Param("shopid") int shopid, @Param("username") String username);



    /**
     * 通过评价唯一编号shopid在表中删除一条店铺信息
     */
    @Delete("DELETE from shop WHERE shopid = #{shopid}")
    void deleteShopByShopid(@Param("shopid") int shopid);



    /**
     * 通过用户名username在表中删除这一用户的所有店铺信息
     */
    @Delete("DELETE from shop WHERE username = #{username}")
    void deleteShopByUsername(@Param("username") String username);

}
