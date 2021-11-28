import java.util.Arrays;
import java.util.Scanner;

class Klient
{
    String imie;
    String nazwisko;
    String[] wypozyczony=new String[0];
    public Klient(String imie,String nazwisko){
        this.imie=imie;
        this.nazwisko=nazwisko;
    }




}


class Wypozyczalnia {
    String[] samochody;
    String[] samochodywyp;
    int indexwyp=0;

    public Wypozyczalnia(String[] samochody, String[] samochodywyp) {
        this.samochody = samochody;
        this.samochodywyp = samochodywyp;
    }

    void wypozycz(Klient k, int a){


        int rm_index = a;

        if (this.samochody == null || rm_index < 0 || rm_index >= this.samochody.length) {
            System.out.println("Nie ma takiego samochodu");
            return;
        }

        String outwyp=this.samochody[rm_index];

        /*
        k.wypozyczony[indexwyp]=this.samochody[rm_index];
        this.samochodywyp[indexwyp]=this.samochody[rm_index];
        indexwyp++;

         */


        String[] proxyArray1 = new String[k.wypozyczony.length+1];
        for (int i = 0; i < proxyArray1.length; i++) {

            if (i != k.wypozyczony.length) {
                proxyArray1[i]=k.wypozyczony[i];
            }else{
                proxyArray1[i] = this.samochody[rm_index];
            }
        }
        k.wypozyczony=proxyArray1;

        String[] proxyArray2 = new String[this.samochodywyp.length+1];
        for (int i = 0; i < proxyArray2.length; i++) {

            if (i != this.samochodywyp.length) {
                proxyArray2[i]=this.samochodywyp[i];
            }else{
                proxyArray2[i] = this.samochody[rm_index];
            }
        }
        this.samochodywyp=proxyArray2;


        String[] proxyArray = new String[this.samochody.length - 1];
        int j = 0;
        for (int i = 0; i < this.samochody.length; i++) {
            if (i != rm_index) {
                proxyArray[j] = this.samochody[i];
                j++;
            }


        }
        this.samochody = proxyArray;
        System.out.println("Wypożyczyłeś:\n"+outwyp);


    }

    void zwroc(Klient k,int a){

        if(a>samochodywyp.length || a<0){
            System.out.println("\nNie ma takiego samochodu! ");
            return;
        }


        String[] proxyArray = new String[this.samochody.length + 1];

        for (int i = 0; i < proxyArray.length; i++) {

            if (i != samochody.length) {
                proxyArray[i]=this.samochody[i];
            }else{
                proxyArray[i] = k.wypozyczony[a];
            }
        }
        this.samochody = proxyArray;


        String[] proxyArray2 = new String[this.samochodywyp.length - 1];
        int g = 0;
        for (int i = 0; i < this.samochodywyp.length; i++) {
            if (this.samochodywyp[i] != k.wypozyczony[a]) {
                proxyArray2[g] = this.samochodywyp[i];
                g++;
            }


        }
        this.samochodywyp = proxyArray2;

        String[] proxyArray1=new String[k.wypozyczony.length-1];
        int j=0;
        for (int i = 0; i <k.wypozyczony.length ; i++) {
            if(i!=a){
                proxyArray1[j]=k.wypozyczony[i];
                j++;
            }
        }
        k.wypozyczony=proxyArray1;
        /*
        indexwyp--;
        this.samochodywyp[indexwyp]=null;
        System.out.println("Zwróciłeś:\n"+k.wypozyczony);
        k.wypozyczony=null;

         */




    }







    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Klient k1 = new Klient("Kamil", "Praula");


        String[] samochody = {"BMW seria 3 250km 220 zł/dzień", "Mercedes klasa C 220km 200 zł/dzień", "Opel Insygnia 150km 100 zł/dzień", "Ford FocusRS 350km 250 zł/dzień"};
        String[] samochodywyp = new String[0];
        Wypozyczalnia w1 = new Wypozyczalnia(samochody, samochodywyp);



        boolean dziala = true;
        while (dziala) {
            System.out.println("Co chcesz zrobić:\n 1-Wypożyczyć samochów\n 2-Zwrócić samochód\n 3-Sprawdzić co masz wypożyczone\n 4-Zakończyć działanie programu ");
            int opcja=scan.nextInt();
            if(opcja==1) {
/*
                if(k1.wypozyczony!=null){
                    System.out.println("Można wypożyczyć tylko jeden samochód na raz.");
                    continue;
                }else {
                */
                    System.out.println("Samochody dostępne do wypożyczenia:\n");
                    for (int i = 0; i < w1.samochody.length; i++) {
                        System.out.println(i+" "+w1.samochody[i]);
                    }
                    if (w1.samochodywyp.length != 0) {
                        System.out.println("\nSamochody już wypożyczone :");
                        for (int i = 0; i < w1.samochodywyp.length; i++) {
                            if (w1.samochodywyp[i] != null)
                                System.out.println(i+" "+w1.samochodywyp[i]);
                        }

                   }
                    System.out.println("\nWybierz który samochód (0,1,2,...) albo 360 jeśli chcesz anulować");
                    scan.nextLine();
                    int wybors = scan.nextInt();
                    if(wybors<360){
                        w1.wypozycz(k1, wybors);
                    }

              //  }
            }
            if(opcja==2){

                if(k1.wypozyczony.length!=0) {
                    System.out.println("Który samochód chcesz zwrócić?\n ");

                    for (int i = 0; i < k1.wypozyczony.length; i++) {
                        System.out.println(i+" "+k1.wypozyczony[i]);
                    }
                    System.out.println("\nWybierz który samochód (0,1,2,...) ");
                    scan.nextLine();
                    int wybors = scan.nextInt();
                    w1.zwroc(k1,wybors);
                }else{
                    System.out.println("\nNie masz wypożyczonych samochodów. ");
                }


            }
            if(opcja==3){
                if(k1.wypozyczony.length!=0){
                    System.out.println("Masz wypożyczone:\n");

                    for (int i = 0; i < k1.wypozyczony.length; i++) {
                        System.out.println(i+" "+k1.wypozyczony[i]);
                    }
                }else{
                    System.out.println("Nie masz wypożyczonego samochodów.");
                }
            }


            if(opcja==4){
                dziala = false;
            }


        }


    }
}

