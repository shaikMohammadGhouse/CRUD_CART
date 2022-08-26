/*
 * package com.shoppingcart.app.repository;
 * 
 * import java.util.List;
 * 
 * import org.springframework.data.jpa.repository.JpaRepository; import
 * org.springframework.data.jpa.repository.Query; import
 * org.springframework.data.repository.query.Param; import
 * org.springframework.stereotype.Repository;
 * 
 * import com.shoppingcart.app.dao.User;
 * 
 * @Repository public interface UserRepository extends JpaRepository<User,
 * String>{
 * 
 * public User findByUserId(String userId);
 * 
 * @Query("SELECT u FROM User u WHERE u.role =:amount") public List<User>
 * getMaangerUsers(@Param("role") String role); }
 */