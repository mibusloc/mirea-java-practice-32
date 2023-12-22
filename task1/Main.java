package ru.mirea.lab32.task1;

public class Main {

    private final static boolean LEFT_TO_RIGHT = true;
    private final static boolean RIGHT_TO_LEFT = false;

    public static int searchArr(int[] a, int n, int mobile) {
        for (int i = 0; i < n; i++)

            if (a[i] == mobile) return i + 1;

        return 0;
    }

    public static int getMobile(int[] a, boolean[] dir, int n) {
        int mobile_prev = 0, mobile = 0;

        for (int i = 0; i < n; i++) {
            if (dir[a[i] - 1] == RIGHT_TO_LEFT && i != 0) {
                if (a[i] > a[i - 1] && a[i] > mobile_prev) {
                    mobile = a[i];
                    mobile_prev = mobile;
                }
            }

            if (dir[a[i] - 1] == LEFT_TO_RIGHT && i != n - 1) {
                if (a[i] > a[i + 1] && a[i] > mobile_prev) {
                    mobile = a[i];
                    mobile_prev = mobile;
                }
            }
        }

        return mobile;
    }

    public static void printOnePerm(int[] a, boolean[] dir, int n) {
        int mobile = getMobile(a, dir, n);
        int pos = searchArr(a, n, mobile);

        if (dir[a[pos - 1] - 1] == RIGHT_TO_LEFT) {
            int temp = a[pos - 1];
            a[pos - 1] = a[pos - 2];
            a[pos - 2] = temp;
        } else if (dir[a[pos - 1] - 1] == LEFT_TO_RIGHT) {
            int temp = a[pos];
            a[pos] = a[pos - 1];
            a[pos - 1] = temp;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > mobile) {
                if (dir[a[i] - 1] == LEFT_TO_RIGHT) dir[a[i] - 1] = RIGHT_TO_LEFT;

                else if (dir[a[i] - 1] == RIGHT_TO_LEFT) dir[a[i] - 1] = LEFT_TO_RIGHT;
            }
        }

        for (int i = 0; i < n; i++)
            System.out.print(a[i]);

        System.out.print(" ");

    }

    public static int fact(int n) {
        int res = 1;

        for (int i = 1; i <= n; i++)
            res = res * i;
        return res;
    }

    public static void printPermutation(int n) {
        int[] a = new int[n];

        boolean[] dir = new boolean[n];

        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
            System.out.print(a[i]);
        }

        System.out.print("\n");

        for (int i = 1; i < fact(n); i++)
            printOnePerm(a, dir, n);
    }

    public static void main(String[] argc) {
        int n = 4;
        printPermutation(n);
    }
}
