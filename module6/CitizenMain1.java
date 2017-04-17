package module6;

/**
 * Created by sovra on 17.04.2017.
 */
public class CitizenMain1 {
    public static void main(String[] args) {
        Citizen cit_en = CitizenFactory1.englishman();
        Citizen cit_ru = CitizenFactory1.russian();
        Citizen cit_it = CitizenFactory1.italian();
        Citizen cit_ch = CitizenFactory1.chinese();


        cit_en.sayHello();
        cit_ru.sayHello();
        cit_it.sayHello();
        cit_ch.sayHello();


    }

}
