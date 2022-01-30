import java.util.Scanner;

public class Apartment {
    private final String name;
    private final String metro;
    private final String address;
    private final int countRoom;
    private final double square;
    private final long price;
    private final double grade;

    public Apartment(String name, String metro, String address, int countRoom, double square, long price, double grade) {
        this.name = name;
        this.metro = metro;
        this.address = address;
        this.countRoom = countRoom;
        this.square = square;
        this.price = price;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public String getMetro() {
        return metro;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Квартира (" +
                "Наименование = '" + name + '\'' +
                ", Метро = '" + metro + '\'' +
                ", Адрес = '" + address + '\'' +
                ", Кол-во комнат = " + countRoom +
                ", Площадь = " + square +
                ", Цена = " + price +
                ", Оценка = " + grade +
                ')';
    }

    public static void addApartment(){
        System.out.print("Введите уникальное наименование: ");
        String name = Main.stringScanner();
        while (Main.apartmentMap.containsKey(name)){
            System.out.println("Квартира с таким наименованием уже существует");
            name = Main.stringScanner();
        }
        System.out.print("Введите станцию метро: ");
        String metro = Main.stringScanner();
        System.out.print("Введите адрес: ");
        String address = Main.stringScanner();
        System.out.print("Введите количество комнат: ");
        int countRoom = Integer.parseInt(Main.stringScanner());
        System.out.print("Введите площадь квартиры: ");
        double square = Double.parseDouble(Main.stringScanner());
        System.out.print("Введите цену: ");
        long price = Long.parseLong(Main.stringScanner());
        System.out.print("Введите среднюю оценку: ");
        double grade = Double.parseDouble(Main.stringScanner());
        Main.apartmentMap.put(name ,new Apartment(name, metro, address, countRoom, square, price, grade));
    }
    public static void deleteApartment(){
        System.out.print("Наименование квартиры, которую нужно удалить: ");
        String target = Main.stringScanner();
        Main.apartmentMap.remove(target);
    }
}
