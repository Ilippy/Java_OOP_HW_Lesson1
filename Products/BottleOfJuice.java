package Products;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BottleOfJuice extends Product {

    private double volume;


    private String juiceType;

    public String getJuiceType() {
        return juiceType;
    }

    public void setJuiceType(String juiceType) {
        this.juiceType = juiceTypes.contains(juiceType) ? juiceType : getRandomJuiceType();
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume <= 0 ? 0.5 : (double) Math.round(volume * 100) / 100;
    }

    private final static List<String> juiceTypes = new ArrayList<>(
            Arrays.asList("Апельсиновый", "Яблочный", "Абрикосовый", "Виноградный", "Гранатовый", "Грейпфрутовый"));

    public static String getRandomJuiceType() {
        Random rand = new Random();
        return juiceTypes.get(rand.nextInt(juiceTypes.size()));
    }

    public BottleOfJuice(String name, String brand, double price, double volume, String juiceType) {
        super(name, brand, price);
        this.setVolume(volume);
        this.juiceType = juiceType;
    }

    @Override
    public String displayInfo() {
        return String.format("Brand %s - Name %s - Price %.2f - Volume %.2fl - JuiceType %s",
                this.brand, this.name, this.price, this.volume, this.juiceType);
    }
}
