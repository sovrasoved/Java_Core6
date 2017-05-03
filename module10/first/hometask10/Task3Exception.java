package module10.first.hometask10;

// Определите ссылку (reference) на объект и инициализируйте ее как null.
// Попробуйте вызвать метод через эту ссылку.
// Потом оберните этот код в try-catch-блок, чтобы поймать исключение.
public class Task3Exception {

    public static void main(String[] args) {
        Object obref = null;

        try {
            System.out.println("try -  reference=null");
            System.out.println(obref.toString());
            System.out.println("try -  not out catch");
        }
        catch (NullPointerException a){
            System.out.println("catch - - reference=null:   NullPointerException");
            a.printStackTrace();
        }
        finally {
            System.out.println("finally - reference=null");
        }
    }

}

