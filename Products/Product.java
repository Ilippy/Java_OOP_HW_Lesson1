package Products;

import java.util.ArrayList;
import java.util.List;

public abstract class Product {
    
    protected String name;
    protected String brand;
    protected double price;
    private final static List<Product> products = new ArrayList<>();

    public static List<Product> getProducts(){
        return products;
    }

    public static void removeProduct(Product product){
        products.remove(product);
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price){
        this.price = price <= 0 ? 100 : (double) Math.round(price * 100) / 100;
    }

    public void setName(String name){
        this.name = name.length() < 5 ? "Product" : name;
    }

    public String getName(){
        return this.name;
    }

    public void setBrand(String brand){
        this.brand = brand.length() < 5 ? "NoName" : brand;
    }


    public String getBrand(){
        return this.brand;
    }


    public Product(){
        this("NoName", "Products.Product", 100);
    }

    public Product(String name, String brand, double price){
        this.setPrice(price);
        this.setBrand(brand);
        this.setName(name);
        products.add(this);
    }

    

    public abstract String displayInfo();
}
