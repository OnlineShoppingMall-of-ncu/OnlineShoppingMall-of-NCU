package cn.ncu.edu.onlineshopmall.Dao;


import cn.ncu.edu.onlineshopmall.entity.Commodity;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CommodityDao {
    /*
     *查询所有的商品信息
     */
    @Select("SELECT * FROM commodity")
    List<Commodity> findAllCommodity() ;



    /*
    **通过商品编号commodityid来查询商品
     */
    @Select("SELECT * FROM commodity WHERE commodityid = #{commodityid}")
    Commodity findCommodityByCommodity(@Param("commodityid") int commodityid);



    /*
     **通过商品分类Category来查询商品
     */
    @Select("SELECT * FROM commodity WHERE Category= #{Category}")
    List<Commodity> findCommodityByCategory(@Param("Category") String Category);



    /*
     **通过商品所属的店铺号shopid来查询商品
     */
    @Select("SELECT * FROM commodity WHERE shopid= #{shopid}")
    List<Commodity> findCommodityByShopid(@Param("shopid") int shopid);



    /*
    **插入5个商品信息,商品编号不是自增，需要提前设置
     */
    @Insert("insert into commodity(commodityid，decription，Category，price，shopid)" +
            "values(#{commodityid}, #{decription}, #{Category}, #{price}, #{shopid})")
    void InsertCommodity(@Param("commodityid") int commodityid, @Param("decription") String decription, @Param("Category") String Category,
                         @Param("price") float price, @Param("shopid") int shopid);



    /**
     * 通过商品编号commodityid在表中删除一条商品信息
     */
    @Delete("DELETE from commodity WHERE commodityid = #{commodityid}")
    void deleteCommodityBycommodity(@Param("commodityid") int commodityid);



    /**
     * 通过商品分类Category在表中删除这一分类的所有商品信息
     */
    @Delete("DELETE from commodity WHERE Category = #{Category}")
    void deleteCommodityByCategory(@Param("Category") String Category);



    /**
     * 通过商品所属的店铺号shopid在表中删除这一店铺的所有商品信息
     */
    @Delete("DELETE from commodity WHERE shopid = #{shopid}")
    void deleteCommodityByShopid(@Param("shopid") int shopid);


}
