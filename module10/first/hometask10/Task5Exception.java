package module10.first.hometask10;

/*Создайте три новых типа исключений.
* Напишите класс с методом, который будет кидать все три из них.
* В main() вызовите этот метод,
* но используйте только один catch-блок который будет ловить все три типа исключений.
*/
public class Task5Exception {

    public static void main(String[] args) {


//        String str=""; //-1 variant
//        String str="dghdghdghdghdgdhdghdghdgdhdgh"; //-2 variant
        String str="qwfjfj12"; //3-variant
        String strgood="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM ";
        try {

            if (str.isEmpty()) throw new MyExceptionStringEmpty("String empty  " );
            if (str.length()>10) throw new MyExceptionStringLongLenght("String long lenght - "+str.length());
            if (  !str.matches(strgood)) throw new MyExceptionStringNotValidCharacters("Not valid charters" + str);
        }
        catch (MyExceptionStringEmpty a1){
            a1.printStackTrace();
        }
        catch (MyExceptionStringLongLenght a2){
            a2.printStackTrace();
        } catch (MyExceptionStringNotValidCharacters a3) {
            a3.printStackTrace();
        }

    }

}
