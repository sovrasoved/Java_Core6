package module6;


/**
 * Created by sovra on 26.03.2017.
 */
public  class CitizenFactory{

Citizen SayHelloCitizen(String sayhello){
    switch (sayhello)
    {
        case "it":
            return new Italian();
        case "en":
            return new Englishman();
        case "ru":
            return new Russian();
        case "ch":
            return new Chinese();
            default:
                System.out.println("Error  - string: "+sayhello);
                return null;

    }

}


}
