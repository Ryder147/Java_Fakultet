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
    Klient[] klienci=new Klient[2];
    int indexwyp=0;

    public Wypozyczalnia(String[] samochody, String[] samochodywyp) {
        this.ksiazki = samochody;
        this.ksiazkiwyp = samochodywyp;
    }
    Klient Logowanie(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Na które konto chcesz się zalogować(0,1... albo 60 jeśli chcesz anulować) :\n");
        int licznik=0;
        for (Klient a:this.klienci) {
            System.out.println(licznik+" "+a.login);
            licznik+=1;
        }
        int wybor=scan.nextInt();
        return klienci[wybor];

    }

    void dodajksiazke(String ksiazka){
        String[] proxyArray = new String[this.ksiazki.length + 1];

        for (int i = 0; i < proxyArray.length; i++) {

            if (i != ksiazki.length) {
                proxyArray[i]=this.ksiazki[i];
            }else{
                proxyArray[i] = ksiazka;
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

    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }







    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        Klient k1 = new Klient("Kamil", "elo123");
        Klient k2=new Klient("Kacper","luka");

        String[] książki = {"George R.R. Martina Pieśń Lodu i Ognia", "Ernest Hemingway Stary Człowiek i Morze", "Henryk Sienkiewicz Ogniem i Mieczem", "Henryk Sienkiewicz Potop","Henryk Sienkiewicz Pan Wołodyjowski"};
        String[] ksiazkiwyp = new String[0];
        Wypozyczalnia w1 = new Wypozyczalnia(książki, ksiazkiwyp);
        w1.klienci[0]=k1;
        w1.klienci[1]=k2;


        //boolean dziala = true;
        while (true) {
            System.out.println("Co chcesz zrobić:\n 1-zalogować się\n 2-założyć konto\n 3-zakończyć działanie programu");
            int opcja1=scan.nextInt();
            if(opcja1==1) {

                k1=w1.Logowanie();
                System.out.println("Podaj hasło: ");
                scan.nextLine();
                String haslo= scan.nextLine();
                if(k1.haslo.equals(haslo)) {


                    while (true) {
                        System.out.println("Co chcesz zrobić:\n 1-Wypożyczyć książkę\n 2-Zwrócić książkę\n 3-Sprawdzić co masz wypożyczone\n 4-Wylogować się ");
                        int opcja = scan.nextInt();
                        if (opcja == 1) {

                            System.out.println("ksiazki do wypożyczenia:\n");
                            for (int i = 0; i < w1.ksiazki.length; i++) {
                                System.out.println(i + " " + w1.ksiazki[i]);
                            }
                            if (w1.ksiazkiwyp.length != 0) {
                                System.out.println("\nKsiążki już wypożyczone :");
                                for (int i = 0; i < w1.ksiazkiwyp.length; i++) {
                                    if (w1.ksiazkiwyp[i] != null)
                                        System.out.println(i + " " + w1.ksiazkiwyp[i]);
                                }

                            }
                            System.out.println("\nWybierz książkę (0,1,2,...) albo x jeśli chcesz anulować");
                            scan.nextLine();
                            String wybors = scan.nextLine();
                            if (wybors.equals("x")) {
                                continue;


                            }else{
                                if(isInteger(wybors)){
                                    w1.wypozycz(k1, Integer.parseInt(wybors));
                                }
                                else{
                                    System.out.println("Nie ma takiej opcji.");
                                }
                            }
                        }
                        if (opcja == 2) {

                            if (k1.wypozyczony.length != 0) {
                                System.out.println("Którą książkę chcesz zwrócić?\n ");

                                for (int i = 0; i < k1.wypozyczony.length; i++) {
                                    System.out.println(i + " " + k1.wypozyczony[i]);
                                }
                                System.out.println("\nWybierz którą książkę (0,1,2,...) albo x jeśli chcesz anulować ");
                                scan.nextLine();
                                String wybors = scan.nextLine();
                                if (wybors.equals("x")) {
                                    continue;

                                }else{
                                    if(isInteger(wybors)){
                                        w1.zwroc(k1, Integer.parseInt(wybors));
                                    }
                                    else{
                                        System.out.println("Nie ma takiej opcji.");
                                    }
                                }
                            } else {
                                System.out.println("\nNie masz wypożyczonych książek. ");
                            }


                        }
                        if (opcja == 3) {
                            if (k1.wypozyczony.length != 0) {
                                System.out.println("Masz wypożyczone:\n");

                                for (int i = 0; i < k1.wypozyczony.length; i++) {
                                    System.out.println(i + " " + k1.wypozyczony[i]);
                                }
                            } else {
                                System.out.println("Nie masz wypożyczonych książek.");
                            }
                        }


                        if (opcja == 4) {

                            break;

                        }


                    }
                }else{
                    System.out.println("Niepoprawne hasło !");
                    continue;
                }
            }
            if(opcja1==3){
                break;
            }
        }


    }
}

