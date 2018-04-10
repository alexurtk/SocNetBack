package com.socnet.back.persistence.repository;

import com.socnet.back.persistence.model.MessageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessagesRepository extends JpaRepository<MessageModel, Long> {

//    List<MessageModel> findAllByFromAndTo(String from, String to);//найти все сообщения пользователя
    List<MessageModel> findAllBySenderAndReceiver(String sender, String receiver);//найти все сообщения по переписке отправителя с получателем
    List<MessageModel> findAllBySender(String sender);//найти все сообщения пользователя
    //List<String> findAllReceiverBySender(String sender);//найти все сообщения пользователя

//    @Query("select distinct m.receiver from MessageModel m where m.sender = ?1 or receiver = ?1")
//    List<String> findAllChatEmailsBySender(String sender);//найти email всех собеседников отправителя


    @Query("select distinct m.receiver from MessageModel m where m.sender = ?1")
    List<String> findAllChatEmailsBySender(String sender);//найти email всех собеседников отправителя

    @Query("select distinct m.sender from MessageModel m where m.receiver = ?1")
    List<String> findAllChatEmailsByReceiver(String sender);//найти email всех собеседников отправителя


}
