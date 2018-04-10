package com.socnet.back.controller;

import com.socnet.back.persistence.model.MessageModel;
import com.socnet.back.persistence.model.UserModel;
import com.socnet.back.persistence.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    @Autowired
    private MessagesService messageService;

    /**
     * Получить все сообщения в правильном порядке из переписки отправителя с получателем
     * @param emailFrom
     * @param emailTo
     * @return
     */
    @RequestMapping(value = "/getMessagesBySenderReceiver/{emailFrom:.+}/{emailTo:.+}", method = RequestMethod.GET)
    public List<MessageModel> getMessagesBySenderReceiver(@PathVariable("emailFrom") String emailFrom,
                                                @PathVariable("emailTo") String emailTo) {
        List<MessageModel> messages = messageService.getChatBySenderAndRecevier(emailFrom, emailTo);
        return messages;
    }

    /**
     * Получить все сообщения отправителя
     * @param sender
     * @return
     */
    @RequestMapping(value = "/getMessagesBySender/{sender:.+}", method = RequestMethod.GET)
    public List<MessageModel> getMessageBySender(@PathVariable("sender") String sender) {
        List<MessageModel> messages = messageService.getMessagesBySender(sender);
        return messages;
    }

    /**
     * Отправить сообщение
     * @param message
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String createUser(@RequestBody MessageModel message){
        try {
            messageService.save(message);
        } catch (Exception e){
            return e.toString();
        }
        return "ok";  //при exception будет 0
    }


    @RequestMapping(value = "/test/{sender:.+}", method = RequestMethod.GET)
    public List<MessageModel> test(@PathVariable("sender") String sender) {
        List<MessageModel> receviers = messageService.getChatBySenderAndRecevier(sender, "furer@mail.ru");
        return receviers;
    }

    @RequestMapping(value = "/getAllChatUsersWithSender/{sender:.+}", method = RequestMethod.GET)
    public List<UserModel> getChatUsers(@PathVariable("sender") String sender) {
        List<UserModel> receviers = messageService.getAllChatUsersWithSender(sender);
        return receviers;
    }



}
