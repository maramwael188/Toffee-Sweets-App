import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class catalog
{
    private ArrayList<items> Item;

    public catalog() {}

    public catalog(String filePath)
    {        this.Item = new ArrayList<>();
        loadItems(filePath);
    }
    public ArrayList<items> getItem() {
        return Item;
    }
    public void loadItems(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                String name = fields[0];
                String brandName = fields[1];
                String description = fields[2];
                String category = fields[3];
                double price = Double.parseDouble(fields[4]);
                int quantity = (int) Double.parseDouble(fields[5]);
                items item = new items(name, brandName, description,category, price, quantity);
                this.Item.add(item);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Catalog file not found: " + e.getMessage());
        }
    }
    public  void displayItem(String filename) {

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String nameOfItem = parts[0];
                String brandName = parts[1];
                String description = parts[2];
                String category = parts[3];
                double priceOfItem = Double.parseDouble(parts[4]);
                int quantity = (int) Double.parseDouble(parts[5]);

                items item = new items( nameOfItem ,  brandName ,  description ,category,  priceOfItem ,  quantity);
                System.out.println(item.getNameOfItem() + " : " + item.getPriceOfItem() );
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading catalog file: " + e.getMessage());
        }
    }
    public ArrayList<items> getItems() {
        return Item;
    }

    public ArrayList<items> getItemsByCategory(items category) {
        ArrayList<items> itemsByCategory = new ArrayList<>();
        for (items item : this.Item) {
            if (item.getCategory().equalsIgnoreCase(String.valueOf(Item))) {
                itemsByCategory.add(item);
            }
        }
        return itemsByCategory;
    }

    public ArrayList<items> searchItems(String keyword)
    {
        ArrayList<items> searchResults = new ArrayList<>();
        for (items item : this.Item) {
            if (item.getNameOfItem().toLowerCase().contains(keyword.toLowerCase()) ||
                    item.getBrandName().toLowerCase().contains(keyword.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
    }

}
