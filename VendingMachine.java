import Products.BottleOfJuice;
import Products.BottleOfMilk;
import Products.BottleOfWater;
import Products.Product;

public class VendingMachine {
    public static BottleOfWater getBottleOfWater(double volume){
        for (Product product: Product.getProducts()){
            if (product instanceof BottleOfWater){
                if (((BottleOfWater) product).getVolume() == volume){
                    return (BottleOfWater) product;
                }
            }
        }
        return null;
    }

    public static BottleOfMilk getBottleOfMilk(double fatContent){
        for (Product product: Product.getProducts()){
            if (product instanceof BottleOfMilk){
                if (((BottleOfMilk) product).getFatContent() == fatContent){
                    return (BottleOfMilk) product;
                }
            }
        }
        return null;
    }

    public static BottleOfMilk getBottleOfMilk(double fatContent, double volume){
        for (Product product: Product.getProducts()){
            if (product instanceof BottleOfMilk){
                if (((BottleOfMilk) product).getVolume() == volume &&
                        ((BottleOfMilk) product).getFatContent() == fatContent){
                    return (BottleOfMilk) product;
                }
            }
        }
        return null;
    }

    public static BottleOfJuice getBottleOfJuice(String juiceType) {
        for (Product product: Product.getProducts()){
            if (product instanceof BottleOfJuice){
                if (((BottleOfJuice) product).getJuiceType().equals(juiceType)){
                    return (BottleOfJuice) product;
                }
            }
        }
        return null;
    }
    // TODO how to make it DRY
}
