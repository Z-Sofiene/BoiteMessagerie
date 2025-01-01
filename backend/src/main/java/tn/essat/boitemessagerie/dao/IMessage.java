package tn.essat.boitemessagerie.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.essat.boitemessagerie.model.Message;

import java.util.List;

@Repository
public interface IMessage extends JpaRepository<Message, Integer> {
    List<Message> findAllByUserreceiveId(int userreceiveId);
    List<Message> findAllByUsersendId(int usersendId);
}
