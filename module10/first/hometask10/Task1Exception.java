package module10.first.hometask10;

import java.io.IOException;

//Создайте класс с main(), который закидывает (throws) объект класса Exception внутрь try-блока.
//Задайте конструктору исключения (Exception) аргумент типа String.
//Поймайте (catch) исключение внутри catch-блока и выведитe String argument.
//Добавьте finally-блок и выведите сообщение в доказательство того, что он вызывался +++
public class Task1Exception {
    public static void main(String[] args) {
        try {
            System.out.println("try");
            if (true)  throw new IOException("Error input data");

        } catch (IOException e) {
            System.out.println("block catch...");
        } finally {
            System.out.println("block finally ....");
        }
    }
}
