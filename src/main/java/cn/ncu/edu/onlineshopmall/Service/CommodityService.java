package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.CommodityDao;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityService {

    @Resource
    private CommodityDao commodityDao;

    public List<Commodity> findAllCommodity(){
        return commodityDao.findAllCommodity();
    }

    public List<Commodity> findAllCommdityByShopid( int id){
        return commodityDao.findCommodityByShopid(id);
    }

    public boolean deleteCommodityById(String id){
        return commodityDao.deleteCommodityByCommodity(id);
    }

    public boolean addGoods(Commodity goods){
        return commodityDao.InsertCommodity(
                goods.getCommodityid(),
                goods.getDecription(),
                goods.getCategory(),
                goods.getPrice(),
                goods.getShopid(),
                goods.getPath()
        );
    }
    public Commodity findGoodsById(String id){
        return commodityDao.findCommodityByCommodity(id);
    }


    public String findImagePath(String commodityid) {
        //TODO 查询商品的照片路径
        return commodityDao.findImagePathById(commodityid);
    }

}
