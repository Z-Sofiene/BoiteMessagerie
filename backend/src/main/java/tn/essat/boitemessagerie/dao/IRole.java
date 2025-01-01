package tn.essat.boitemessagerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.boitemessagerie.model.Role;


@Repository
public interface IRole extends JpaRepository<Role, Integer> {

}
