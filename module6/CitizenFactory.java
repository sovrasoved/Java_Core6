package module6;


/**
 * Created by sovra on 26.03.2017.
 */
public  class CitizenFactory{

Citizen SayHelloCitizen(String sayhello){

    if (sayhello.equals("it")) return new Italian();
    else
        if (sayhello.equals("en")) return new Englishman();
    else
        if (sayhello.equals("ru")) return new Russian();
    else
        if (sayhello.equals("ch")) return new Chinese();
    else
        {
            System.out.println("Error  - string: "+sayhello);
            return null;
        }
//    switch (sayhello)
//    {
//        case "it":
//            return new Italian();
//        case "en":
//            return new Englishman();
//        case "ru":
//            return new Russian();
//        case "ch":
//            return new Chinese();
//            default:
//                System.out.println("Error  - string: "+sayhello);
//                return null;
//
//    }

}


}
