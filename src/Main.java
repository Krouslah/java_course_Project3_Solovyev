import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, Apartment> apartmentMap = new HashMap<>();
    public static Map<String, CommercialPremises> commercialPremisesMap = new HashMap<>();

    public static void main(String[] args) {
        menu();
        System.out.println("Увидимся");
    }

    public static void menu() {
        boolean flag = true;
        int i;
        while (flag) {
            System.out.println("""
                    1.  Добавить квартиру
                    2.  Удалить квартиру
                    3.  Добавить коммерческое помещение
                    4.  Удалить коммерческое помещение
                    5.  Вывести квартиры по цене начиная с дешевых
                    6.  Вывести квартиры по цене начиная с дорогих
                    7.  Вывести коммерческие помещения по цене начиная с дешевых
                    8.  Вывести коммерческие помещения по цене начиная с дорогих
                    9.  Сгруппировать и вывести квартиры по метро
                    10. Сгруппировать и вывести коммерческие помещения по метро
                    11. Вывести квартиру с максимальной оценкой
                    12. Вывести коммерческое помещение с максимальной оценкой
                    13. Очистить список квартир
                    14. Очистить список коммерческих помещений
                    15. Вывести изначальный список квартир
                    16. Вывести изначальный список коммерчиеских помещений
                    0.  Выход
                    """);
            System.out.print("Введите нужный пункт меню: ");
            try {
                i = Integer.parseInt(Main.stringScanner());
                switch (i) {
                    case 1:
                        Apartment.addApartment();
                        break;
                    case 2:
                        Apartment.deleteApartment();
                        break;
                    case 3:
                        CommercialPremises.addPremises();
                        break;
                    case 4:
                        CommercialPremises.deletePremises();
                        break;
                    case 5:
                        apartmentMap.values().stream().sorted(Comparator.comparing(Apartment::getPrice)).forEach(System.out::println);
                        break;
                    case 6:
                        apartmentMap.values().stream().sorted(Comparator.comparing(Apartment::getPrice).reversed()).forEach(System.out::println);
                        break;
                    case 7:
                        commercialPremisesMap.values().stream().sorted(Comparator.comparing(CommercialPremises::getPrice)).forEach(System.out::println);
                        break;
                    case 8:
                        commercialPremisesMap.values().stream().sorted(Comparator.comparing(CommercialPremises::getPrice).reversed()).forEach(System.out::println);
                        break;
                    case 9:
                        apartmentMap.values().stream().collect(Collectors.groupingBy(Apartment::getMetro)).forEach((k, v) -> {
                            System.out.println(k);
                            v.forEach(n -> System.out.println("Наименование - " + n.getName() + ", Цена = " + n.getPrice() + ", Оценка = " + n.getGrade()));
                        });
                        break;
                    case 10:
                        commercialPremisesMap.values().stream().collect(Collectors.groupingBy(CommercialPremises::getMetro)).forEach((k, v) -> {
                            System.out.println(k);
                            v.forEach(n -> System.out.println("Наименование - " + n.getName() + ", Цена = " + n.getPrice() + ", Оценка = " + n.getGrade()));
                        });
                        break;
                    case 11:
                        apartmentMap.values().stream().max(Comparator.comparing(Apartment::getGrade)).ifPresent(System.out::println);
                        break;
                    case 12:
                        commercialPremisesMap.values().stream().max(Comparator.comparing(CommercialPremises::getGrade)).ifPresent(System.out::println);
                        break;
                    case 13:
                        if (apartmentMap.size()!=0) {
                            apartmentMap.clear();
                        }
                        else System.out.println("Список пуст");
                        break;
                    case 14:
                        if (commercialPremisesMap.size()!=0) {
                            commercialPremisesMap.clear();
                        }
                        else System.out.println("Список пуст");
                        break;
                    case 15:
                        if (apartmentMap.size()!=0) {
                            apartmentMap.values().forEach(System.out::println);
                        }
                        else System.out.println("Список пуст");
                        break;
                    case 16:
                        if (commercialPremisesMap.size()!=0) {
                            commercialPremisesMap.values().forEach(System.out::println);
                        }
                        else System.out.println("Список пуст");
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + i);
                }
            }
            catch (NumberFormatException ne){
                System.out.println("Error input." + ne.getMessage());
            }
        }
    }

    public static String stringScanner() {
        Scanner src = new Scanner(System.in);
        String line = src.nextLine();
        while (line.equals(null) || line.equals("\n")){
            System.out.println("Введена пустая строка");
            line = src.nextLine();
        }
        return line;
    }
}
