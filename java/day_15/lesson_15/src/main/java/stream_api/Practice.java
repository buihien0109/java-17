package stream_api;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(10, 5, 3, 12, 6, 7, 5, 3);

//        1. Duyệt numbers
//        numbers.stream().forEach(n -> System.out.println(n));

//        2. Tìm các giá trị chẵn trong list
//        List<Integer> rs = numbers.stream().filter(n -> n % 2 == 0).toList();
//        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
//
//        3. Tìm các giá trị > 5 trong list
//        numbers.stream().filter(n -> n > 5).forEach(System.out::println);
//
//        4. Tìm giá trị max trong list
//        List<Integer> listSortAsc = numbers.stream().sorted().toList();
//        Integer max = listSortAsc.get(listSortAsc.size() - 1);
//        System.out.println(max);

//        Optional<Integer> optionalMax = numbers.stream().max((a, b) -> a - b);
//        optionalMax.ifPresent(System.out::println);
//
//        5. Tìm giá trị min trong list
//
//        6. Tính tổng các phần tử của mảng
//        int total = numbers.stream().mapToInt(n -> n).sum();
//        System.out.println("Total : " + total);
//
//        int rs1 = 0;
//        for (int i = 0; i < 10; i++) {
//            rs1 += i;
//        }
//        System.out.println(rs1);
//
//        int total1 = numbers.stream().reduce(0, (a, b) -> a + b);
//        System.out.println("Total1 : " + total1);
//
//        7. Lấy danh sách các phần tử không trùng nhau
//        numbers.stream().distinct().forEach(System.out::println);
//
//        8. Lấy 5 phần tử đầu tiên trong mảng
//        numbers.stream().limit(5).forEach(System.out::println);
//
//        9. Lấy phần tử từ thứ 3 -> thứ 5
//        numbers.stream().skip(2).limit(3).forEach(System.out::println);
//
//        10. Lấy phần tử đầu tiên > 5
//        numbers.stream().filter(n -> n > 5).findFirst().ifPresent(System.out::println);
//        List<Integer> list = numbers.stream().filter(n -> n > 5).limit(1).toList();
//        if(list.size() > 0) {
//            System.out.println(list.get(0));
//        }
//
//        11. Kiểm tra xem list có phải là list chẵn hay không
//        System.out.println(numbers.stream().allMatch(n -> n % 2 == 0));
//
//        12. Kiểm tra xem list có phần tử > 10 hay không
//        System.out.println(numbers.stream().anyMatch(n -> n > 10));
//
//        13. Có bao nhiêu phần tử > 5
//        System.out.println(numbers.stream().filter(n -> n > 5).count());
//
//        14. Nhân đôi các phần tủ trong list và trả về list mới
//        List<Integer> listx2 = numbers
//                .stream()
//                .map(n -> n * 2)
//                .toList();
//        System.out.println(listx2);
//
//        15. Kiểm tra xem list không chứa giá trị nào = 8 hay không
//        System.out.println(numbers.stream().noneMatch(n -> n == 8));

        System.out.println(readMoney("29500011"));

        System.out.println(formatMoney(29_500_011_000_001L));
    }

    public static String formatMoney (Long price) {
        DecimalFormat formatter = new DecimalFormat("###,###,### VND");
        return formatter.format(price);
    }

    private static String readGroup(String group){
        String[] readDigit = {" Không", " Một", " Hai", " Ba", " Bốn", " Năm", " Sáu", " Bảy", " Tám", " Chín" };
        String temp = "";
        if (group == "000") return "";
        //read number hundreds
        temp = readDigit[Integer.parseInt(group.substring(0,1))] + " Trăm";
        //read number tens
        if (group.substring(1,2).equals("0"))
            if (group.substring(2,3).equals("0")) return temp;
            else
            {
                temp += " Lẻ" + readDigit[Integer.parseInt(group.substring(2,3))];
                return temp;
            }
        else
            temp += readDigit[Integer.parseInt(group.substring(1,2))] + " Mươi";
        //read number

        if (group.substring(2,3) == "5") temp += " Lăm";
        else if (group.substring(2,3) != "0") temp += readDigit[Integer.parseInt(group.substring(2,3))];
        return temp;
    }

    public static String readMoney(String num){
        if((num==null)||(num.equals(""))) return "";
        String temp = "";

        //length <= 18
        while (num.length() < 18)
        {
            num = "0" + num;
        }

        String g1 = num.substring(0, 3);
        String g2 = num.substring(3, 6);
        String g3 = num.substring(6, 9);
        String g4 = num.substring(9, 12);
        String g5 = num.substring(12,15);
        String g6 = num.substring(15,18);

        //read group1 ---------------------
        if (!g1.equals("000")){
            temp = readGroup(g1);
            temp += " Triệu";
        }
        //read group2-----------------------
        if (!g2.equals("000")){
            temp += readGroup(g2);
            temp += " Nghìn";
        }
        //read group3 ---------------------
        if (!g3.equals("000")){
            temp += readGroup(g3);
            temp += " Tỷ";
        } else if(!"".equals(temp)){
            temp += " Tỷ";
        }

        //read group2-----------------------
        if (!g4.equals("000")){
            temp += readGroup(g4);
            temp += " Triệu";
        }
        //---------------------------------
        if (!g5.equals("000")){
            temp += readGroup(g5);
            temp += " Nghìn";
        }
        //-----------------------------------

        temp = temp + readGroup(g6);
        //---------------------------------
        // Refine
        temp = temp.replaceAll("Một Mươi", "Mười");
        temp = temp.trim();
        temp = temp.replaceAll("Không Trăm", "");
//        if (temp.indexOf("Không Trăm") == 0) temp = temp.substring(10);
        temp = temp.trim();
        temp = temp.replaceAll("Mười Không", "Mười");
        temp = temp.trim();
        temp = temp.replaceAll("Mươi Không", "Mươi");
        temp = temp.trim();
        if (temp.indexOf("Lẻ")==0) temp = temp.substring(2);
        temp = temp.trim();
        temp = temp.replaceAll("Mươi Một", "Mươi Mốt");
        temp = temp.trim();

        //Change Case
        return "("+temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase() + " đồng chẵn./.)";
    }
}
