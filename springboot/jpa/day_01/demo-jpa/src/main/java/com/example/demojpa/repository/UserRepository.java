package com.example.demojpa.repository;

import com.example.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Sử dụng method query
    Optional<User> findByEmail(String email);

    Optional<User> findByNameAndEmail(String name, String email);

    // Sử dụng JPQL query
    @Query("select u from User u where u.email = ?1")
    Optional<User> findByEmailUsingJPQL(String email);

    @Query("select u from User u where u.email = :email")
    Optional<User> findByEmailUsingJPQL1(@Param("email") String email);

    @Query("select u from User u where u.email = ?2 and u.name = ?1")
    Optional<User> findByNameAndEmailUsingJPQL(String name, String email);

    @Query("select u from User u where u.email = :email and u.name = :name")
    Optional<User> findByNameAndEmailUsingJPQL1(@Param("name") String name, @Param("email") String email);

    // Sử dụng native query
    @Query(nativeQuery = true, value = "select * from user u where u.email = ?1")
    Optional<User> findByEmailUsingNativeQuery(String email);

//    List<User> findByName(String name);
//
//    List<User> findByNameContaining(String keyword); // hiên -> Hi false
//
//    List<User> findByNameContainingIgnoreCase(String keyword); // hiên -> Hi true
//
//    List<User> findByNameStartsWith(String prefix); // anh -> a true // anh -> b false
//
//
//    List<User> findByNameOrEmail(String name, String email);
//
//    long countByName(String name);
//
//    boolean existsByEmail(String email);
//
//    List<User> findByBirthdayBefore(LocalDate date);
//
//    List<User> findTop2ByBirthdayAfter(LocalDate date);
//
    Optional<User> findFirstByBirthdayAfter(LocalDate date);
}
