package tn.essat.boitemessagerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.boitemessagerie.model.User;


@Repository
public interface IUser extends JpaRepository<User, Integer> {
	
	
	User findByUsername(String username);
	

}
