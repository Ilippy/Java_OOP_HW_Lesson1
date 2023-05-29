package Products;

public class BottleOfMilk extends Product {
    private double volume;
    private double fatContent;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {

        this.volume = volume <= 0 ? 0.5 : (double) Math.round(volume * 100) / 100;
    }

    public double getFatContent() {
        return fatContent;
    }

    public void setFatContent(double fatContent) {
        this.fatContent = fatContent < 0 ? 3.2 : (double) Math.round(fatContent * 100) / 100;
    }


    public BottleOfMilk(String name, String brand, double price, double volume, double fatContent) {
        super(name, brand, price);
        this.setVolume(volume);
        this.setFatContent(fatContent);
    }

    @Override
    public String displayInfo() {
        return String.format("Brand %s - Name %s - Price %.2f - Volume %.2fl - FatContent %.2f%%",
                this.brand, this.name, this.price, this.volume, this.fatContent);
    }
}
