import java.util.Scanner;

public class CommercialPremises {
    private final String name;
    private final String metro;
    private final String address;
    private final String type;
    private final double square;
    private final long price;
    private final double grade;

    public CommercialPremises(String name, String metro, String address, String type, double square, long price, double grade) {
        this.name = name;
        this.metro = metro;
        this.address = address;
        this.type = type;
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
        return "Коммерческое помещение(" +
                "Название = '" + name + '\'' +
                ", Метро = '" + metro + '\'' +
                ", Адрес ='" + address + '\'' +
                ", Тип ='" + type + '\'' +
                ", Площадь =" + square +
                ", Цена = " + price +
                ", Оценка =" + grade +
                ')';
    }

    public static void addPremises(){
        System.out.print("Введите наименование: ");
        String name = Main.stringScanner();
        System.out.print("Введите станцию метро: ");
        String metro = Main.stringScanner();
        System.out.print("Введите адрес: ");
        String address = Main.stringScanner();
        System.out.print("Введите тип помещения: ");
        String type = Main.stringScanner();
        System.out.print("Введите площадь квартиры: ");
        double square = Double.parseDouble(Main.stringScanner());
        System.out.print("Введите цену: ");
        long price = Long.parseLong(Main.stringScanner());
        System.out.print("Введите среднюю оценку: ");
        double grade = Double.parseDouble(Main.stringScanner());
        Main.commercialPremisesMap.put(name ,new CommercialPremises(name, metro, address, type, square, price, grade));
    }
    public static void deletePremises(){
        System.out.print("Наименование помещения, которое нужно удалить: ");
        String target = Main.stringScanner();
        Main.commercialPremisesMap.remove(target);
    }
}
