package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

public class Main {

    public static void main(String[] args) {
        List<SquareParams> squareParams = new ArrayList<>();
        squareParams.add(new SquareParams(Main::condition1, 1));
        squareParams.add(new SquareParams(Main::condition2, 2));
        squareParams.add(new SquareParams(Main::condition3, 3));
        squareParams.add(new SquareParams(Main::condition4, 4));
        squareParams.add(new SquareParams(Main::condition6, 6));
        squareParams.add(new SquareParams(Main::condition7, 7));
        squareParams.add(new SquareParams(Main::condition8, 8));
        squareParams.add(new SquareParams(Main::condition9, 9));
        squareParams.add(new SquareParams(Main::condition10, 10));
        squareParams.add(new SquareParams(Main::condition11, 11));
        squareParams.add(new SquareParams(Main::condition19, 19));
        squareParams.add(new SquareParams(Main::condition21, 21));
        squareParams.add(new SquareParams(Main::condition22, 22));
        squareParams.add(new SquareParams(Main::condition23, 23));
        squareParams.add(new SquareParams(Main::condition24, 24));
        squareParams.add(new SquareParams(Main::condition25, 25));
        for (SquareParams params: squareParams) {
            square(params.predicate, params.number);
        }
        square(Main::condition5, 5, 0, 2);
        square(Main::condition20, 20, 0, 1);
        square18();

    }

    private static class SquareParams {
        BiPredicate<Integer, Integer> predicate;
        int number;

        public SquareParams(BiPredicate<Integer, Integer> predicate, int number) {
            this.predicate = predicate;
            this.number = number;
        }
    }

    private static void square(BiPredicate<Integer, Integer> test, int number) {
        try (FileWriter myWriter = new FileWriter( String.format("square%d.txt", number))) {
            for (int y = 0; y < 25; y++) {
                for (int x = 0; x < 25; x++) {
                    myWriter.write(test.test(x, y) ? "# " : ". ");
                }
                myWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void square(BiPredicate<Integer, Integer> test, int number, int initVal, int step) {
        try (FileWriter myWriter = new FileWriter( String.format("square%d.txt", number))) {
            int k = initVal;
            for (int y = 0; y < 25; y++) {
                for (int x = 0; x < 25; x++) {
                    myWriter.write(test.test(x, k) ? "# " : ". ");
                }
                k+=step;
                myWriter.write("\n");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void square18() {
        try (FileWriter myWriter = new FileWriter( String.format("square%d.txt", 18))) {
                for (int y = 0; y < 25; y++) {
                    for (int x = 0; x < 25; x++) {
                        if (x == 0 && y == 0) {
                            myWriter.write(". ");
                        } else {
                            myWriter.write(((x < 2 || y < 2)) ? "# " : ". ");
                        }
                    }
                    myWriter.write("\n");
                }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static boolean condition1(int x, int y) {
        return y < x;
    }

    private static boolean condition2(int x, int y) {
        return y == x;
    }

    private static boolean condition3(int x, int y) {
        return 24 - y == x;
    }

    private static boolean condition4(int x, int y) {
        return x < 30 - y;
    }

    private static boolean condition5(int x, int k) {
        return x == k || x == k + 1;
    }

    private static boolean condition6(int x, int y) {
        return x < 10 || y < 10;
    }

    private static boolean condition7(int x, int y) {
        return x > 15 && y > 15;
    }


    private static boolean condition8(int x, int y) {
        return x < 1 || y < 1;
    }

    private static boolean condition9(int x, int y) {
        return (y > x + 10) || (y < x - 10);
    }


    private static boolean condition10(int x, int y) {
        return (y < x) && (2 * y + 2 > x);
    }

    private static boolean condition11(int x, int y) {
        return x == 1 || y == 1 || x == 23 || y == 23;
    }

    private static boolean condition19(int x, int y) {
        return x == 0 || x == 24 || y == 0 || y == 24;
    }

    private static boolean condition20(int x, int k) {
        return (x + k) % 2 == 0;
    }

    private static boolean condition21(int x, int y) {
        for (int i = 0; i < 25; i++) {
            if (x == y * i + i)
                return true;
        }
        return false;
    }

    private static boolean condition22(int x, int y) {
        return (x + y) % 3 == 0;
    }

    private static boolean condition23(int x, int y) {
        return x % 2 == 0 & y % 3 == 0;
    }

    private static boolean condition24(int x, int y) {
        return x == y || x == 24 - y;
    }

    private static boolean condition25(int x, int y) {
        return x % 6 == 0 || y % 6 == 0;
    }
}
