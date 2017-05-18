package module6;


import module6.oldFactory.CitizenFactory;

/**
 * Created by sovra on 17.04.2017.
 */
public class CitizenMain {
    public static void main(String[] args) {
        Citizen cit_en = CitizenFactory.englishman();
        Citizen cit_ru = CitizenFactory.russian();
        Citizen cit_it = CitizenFactory.italian();
        Citizen cit_ch = CitizenFactory.chinese();


        cit_en.sayHello();
        cit_ru.sayHello();
        cit_it.sayHello();
        cit_ch.sayHello();


    }

}
