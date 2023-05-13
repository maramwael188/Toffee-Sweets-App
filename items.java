import java.util.ArrayList;

public class items
{
    private String nameOfItem;
    private String brandName;

    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceOfItem() {
        return priceOfItem;
    }

    public void setPriceOfItem(double priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<items> getObjCatalog() {
        return objCatalog;
    }

    public void setObjCatalog(ArrayList<items> objCatalog) {
        this.objCatalog = objCatalog;
    }

    private String description;
    private double priceOfItem;
    private int quantity;
    private String category;
    private ArrayList<items> objCatalog;

    public items(ArrayList<items> objCatalog) {
        this.objCatalog = objCatalog;
    }

    public items(String nameOfItem, String brandName, String description,String category, double priceOfItem, int quantity) {
        this.nameOfItem = nameOfItem;
        this.brandName = brandName;
        this.description = description;
        this.priceOfItem = priceOfItem;
        this.quantity = quantity;
        this.category = category;
    }

    public void  addItem(String nameOfItem , String brandName  , String description ,String category, double priceOfItem , int quantity)
    {
        items itm = new items( nameOfItem ,  brandName ,  description ,category,  priceOfItem ,  quantity);
        objCatalog.add(itm);
    }

    public String getCategory() {
        return category;
    }
}
