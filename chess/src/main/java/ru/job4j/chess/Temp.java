package ru.job4j.chess;

public class Temp {
    private final TempInterface[] tempInterfaces = new TempInterface[10];
    private final int[] figures = {1, 2, 3, 4, 5, 6};
    private final int[] steps = {2, 4, 5, 6};

    private boolean free() {
        for (int f : this.figures) {
            for (int s : this.steps) {
                if (f == s) {
                    System.out.println(f);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Temp temp = new Temp();
        System.out.println(temp.free());
    }
}
