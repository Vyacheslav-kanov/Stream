import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = Arrays.asList(
                new Person("Jack", "Evans", 16, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Young", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Harris", 42, Sex.WOMEN, Education.HIGHER),
                new Person("Harry", "Wilson", 69, Sex.MAN, Education.HIGHER),
                new Person("George", "Davies", 35, Sex.MAN, Education.FURTHER),
                new Person("Samuel", "Adamson", 40, Sex.MAN, Education.HIGHER),
                new Person("John", "Brown", 44, Sex.MAN, Education.HIGHER)
        );

        Stream<Person> streamCount = persons.stream();
        long a = streamCount
                .filter(x -> x.getAge() < 18)
                .count();
        System.out.println("Количество несоврешеннолетних: " + a);

        Stream<Person> streamSummon = persons.stream();
        List<String> listSummon = streamSummon
                .filter(x -> x.getAge() >= 18 && x.getAge() < 27)
                .filter(x -> x.getSex().equals(Sex.MAN))
                .map((x) -> x.getFamily() + " ")
                .collect(Collectors.toList());
        System.out.println("Список призывников: ");
        for (String e: listSummon) System.out.println(e);

        Stream<Person> streamFitPeople = persons.stream();
        List<Person> listFitPeople = streamFitPeople
                .filter(x -> x.getAge() >= 18 && x.getAge() < 60)
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(new ComparatorPersonFamily())
                .collect(Collectors.toList());
        System.out.println("Список работоспособных людей: ");
        for (Person e: listFitPeople) {
            System.out.println(e);
        }
    }
}
