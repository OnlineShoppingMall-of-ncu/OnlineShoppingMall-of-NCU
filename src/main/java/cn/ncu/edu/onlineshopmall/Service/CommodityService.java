package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.CommodityDao;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import cn.ncu.edu.onlineshopmall.entity.ImagePath;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
                goods.getShopid()
        );
    }


}
