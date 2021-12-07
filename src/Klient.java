import java.util.Scanner;
import java.util.stream.IntStream;

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

    Scanner scan = new Scanner(System.in);

    public Wypozyczalnia(String[] samochody, String[] samochodywyp) {
        this.ksiazki = samochody;
        this.ksiazkiwyp = samochodywyp;
    }
    Klient Logowanie(){

        System.out.println("Na które konto chcesz się zalogować(0,1...) :\n");
        int licznik=0;
        for (Klient a:this.klienci) {
            System.out.println(licznik+" "+a.login);
            licznik+=1;
        }
        int wybor=scan.nextInt();

        return klienci[wybor];

    }
    void Rejestracja(){
        while(true){
        System.out.println("Podaj login do nowego konta:\n!!!Jeśli po wpisaniu loginu i zatwierdzeniu enterem nie chce od ciebie hasła to wpisz login jeszcze raz\n");
        scan.nextLine();
        String nlogin= scan.nextLine();
        if(!(czyZawiera(nlogin))){
            System.out.println("Podaj hasło do nowego konta:\n");
            String nhaslo= scan.nextLine();
            Klient nk=new Klient(nlogin,nhaslo);

            Klient[] proxyArray = new Klient[this.klienci.length + 1];

            for (int i = 0; i < proxyArray.length; i++) {

                if (i != klienci.length) {
                    proxyArray[i]=this.klienci[i];
                }else{
                    proxyArray[i] = nk;
                }
            }
            this.klienci = proxyArray;
            break;

        }
        else{
            System.out.println("Login jest zajęty ");
        }

        }
    }
    boolean czyZawiera(String s){
        for (Klient a: this.klienci) {
            if(a.login.equals(s)){
                return true;
            }
        }
        return false;

    }

    void dodajksiazke(){
        System.out.println("Wpisz jaką książkę chcesz dodać: AUTOR-TYTUŁ");
        scan.nextLine();
        String ksiazka=scan.nextLine();
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
            System.out.println("Nie ma takiej książki");
            return;
        }

        String outwyp=this.ksiazki[rm_index];


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
            System.out.println("\nNie ma takiej książki! ");
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
        Klient k2=new Klient("Kacper","elo123");

        String[] książki = {"George R.R. Martina-Pieśń Lodu i Ognia", "Ernest Hemingway-Stary Człowiek i Morze", "Henryk Sienkiewicz-Ogniem i Mieczem", "Henryk Sienkiewicz-Potop","Henryk Sienkiewicz-Pan Wołodyjowski"};
        String[] ksiazkiwyp = new String[0];
        Wypozyczalnia w1 = new Wypozyczalnia(książki, ksiazkiwyp);
        w1.klienci[0]=k1;
        w1.klienci[1]=k2;



        while (true) {
            System.out.println("\nCo chcesz zrobić:\n 1-zalogować się\n 2-założyć konto\n 3-Dodać książkę do księgozbioru\n 4-Wyświetlić wszystkie książki\n 5-zakończyć działanie programu");
            int opcja1=scan.nextInt();
            if(opcja1==1) {

                k1=w1.Logowanie();
                System.out.println("Podaj hasło: ");
                scan.nextLine();
                String haslo= scan.nextLine();
                if(k1.haslo.equals(haslo)) {


                    while (true) {
                        System.out.println("Co chcesz zrobić:\n 1-Wypożyczyć książkę\n 2-Zwrócić książkę\n 3-Sprawdzić co masz wypożyczone\n 4-Dodać książkę do księgozbioru\n 5-Wylogować się ");
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
                         else if (opcja == 2) {

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
                         else if (opcja == 3) {
                            if (k1.wypozyczony.length != 0) {
                                System.out.println("Masz wypożyczone:\n");

                                for (int i = 0; i < k1.wypozyczony.length; i++) {
                                    System.out.println(i + " " + k1.wypozyczony[i]);
                                }
                            } else {
                                System.out.println("Nie masz wypożyczonych książek.");
                            }
                        }
                        else if(opcja==4){
                            w1.dodajksiazke();
                        }

                        else if (opcja == 5) {

                            break;

                        }
                        else{
                            System.out.println("Nie ma takiej opcji");
                        }


                    }
                }else{
                    System.out.println("Niepoprawne hasło !");
                    continue;
                }
            }
            else if(opcja1==2){
                w1.Rejestracja();

            }

            else if(opcja1==3){
                System.out.println("Najpierw Enter potem");
                w1.dodajksiazke();
            }

            else if(opcja1==4){
                System.out.println("Ksiażki do wypożyczenia:\n");
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

            }

            else if(opcja1==5){
                break;
            }
            else{
                System.out.println("Nie ma takiej opcji!");
            }
        }


    }
}

