package hrmsnet.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.users.User;


public interface UserDao extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
}
