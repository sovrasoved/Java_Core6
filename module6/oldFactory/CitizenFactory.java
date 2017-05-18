package module6.oldFactory;

import module6.Citizen;

/**
 * Created by sovra on 17.04.2017.
 */
public class CitizenFactory {
    private static class Englishman implements Citizen {
        public Englishman() {
        }

        @Override
        public void sayHello() {
            System.out.println("English: Hello");
        }
    }
    private static class Russian implements Citizen{
        public Russian() {
        }

        @Override
        public void sayHello() {
            System.out.println("Russian: Здравствуйте");
        }
    }
    private static class Italian implements Citizen{
        public Italian() {
        }

        @Override
        public void sayHello() {
            System.out.println("Italian: Вuon giorno");
        }
    }
    private static class Chinese implements Citizen{
        public Chinese() {
        }

        @Override
        public void sayHello() {
            System.out.println("Chinese: 你好");
        }
    }

    public static Citizen englishman(){
        return new Englishman();
    }
    public static Citizen russian(){
        return new Russian();
    }
    public static Citizen chinese(){
        return new Chinese();
    }
    public static Citizen italian(){
        return new Italian();
    }

}