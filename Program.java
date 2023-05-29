import Products.BottleOfJuice;
import Products.BottleOfMilk;
import Products.BottleOfWater;
import Products.Product;

import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        createRandomProducts();
        boolean check = true;
        while (check) {
            if (Product.getProducts().size() != 0) {
                System.out.println("--------------");
                showProducts();
                System.out.println("--------------");
                System.out.println("Выберете, что вы хотите купить:");
                System.out.println("1 - Бутылку воды");
                System.out.println("2 - Бутылку молока");
                System.out.println("3 - Бутылка сока");
                System.out.println("0 - Выход");
                Scanner scanner = new Scanner(System.in);
                int customerChoiceInt = scanner.nextInt();
                switch (customerChoiceInt) {
                    case 1 -> {
                        System.out.println("Какого объема?");
                        double volume = scanner.nextDouble();
                        getBottleOfWater(volume);
                    }
                    case 2 -> {
                        System.out.println("Какой жирности?");
                        double fatContent = scanner.nextDouble();
                        getBottleOfMilk(fatContent);
                    }
                    case 3 -> {
                        System.out.println("Какой сок?");
                        String juiceType = scanner.next();
                        getBottleOfJuice(juiceType);
                    }
                    case 0 -> check = false;
                    default -> System.out.println("Введите корректную цифру");
                }
            } else {
                System.out.println("В автомате не осталось товаров");
                check = false;
            }
        }

    }



    private static void createRandomProducts() {
        Random rand = new Random();
        int numberOfBottleOfWater = rand.nextInt(1, 5);
        int numberOfBottleOfMilk = rand.nextInt(1, 5);
        int numberOfBottleOfJuice = rand.nextInt(1, 5);

        for (int i = 1; i <= numberOfBottleOfWater; i++) {
            new BottleOfWater("Бутылка с водой " + i, "ООО Лучшая Вода", rand.nextDouble(50, 300),
                    rand.nextDouble(0.5, 5));
        }

        for (int i = 1; i <= numberOfBottleOfMilk; i++) {
            new BottleOfMilk("Бутылка с молоком " + i, "ООО Лучшее Молоко", rand.nextDouble(50, 300),
                    rand.nextDouble(0.5, 5), rand.nextDouble(0, 5));
        }

        for (int i = 1; i <= numberOfBottleOfJuice; i++) {
            new BottleOfJuice("Бутылка с соком " + i, "ООО Лучший Сок", rand.nextDouble(50, 300),
                    rand.nextDouble(0.5, 5), BottleOfJuice.getRandomJuiceType());
        }
    }

    private static void showProducts() {
        for (Product product : Product.getProducts()) {
            System.out.println(product.displayInfo());
        }
    }

    private static void getBottleOfWater(double volume) {
        BottleOfWater result = VendingMachine.getBottleOfWater(volume);
        displayResult(result);
    }

    private static void getBottleOfMilk(double fatContent) {
        BottleOfMilk result = VendingMachine.getBottleOfMilk(fatContent);
        displayResult(result);
    }
    private static void getBottleOfJuice(String juiceType) {
        BottleOfJuice result = VendingMachine.getBottleOfJuice(juiceType);
        displayResult(result);
    }

    private static void displayResult(Product result) {
        if (result != null) {
            System.out.println("Вы купили:");
            System.out.println(result.displayInfo());
            Product.removeProduct(result);
        } else {
            System.out.println("Такого товара нет в автомате");
        }
    }
}
