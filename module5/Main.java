package module5;


public class Main {

    public static void output(Room[] rooms) {
        if (rooms == null) return;
        for (Room roomtmp : rooms) {
            System.out.println(roomtmp);
        }
    }

    public static void main(String[] args) {


        Controller contr = new Controller();


        output(contr.requstRooms(100, 1, "Kharkov", "Book"));
        output(contr.requstRooms(300, 1, "Kiev", "Peace"));
        output(contr.requstRooms(350, 3, "Kiev", "Peace"));

//        System.out.println(contr.requstRooms(100,1,"Kharkov","Book"));
//            System.out.println(contr.requstRooms(300,1,"Kiev","Peace"));
//            System.out.println(contr.requstRooms(350,3,"Kiev","Peace"));

        API ap1 = new GoogleAPI();
        API ap2 = new BookingComAPI();
        API ap3 = new TripAdvisorAPI();
        output(contr.check(ap1, ap2));
        output(contr.check(ap1, ap3));
        output(contr.check(ap2, ap3));


        output(ap1.findRooms(100, 1, "Kharkov", "Book"));
        output(ap1.findRooms(200, 2, "Kharkov", "Book"));
        output(ap3.findRooms(400, 3, "Kiev", "TripAdvisor"));


    }


}
