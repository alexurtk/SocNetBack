package com.socnet.back.persistence.service;

import com.socnet.back.persistence.model.MessageModel;
import com.socnet.back.persistence.model.PostModel;
import com.socnet.back.persistence.model.UserModel;

import java.util.List;


public interface MessagesService {
    void save(MessageModel message);

    /**
     * Находит все сообщения исходящие и входящие, принадлежащие пользователю с указанным email
     * @param sender
     * @return
     */
    List<MessageModel> getMessagesBySender(String sender); //fixme м.б. не нужно

    /**
     * Находит все сообщения в правильном порядке из переписки emailFrom с emailTo
     * @param sender отправитель, т.е. текущий пользователь
     * @param receiver с кем ведется переписка
     * @return
     */
    List<MessageModel> getChatBySenderAndRecevier(String sender, String receiver);

    /**
     * Получить список пользователей с кем ведет переписку sender
     * @param sender
     * @return
     */
    List<UserModel> getAllChatUsersWithSender(String sender);

    //todo список пользователей, от которых есть новые сообщения
    //составляется по признаку того, что сообщение прочитано / не прочитано

    List<String> test(String sender);
}
