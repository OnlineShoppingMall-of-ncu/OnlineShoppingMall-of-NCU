package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.CommodityDao;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class CommodityService {

    @Resource
    private CommodityDao commodityDao;

    /**
     * 查找所有商品
     * @return
     */
    public List<Commodity> findAllCommodity(){
        return commodityDao.findAllCommodity();
    }

    /**
     * 根据店铺查找商品
     * @param id
     * @return
     */
    public List<Commodity> findAllCommodityByShopid(String id){
        return commodityDao.findCommodityByShopid(id);
    }

    /**
     * 根据商品编号删除商品
     * @param id
     * @return
     */
    public boolean deleteCommodityById(String id){
        return commodityDao.deleteCommodityByCommodity(id);
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
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

    /**
     * 根据商品编号查找商品
     * @param id
     * @return
     */
    public Commodity findGoodsById(String id){
        return commodityDao.findCommodityByCommodity(id);
    }

    /**
     * 根据商品编号查找商品图片路径
     * @param commodityid
     * @return
     */
    public String findImagePath(String commodityid) {
        //TODO 查询商品的照片路径
        return commodityDao.findImagePathById(commodityid);
    }

    /**
     * 通过商品分累查找商品
     * @param category
     * @return
     */
    public List<Commodity> selectByCategory(String category,Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return commodityDao.findCommodityByCategory(category);

    }

}
