package chatop.mazoyer.alexandre.projetThree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chatop.mazoyer.alexandre.projetThree.models.Message;


public interface MessageRepository extends JpaRepository<Message, Long>{

}
