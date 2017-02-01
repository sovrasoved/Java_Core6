package home3101;

/**
 * Created by sovra on 31.01.2017.
 */
public class draw1 {
    private static void draw_1(){
        boolean boolWhat;
        for (int i = 0; i < 3; i++) {
            if (i==0 || i==2) boolWhat=true;
            else boolWhat = false;
            for (int j = 0; j < 4; j++) {
                if (boolWhat){
                    if (j==0 || j==3)
                        System.out.print('+');
                    else
                        System.out.print('-');
                }
                else {
                    if (j==0 || j==3) System.out.print('|');
                    else if (j==1) System.out.print('<');
                    else System.out.print('>');
                }
            }
            System.out.println("");

        }
    }

    private static void draw_2(){

        char  chrSym;

        for (int i = 0; i < 5; i++) {


            for (int j = 0; j < 6; j++) {
                chrSym='a';
                switch (j){
                    case 0:
                    case 5:
                        if (i == 0 || i == 4) chrSym = '+';
                        else chrSym = '|';
                        break;
                    case 1:
                        if (i == 0 || i == 4) chrSym='-';
                        else if (i==1 || i==3) chrSym=' ';
                        else chrSym='<';
                        break;
                    case 2:
                        if (i == 0 || i==2 || i == 4) chrSym='-';
                        else if (i==1) chrSym='/';
                        else chrSym='\\';
                        break;
                    case 3:
                        if (i == 0 || i==2 || i == 4) chrSym='-';
                        else if (i==1) chrSym='\\';
                        else chrSym='/';
                        break;
                    case 4:
                        if (i == 0 || i == 4) chrSym='-';
                        else if (i==1 || i==3) chrSym=' ';
                        else chrSym='>';
                        break;
                }
                System.out.print(chrSym);
            }
            System.out.println("");
        }

    }

    private static void draw_4(){
        char  chrSym;
        for (int i = 0; i < 9; i++) {


            for (int j = 0; j < 10; j++) {
                chrSym='a';
                switch (j){
                    case 0:
                    case 9:
                        if (i == 0 || i == 8) chrSym = '+';
                        else chrSym = '|';
                        break;
                    case 1:
                        if (i == 0 || i == 8) chrSym='-';
                        else if (i== 4) chrSym='<';
                        else chrSym=' ';
                        break;

                    case 2:
                        if (i == 0 || i==8) chrSym='-';
                        else if (i==1 || i==2 || i==6 || i==7) chrSym=' ';
                        else if (i==4) chrSym='-';
                        else if(i==3) chrSym='/';
                        else chrSym='\\';
                        break;
                    case 3:
                        if (i == 0 || i==8) chrSym='-';
                        else if (i == 1 || i==7) chrSym=' ';
                        else if (i==2) chrSym='/';
                        else if (i==3 || i==5) chrSym='=';
                        else if (i==4) chrSym='-';
                        else chrSym='\\';
                        break;
                    case 4:
                        if (i == 0 || i == 8) chrSym='-';
                        else if (i==1 ) chrSym='/';
                        else if (i==2 || i==4 || i==6) chrSym='-';
                        else if (i==3 || i==5) chrSym='=';
                        else chrSym='\\';
                        break;
                    case 5:
                        if (i == 0 || i == 8) chrSym='-';
                        else if (i==1 ) chrSym='\\';
                        else if (i==2 || i==4 || i==6) chrSym='-';
                        else if (i==3 || i==5) chrSym='=';
                        else chrSym='/';
                        break;
                    case 6:
                        if (i == 0 || i==8) chrSym='-';
                        else if (i == 1 || i==7) chrSym=' ';
                        else if (i==2) chrSym='\\';
                        else if (i==3 || i==5) chrSym='=';
                        else if (i==4) chrSym='-';
                        else chrSym='/';
                        break;
                    case 7:
                        if (i == 0 || i==8) chrSym='-';
                        else if (i==1 || i==2 || i==6 || i==7) chrSym=' ';
                        else if (i==4) chrSym='-';
                        else if(i==3) chrSym='\\';
                        else chrSym='/';
                        break;
                    case 8:
                        if (i == 0 || i == 8) chrSym='-';
                        else if (i== 4) chrSym='>';
                        else chrSym=' ';
                        break;

                }
                System.out.print(chrSym);
            }
            System.out.println("");
        }

    }

    private static void draw_7(){
        char  chrSym;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 16; j++) {
                chrSym='a';
                switch (j){
                    case 0:
                    case 15:
                        if (i == 0 || i == 14) chrSym = '+';
                        else chrSym = '|';
                        break;
                    case 1:
                        if (i == 0 || i == 14) chrSym='-';
                        else if (i== 7) chrSym='<';
                        else chrSym=' ';
                        break;
                    case 14:
                        if (i == 0 || i == 14) chrSym='-';
                        else if (i== 7) chrSym='>';
                        else chrSym=' ';
                        break;
                    case 2:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=5 || i>=9) chrSym=' ';
                        else if (i==6) chrSym='/';
                        else if (i==7) chrSym='=';
                        else chrSym='\\';
                        break;
                    case 13:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=5 || i>=9) chrSym=' ';
                        else if (i==6) chrSym='\\';
                        else if (i==7) chrSym='=';
                        else chrSym='/';
                        break;
                    case 3:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=4 || i>=10) chrSym=' ';
                        else if (i==5) chrSym='/';
                        else if (i==6 || i==8) chrSym='-';
                        else if (i==7) chrSym='=';
                        else chrSym='\\';
                        break;
                    case 12:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=4 || i>=10) chrSym=' ';
                        else if (i==5) chrSym='\\';
                        else if (i==6 || i==8) chrSym='-';
                        else if (i==7) chrSym='=';
                        else chrSym='/';
                        break;
                    case 4:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=3 || i>=11) chrSym=' ';
                        else if (i==4) chrSym='/';
                        else if (i==5 || i==7 || i==9) chrSym='=';
                        else if (i==6 || i==8) chrSym='-';
                        else chrSym='\\';
                        break;
                    case 11:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=3 || i>=11) chrSym=' ';
                        else if (i==4) chrSym='\\';
                        else if (i==5 || i==7 || i==9) chrSym='=';
                        else if (i==6 || i==8 ) chrSym='-';
                        else chrSym='/';
                        break;
                    case 5:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=2 || i>=12) chrSym=' ';
                        else if (i==3) chrSym='/';
                        else if (i==4 || i==6 || i==8 || i==10) chrSym='-';
                        else if (i==5 || i==7 || i==9) chrSym='=';
                        else chrSym='\\';
                        break;
                    case 10:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i <=2 || i>=12) chrSym=' ';
                        else if (i==3) chrSym='\\';
                        else if (i==4 || i==6 || i==8 || i==10) chrSym='-';
                        else if (i==5 || i==7 || i==9) chrSym='=';
                        else chrSym='/';
                        break;
                    case 6:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i==1 || i==13) chrSym=' ';
                        else if (i==2) chrSym='/';
                        else if (i==3 || i==5 || i==7 || i==9 || i==11) chrSym='=';
                        else if (i==4 || i==6 || i==8 || i==10) chrSym='-';
                        else chrSym='\\';
                        break;
                    case 9:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i==1 || i==13) chrSym=' ';
                        else if (i==2) chrSym='\\';
                        else if (i==3 || i==5 || i==7 || i==9 || i==11) chrSym='=';
                        else if (i==4 || i==6 || i==8 || i==10) chrSym='-';
                        else chrSym='/';
                        break;
                    case 7:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i==1) chrSym='/';
                        else if (i==2 || i==4 || i==6 || i==8 || i==10 || i==12) chrSym='-';
                        else if (i==3 || i==5 || i==7 || i==9 || i==11) chrSym='=';
                        else chrSym='\\';
                        break;
                    case 8:
                        if (i == 0 || i== 14) chrSym='-';
                        else if (i==1) chrSym='\\';
                        else if (i==2 || i==4 || i==6 || i==8 || i==10 || i==12) chrSym='-';
                        else if (i==3 || i==5 || i==7 || i==9 || i==11) chrSym='=';
                        else chrSym='/';
                        break;


                }
                System.out.print(chrSym);
            }
            System.out.println("");
        }

    }

    public static void main(String[] args) {


        //size1
        draw_1();
        //size2
        draw_2();
        //size4
        draw_4();
        //size7
        draw_7();


    }

}

