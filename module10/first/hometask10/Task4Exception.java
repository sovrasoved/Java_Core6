package module10.first.hometask10;

//        Создайте класс с двумя методами f() и g().
//         
//        В g() киньте (throw) исключение нового типа,  который вы определили.
//        В f() вызовите g(), поймайте его исключение и в блоке catch киньте
//        другое исключение (другого типа, который вы определили).
//        Протестируйте свой код в main().
/**
 * Created by sovra on 03.05.2017.
 */
public class Task4Exception {
    public static void f() throws MyIOException{
        System.out.println("call f()");
        try {
            g();
            throw new MyIOException("call g()");
        }
        catch (MyIOException a){
            a.printStackTrace();
            try {
                throw new MyIOException("call Exception f", "new call");
            }
            catch (MyIOException e){
                e.printStackTrace();
            }
        }

    }
    public static void g() throws MyIOException{
        System.out.println("call g()");
        throw new MyIOException("Exception call g()");
    }

    public static void main(String[] args) throws MyIOException {
    //    g();
        f();
    }
}
