package pl.springBoot.HelloSpringBoot.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.springBoot.HelloSpringBoot.classes.User;

public interface UserRepository extends CrudRepository<User, Long> {

@Query("select u from User u where u.username like %?1% AND u.password like %?2%")
public User checkUserInBase(String name, String password);

@Query("select u from User u where u.username like %?1%")
public User checkUserInBase(String name);
}