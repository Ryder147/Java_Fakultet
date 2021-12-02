import java.util.Scanner;

class Klient
{
    String login;
    String haslo;
    String[] wypozyczony=new String[0];
    public Klient(String login, String haslo){
        this.login = login;
        this.haslo =haslo;
    }




}


class Wypozyczalnia {
    String[] ksiazki;
    String[] ksiazkiwyp;
    Klient[] klienci=new Klient[0];
    int indexwyp=0;

    public Wypozyczalnia(String[] samochody, String[] samochodywyp) {
        this.ksiazki = samochody;
        this.ksiazkiwyp = samochodywyp;
    }

    void dodajksiazke(String samochod){
        String[] proxyArray = new String[this.ksiazki.length + 1];

        for (int i = 0; i < proxyArray.length; i++) {

            if (i != ksiazki.length) {
                proxyArray[i]=this.ksiazki[i];
            }else{
                proxyArray[i] = samochod;
            }
        }
        this.ksiazki = proxyArray;

    }

    void wypozycz(Klient k, int a){


        int rm_index = a;

        if (this.ksiazki == null || rm_index < 0 || rm_index >= this.ksiazki.length) {
            System.out.println("Nie ma takiego samochodu");
            return;
        }

        String outwyp=this.ksiazki[rm_index];

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
                proxyArray1[i] = this.ksiazki[rm_index];
            }
        }
        k.wypozyczony=proxyArray1;

        String[] proxyArray2 = new String[this.ksiazkiwyp.length+1];
        for (int i = 0; i < proxyArray2.length; i++) {

            if (i != this.ksiazkiwyp.length) {
                proxyArray2[i]=this.ksiazkiwyp[i];
            }else{
                proxyArray2[i] = this.ksiazki[rm_index];
            }
        }
        this.ksiazkiwyp =proxyArray2;


        String[] proxyArray = new String[this.ksiazki.length - 1];
        int j = 0;
        for (int i = 0; i < this.ksiazki.length; i++) {
            if (i != rm_index) {
                proxyArray[j] = this.ksiazki[i];
                j++;
            }


        }
        this.ksiazki = proxyArray;
        System.out.println("Wypożyczyłeś:\n"+outwyp);


    }

    void zwroc(Klient k,int a){

        if(a> ksiazkiwyp.length || a<0){
            System.out.println("\nNie ma takiego samochodu! ");
            return;
        }


        String[] proxyArray = new String[this.ksiazki.length + 1];

        for (int i = 0; i < proxyArray.length; i++) {

            if (i != ksiazki.length) {
                proxyArray[i]=this.ksiazki[i];
            }else{
                proxyArray[i] = k.wypozyczony[a];
            }
        }
        this.ksiazki = proxyArray;


        String[] proxyArray2 = new String[this.ksiazkiwyp.length - 1];
        int g = 0;
        for (int i = 0; i < this.ksiazkiwyp.length; i++) {
            if (this.ksiazkiwyp[i] != k.wypozyczony[a]) {
                proxyArray2[g] = this.ksiazkiwyp[i];
                g++;
            }


        }
        this.ksiazkiwyp = proxyArray2;

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

        Klient k1 = new Klient("Kamil", "elo123");


        String[] samochody = {"Henryk Sienkiewicz Ogniem i Mieczem ", "Ernest Hemingway Stary Człowiek i Morze", "Henryk Sienkiewicz Ogniem i mieczem", "Henryk Sienkiewicz Potop","Henryk Sienkiewicz Pan Wołodyjowski"};
        String[] samochodywyp = new String[0];
        Wypozyczalnia w1 = new Wypozyczalnia(samochody, samochodywyp);



        boolean dziala = true;
        while (dziala) {
            System.out.println("Co chcesz zrobić:\n 1-Wypożyczyć książkę\n 2-Zwrócić książkę\n 3-Sprawdzić co masz wypożyczone\n 4-Zakończyć działanie programu ");
            int opcja=scan.nextInt();
            if(opcja==1) {

                    System.out.println("ksiazki do wypożyczenia:\n");
                    for (int i = 0; i < w1.ksiazki.length; i++) {
                        System.out.println(i+" "+w1.ksiazki[i]);
                    }
                    if (w1.ksiazkiwyp.length != 0) {
                        System.out.println("\nKsiążki już wypożyczone :");
                        for (int i = 0; i < w1.ksiazkiwyp.length; i++) {
                            if (w1.ksiazkiwyp[i] != null)
                                System.out.println(i+" "+w1.ksiazkiwyp[i]);
                        }

                   }
                    System.out.println("\nWybierz który samochód (0,1,2,...) albo 60 jeśli chcesz anulować");
                    scan.nextLine();
                    int wybors = scan.nextInt();
                    if(wybors<60){
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
                    System.out.println("\nWybierz który samochód (0,1,2,...) albo 60 jeśli chcesz anulować ");
                    scan.nextLine();
                    int wybors = scan.nextInt();
                    if(wybors<60){
                        w1.zwroc(k1,wybors);
                    }
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

