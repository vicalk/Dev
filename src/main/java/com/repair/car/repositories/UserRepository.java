package com.repair.car.repositories;


        import com.repair.car.domain.User;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    User findByEmail(String email);

    User findByAfm(String afm);

    User findByEmailAndPassword(String email, String password);

    User save(User user);

    void deleteByUserId(Long userId);
}
