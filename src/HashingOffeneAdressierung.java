public class HashingOffeneAdressierung {

    public static void main(String[] args) {
        int[] array = {10, 22, 31, 4, 15, 28, 17, 88, 59};

        int[] a = linearHashing(array, 11);
        print(a);
        int[] t = doubleHashing(array, 11, 1);
        print(t);
        int[] v = squareHashing(array, 11, 1, 3);
        print(v);

    }

    public static int[] linearHashing(int[] a, int h) {

        boolean check = false;
        int[] t = new int[11];

        for(int i = 0; i < a.length; i++) {
            int pos = a[i] % h;

            do {
                if (pos > 10) {
                    check = true;
                }

                if (t[pos] == 0) {
                    t[pos] = a[i];
                    check = true;
                } else {
                    ++pos;
                }
            } while(!check);

            check = false;
        }

       return t;

    }

    public static int[] doubleHashing(int[] zahlen, int h, int h2) {

        boolean check = false;
        int[] T = new int[11];

        for(int i = 0; i < zahlen.length; ++i) {
            int pos = zahlen[i] % h;
            int rest = pos;
            int zahl = 1;

            do {
                if (pos > 10) {
                    check = true;
                }

                if (T[pos] == 0) {
                    T[pos] = zahlen[i];
                    check = true;
                } else {
                    pos = (rest + zahl * (zahlen[i] % h2)) % h;
                    ++zahl;
                }
            } while(!check);

            check = false;
        }

        return T;
    }

    public static int[] squareHashing(int[] zahlen, int h, int c1, int c2) {

        boolean check = false;
        int[] T = new int[11];

        for (int i = 0; i < zahlen.length; ++i) {
            int pos = zahlen[i] % h;
            int rest = pos;

            do {
                if (pos > 10) {
                    check = true;
                }

                if (T[pos] == 0) {
                    T[pos] = zahlen[i];
                    check = true;
                } else {
                    pos = (rest + c1 + c2 * c2) % h;
                    ++c2;
                }
            } while (!check);

            check = false;
        }

        return T;
    }

    public static void print(int[] T) {
        for(int i = 0; i < T.length; ++i) {
            System.out.println(i + ": " + T[i]);
        }

    }
}
