package m2.gi.SimpleChat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import m2.gi.SimpleChat.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
