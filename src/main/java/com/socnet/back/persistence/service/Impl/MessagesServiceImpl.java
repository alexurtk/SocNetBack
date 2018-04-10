package com.socnet.back.persistence.service.Impl;

import com.socnet.back.persistence.model.MessageModel;
import com.socnet.back.persistence.model.UserModel;
import com.socnet.back.persistence.repository.MessagesRepository;
import com.socnet.back.persistence.repository.UserRepository;
import com.socnet.back.persistence.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(MessageModel message) {
        message.setTime(Timestamp.valueOf(LocalDateTime.now()));
        messageRepository.save(message);
    }

    @Override
    public List<MessageModel> getMessagesBySender(String email) {
        return messageRepository.findAllBySender(email);
    }

    @Override
    public List<MessageModel> getChatBySenderAndRecevier(String sender, String receiver) {


        List<MessageModel> messagesFromMe = messageRepository.findAllBySenderAndReceiver(sender, receiver);
        List<MessageModel> messagesToMe = messageRepository.findAllBySenderAndReceiver(receiver, sender);

        //далее их нужно объекдинить в правильном порядке по времени

        List<MessageModel> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < messagesFromMe.size() && j < messagesToMe.size()){
            if (messagesFromMe.get(i).getTime().before(messagesToMe.get(j).getTime())){
                result.add(messagesFromMe.get(i));
                i++;
            } else {
                result.add(messagesToMe.get(j));
                j++;
            }
        }

        if (i < messagesFromMe.size()){
            while (i < messagesFromMe.size()){
                result.add(messagesFromMe.get(i));
                i++;
            }
        } else {
            while (j < messagesToMe.size()){
                result.add(messagesToMe.get(j));
                j++;
            }
        }

        return result;
    }

    @Override
    public List<UserModel> getAllChatUsersWithSender(String sender) {
        List<String> receivers = messageRepository.findAllChatEmailsBySender(sender);
        List<String> senders = messageRepository.findAllChatEmailsByReceiver(sender);
        receivers.addAll(senders);
        Set<String> emails = new TreeSet<>();
        for (String email : receivers) {
            if (!email.equals(sender))
                emails.add(email);
//                users.add(userRepository.findByEmail(email));
        }
        List<UserModel> chatUsers = new ArrayList<>();
        emails.stream().forEach(s->chatUsers.add(userRepository.findByEmail(s)));
        return chatUsers;
    }


    @Override
    public List<String> test(String sender) {
        return messageRepository.findAllChatEmailsBySender(sender);
//        messageRepository.findDistinctReceiverBySender();
//        return null;
    }

}
