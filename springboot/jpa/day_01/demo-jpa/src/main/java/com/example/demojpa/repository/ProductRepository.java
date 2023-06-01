package com.example.demojpa.repository;

import com.example.demojpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    // Tìm kiếm sản phẩm theo tên và sắp xếp theo tên giảm dần

    // Tìm kiếm sản phầm có tên chưa ký tự, không phần biệt hoa thường (có phân trang)

    // Sắp xếp các sản phẩm theo giá giảm dần

    // Sắp xếp các sản phẩm theo tên (A -> Z), có phân trang

    // Sắp xếp sản phẩm theo count, có phân trang

    // Tìm kiếm sản phẩm theo brand nào đó và sắp xếp theo giá, có phân trang

    // Đếm số lượng các sản phẩm theo brand

    // Tính tổng các sản phẩm còn lại trong kho theo brand
}