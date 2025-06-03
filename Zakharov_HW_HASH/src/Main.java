import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> countries = new HashSet<>();

        costPerAddress.put(new Address("Россия", "Москва"), 50);
        costPerAddress.put(new Address("Венгрия", "Будапешт"), 200);
        costPerAddress.put(new Address("Россия", "Краснодар"), 150);
        costPerAddress.put(new Address("Франция", "Париж"), 300);
        costPerAddress.put(new Address("Франция", "Лион"), 350);
        costPerAddress.put(new Address("Россия", "Барнаул"), 400);

        int totalCost = 0;

        while (true) {
            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.nextLine();
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.nextLine();
            System.out.print("Введите вес (кг): ");
            int weight = Integer.parseInt(scanner.nextLine());
            Address address = new Address(country, city);

            if (costPerAddress.containsKey(address)) {
                int price = weight * costPerAddress.get(address);
                totalCost += price;
                countries.add(country);
                System.out.println("Стоимость доставки составит: " + price + " руб.");
                System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");

                System.out.println("Количество уникальных стран, в которые были оформлены доставки: " + countries.size());
            } else {
                System.out.println("Доставки по этому адресу нет");
            }


        }

    }
}