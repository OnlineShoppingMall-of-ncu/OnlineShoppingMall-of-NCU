package cn.ncu.edu.onlineshopmall.entity;



public class Commodity {
    private String commodityid;
    private String decription;
    private String category;
    private float price;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String path;

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    private String shopid;

    public String getCommodityid() {
        return commodityid;
    }


    public String getDecription() {
        return decription;
    }

    public String getShopid() {
        return shopid;
    }

    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
