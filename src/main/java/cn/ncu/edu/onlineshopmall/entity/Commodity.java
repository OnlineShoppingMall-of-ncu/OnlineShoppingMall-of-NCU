package cn.ncu.edu.onlineshopmall.entity;



public class Commodity {
    private String commodityid;
    private String decription;
    private String Category;
    private float price;

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid;
    }

    private int shopid;

    public String getCommodityid() {
        return commodityid;
    }


    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }
}
