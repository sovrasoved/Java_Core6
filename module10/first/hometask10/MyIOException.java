package module10.first.hometask10;

//Создайте свой собственный класс исключений, используя ключевое слово extends.
//Напишите конструктор для этого класса, который получает аргумент типа String
//      и хранит его внутри объекта как ссылку (reference) на String.
//Написать метод, который выводит хранимую строку.
//Создать try-catch-блоки, чтобы поупражняться на новом исключении
public class MyIOException extends Exception {
  private String txt;

    public MyIOException(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }
}
