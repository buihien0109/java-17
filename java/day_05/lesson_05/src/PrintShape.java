public class PrintShape {
    public static void main(String[] args) {
        printRectangle(3, 4);
        System.out.println();
        printRectangle(7, 5);

        System.out.println();
        printEmtpyRectangle(6, 8);
        System.out.println();
        printEmtpyRectangle(10, 5);

        System.out.println();
        printX(5);
        System.out.println();
        printX(6);

        System.out.println();
        printTriangle(3);
    }

    // In hình chữ nhật đặc
    public static void printRectangle(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // In hình chữ nhật rỗng
    public static void printEmtpyRectangle(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    // In dấu X
    public static void printX(int side) {
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                if (i == j || i + j == side - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void printTriangle (int side2){
        for (int i = 0; i < side2; i++) {
            for (int j = 0; j < side2; j++) {
                if (j > i ) {
                    System.out.print("  ");
                } else if (i == j || j == 0 || i == side2 - 1 || i > j) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
