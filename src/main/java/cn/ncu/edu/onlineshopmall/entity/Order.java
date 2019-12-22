package cn.ncu.edu.onlineshopmall.entity;

public class Order {

    private String oid;
    private String username;
    private String commodityid;
    private  String shopid;

    public String getOid() {
        return oid;
    }
    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", username='" + username + '\'' +
                ", commodityid='" + commodityid + '\'' +
                ", shopid=" + shopid +
                '}';
    }
}
