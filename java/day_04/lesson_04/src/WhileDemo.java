public class WhileDemo {
    public static void main(String[] args) {
        // Thực hiện cv thực dậy lúc 5:00 trong vòng 30 ngày

//        for (int day = 1; day <= 30; day = day + 1) {
//            System.out.println("Ngày " + day + " thức dậy lúc 5h");
//        }

//        int day = 1;
//        while (day <= 30) {
//            if(day % 2 == 0) {
//                System.out.println("Ngày " + day + " thức dậy lúc 5h");
//            } else {
//                System.out.println("Ngày " + day + " thức dậy lúc 7h");
//            }
//
//            day++;
//        }

        int day = 31;
        do {
            if (day % 2 == 0) {
                System.out.println("Ngày " + day + " thức dậy lúc 5h");
            } else {
                System.out.println("Ngày " + day + " thức dậy lúc 7h");
            }

            day++;
        } while (day <= 30);
    }
}
