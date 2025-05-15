package Basebuilder;

public class Holzhutte {
    private int level;
    private int holzGespeichert;

    public Holzhutte(int level) {
        this.level = level;
    }

    public void produziereHolz() {
        holzGespeichert += 100 * level;
    }

    public int gebeHolz() {
        return holzGespeichert;
    }
    public void leereHutte() {
        holzGespeichert = 0;
    }
}


