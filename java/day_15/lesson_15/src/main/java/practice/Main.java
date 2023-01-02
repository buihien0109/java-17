package practice;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Iphone 14 Pro Max", 35_000_000, "Apple", 2));
        products.add(new Product(2, "OPPO Find X3 Pro", 9_000_000, "Oppo", 1));
        products.add(new Product(3, "Xiaomi mi 13", 15_000_000, "Xiaomi", 3));
        products.add(new Product(4, "Iphone 13", 21_000_000, "Apple", 2));
        products.add(new Product(5, "Samsung Z Fold 4", 42_000_000, "Samsung", 4));

        // 1.
        printInfo(products);

        // 2.
        System.out.println(formatMoney(getTotalProduct(products)));

        // 3.
        printInfo(findByBrand(products, "Apple"));
    }

    public static String formatMoney (long price) {
        DecimalFormat formatter = new DecimalFormat("###,###,### VND");
        return formatter.format(price);
    }

//    In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
//    ID - Tên - Giá - Thương Hiệu - Số lượng
//    Ví dụ : 1- OPPO Find X3 Pro - 19500000 - OPPO - 3
    public static void printInfo(List<Product> products) {
        products.forEach(product -> System.out.println(product.getId() + " - "
                + product.getName() + " - " + (formatMoney(product.getPrice())) + " - "
                + product.getBrand() + " - " + product.getCount()));
    }

//
//    Tính tổng tiền tất cả sản phẩm trong giỏ hàng
//    Tổng tiền mỗi sản phẩm = price * count
    public static int getTotalProduct(List<Product> products) {
        return products.stream()
                .map(product -> product.getCount() * product.getPrice())
                .mapToInt(Integer::valueOf).sum();
    }
//
//    Tìm các sản phẩm của thuơng hiệu “Apple”
    public static List<Product> findByBrand(List<Product> products, String brand) {
        return products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

//
//    Tìm các sản phẩm có giá > 20000000
//
//    Tìm các sản phẩm có chữ “pro” trong tên (Không phân biệt hoa thường)
//
//    Thêm 1 sản phẩm bất kỳ vào trong mảng product
//
//    Xóa tất cả sản phẩm của thương hiệu “Samsung” trong giỏ hàng
//
//    Sắp xếp giỏ hàng theo price tăng dần
//
//    Sắp xếp giỏ hàng theo count giảm dần
//
//    Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
}
