package Products;

public class BottleOfWater extends Product {
    private double volume;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume <= 0 ? 0.5 : (double) Math.round(volume * 100) / 100;
    }


    public BottleOfWater(String name, String brand, double price, double volume) {
        super(name, brand, price);
        this.setVolume(volume);
    }

    public BottleOfWater() {
        super();
        this.setVolume(0.5);
    }


    @Override
    public String displayInfo() {
        return String.format("Brand %s - Name %s - Price %.2f - Volume %.2fl",
                this.brand, this.name, this.price, this.volume);
    }
}
