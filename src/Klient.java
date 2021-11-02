import java.util.Arrays;
import java.util.Scanner;

class Klient
{
    String imie;
    String nazwisko;
    String wypozyczony;
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
        }
        String[] proxyArray = new String[this.samochody.length - 1];
        k.wypozyczony=this.samochody[rm_index];
        this.samochodywyp[indexwyp]=this.samochody[rm_index];
        indexwyp++;
        int j = 0;
        for (int i = 0; i < this.samochody.length; i++) {
            if (i != rm_index) {
                proxyArray[j] = this.samochody[i];
                j++;
            }


        }
        this.samochody = proxyArray;
        System.out.println("Wypożyczyłeś:\n"+k.wypozyczony);


    }

    void zwroc(Klient k){
        String[] proxyArray = new String[this.samochody.length + 1];

        for (int i = 0; i < proxyArray.length; i++) {

            if (i != samochody.length) {
                proxyArray[i]=this.samochody[i];
            }else{
                proxyArray[i] = k.wypozyczony;
            }
        }
        indexwyp--;
        this.samochodywyp[indexwyp]=null;
        System.out.println("Zwróciłeś:\n"+k.wypozyczony);
        k.wypozyczony=null;
        this.samochody = proxyArray;

    }







    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Klient k1 = new Klient("Kamil", "Praula");


        String[] samochody = {"BMW seria 3 250km 220 zł/dzień", "Mercedes klasa C 220km 200 zł/dzień", "Opel Insygnia 150km 100 zł/dzień", "Ford FocusRS 350km 250 zł/dzień"};
        String[] samochodywyp = new String[10];
        Wypozyczalnia w1 = new Wypozyczalnia(samochody, samochodywyp);



        boolean dziala = true;
        while (dziala) {
            System.out.println("Co chcesz zrobić:\n 1-Wypożyczyć samochów\n 2-Zwrócić samochód\n 3-Sprawdzić co masz wypożyczone\n 4-Zakończyć działanie programu ");
            int opcja=scan.nextInt();
            if(opcja==1) {
                if(k1.wypozyczony!=null){
                    System.out.println("Można wypożyczyć tylko jeden samochód na raz.");
                    continue;
                }else {
                    System.out.println("Samochody dostępne do wypożyczenia:\n");
                    for (int i = 0; i < w1.samochody.length; i++) {
                        System.out.println(w1.samochody[i]);
                    }
                    if (w1.samochodywyp[0] != null) {
                        System.out.println("\nSamochody już wypożyczone :");
                        for (int i = 0; i < w1.samochodywyp.length; i++) {
                            if (w1.samochodywyp[i] != null)
                                System.out.println(w1.samochodywyp[i]);
                        }

                    }
                    System.out.println("\nWybierz który samochód (0,1,2,...)");
                    int wybors = scan.nextInt();
                    w1.wypozycz(k1, wybors);
                }
            }
            if(opcja==2){
                w1.zwroc(k1);
            }
            if(opcja==3){
                if(k1.wypozyczony!=null){
                    System.out.println("Masz wypożyczone:\n"+k1.wypozyczony);
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

