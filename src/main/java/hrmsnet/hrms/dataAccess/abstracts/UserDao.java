package hrmsnet.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import hrmsnet.hrms.entities.concretes.users.User;


public interface UserDao extends JpaRepository<User, Integer> {

}
