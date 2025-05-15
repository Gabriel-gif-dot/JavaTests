package Basebuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int gems = 0;
        int gold = 10000;
        int holz = 1000;
        Scanner scan = new Scanner(System.in);
        Holzhutte[] holzhutten = new Holzhutte[100];
        Goldmine[] goldmine = new Goldmine[100];
        int holzhutenindex = 0;
        int goldminenindex = 0;

        while (true) {
            System.out.println("Gold: " + gold + " | Holz: " + holz + " | Gems: " + gems);
            if (gems >= 2000) {
                System.out.println("Du hast das Spiel durchgespielt! Gluckwunsch");
                break;
            } else {
                System.out.println("Mochten sie eine Holzhutte(1) oder eine Goldmine(2) kaufen? Edelsteine erwerben?(3) oder das Programm beenden(4)");
                int input = scan.nextInt();

                if(input == 1) {
                    if (holzhutenindex < 100) {
                        System.out.println("Eine Holzhutte kostet sie pro Level 500 Holz und 2000 Gold");
                        System.out.println("Bitte geben sie das gewunschte level ein");
                        int level = scan.nextInt();

                        if (level > 0 && level < 10) {
                            Holzhutte holzhutte = new Holzhutte(level);
                            holzhutten[holzhutenindex] = holzhutte;
                            holzhutenindex++;
                            holz -= 500 * level;
                            gold -= 2000 * level;
                        }
                    } else {
                        System.out.println("Maximale Anzahl an Hutten ereicht");
                    }
                }if(input == 2) {
                    if (goldminenindex < 100) {
                        System.out.println("Eine Goldmine kostet sie pro Level 600 Holz und 800 Gold");
                        System.out.println("Bitte geben sie das gewunschte level ein");
                        int level = scan.nextInt();

                        if (level > 0 && level < 10) {
                            goldmine[goldminenindex] = new Goldmine(level);
                            goldminenindex++;
                            holz -= 600;
                            gold -= 800;

                        }
                    } else {
                        System.out.println("Maximale Anzahl an Minen erreicht");
                    }

                }
                if (input == 3) {
                    System.out.println("Ein Juwel kostet 100 Gold und 10 Holz");
                    System.out.println("Wie viele Edelsteine mochten sie kaufen");
                    int anzahl = scan.nextByte();
                    if (anzahl * 100 <= gold && anzahl * 10 <= holz) {
                        gems += anzahl;
                        holz -= anzahl * 10;
                        gold -= anzahl * 100;
                    }
                }
                if (input == 4) {
                    break;

                }
                gold += erhalteGoldVonMinen(goldmine, goldminenindex);
                holz += erhalteHolzVonHutten(holzhutten, holzhutenindex);
            }
        }
    }

    public static int erhalteGoldVonMinen(Goldmine[] goldminen, int goldMinenindex) {
        int goldSumme = 0;

        for(int i = 0; i < goldMinenindex; i++) {
            Goldmine goldmine = goldminen[i];
            goldmine.produziereGold();
            goldSumme += goldmine.gebeGold();
            goldmine.leereMine();
        }
        return goldSumme;
    }

    public static int erhalteHolzVonHutten(Holzhutte[] holzhutten, int holzHuttenindex) {
        int holzSumme = 0;

        for (int i = 0; i < holzHuttenindex; i++) {
            Holzhutte holzhutte = holzhutten[i];
            holzhutte.produziereHolz();
            holzSumme += holzhutte.gebeHolz();
            holzhutte.leereHutte();
        }
        return holzSumme;
    }

}
