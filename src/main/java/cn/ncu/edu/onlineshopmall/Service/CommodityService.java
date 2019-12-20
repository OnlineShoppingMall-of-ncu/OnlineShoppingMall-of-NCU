package cn.ncu.edu.onlineshopmall.Service;

import cn.ncu.edu.onlineshopmall.Dao.CommodityDao;
import cn.ncu.edu.onlineshopmall.entity.Commodity;
import cn.ncu.edu.onlineshopmall.entity.User;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
        return findAllCommdityByShopid(id);
    }



}
