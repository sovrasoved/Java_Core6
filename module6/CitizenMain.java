package module6;

/**
 * Created by sovra on 26.03.2017.
 */
public class CitizenMain {
    public static void main(String[] args) {

        Citizen cit;
        CitizenFactory citf = new CitizenFactory();



        cit =  citf.SayHelloCitizen("en");
          cit.sayHello();
        cit =  citf.SayHelloCitizen("ru");
        cit.sayHello();
        cit =  citf.SayHelloCitizen("it");
        cit.sayHello();
        cit =  citf.SayHelloCitizen("ch");
        cit.sayHello();
        cit =  citf.SayHelloCitizen("er");
        if (cit != null)         cit.sayHello();
        //cit.sayHello();
    }
}
