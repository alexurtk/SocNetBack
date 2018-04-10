package com.socnet.back.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "messages")
public class MessageModel {
    @Id
    @GenericGenerator(name = "gen", strategy = "increment")
    @GeneratedValue(generator = "gen")
    @Column(name = "id", unique = true, nullable = false, precision = 15, scale = 0)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "receiver", nullable = false)
    private String receiver;

    @Column(name = "time", nullable = false, updatable = true, insertable = true)
    private Timestamp time;

    //todo признак того, что сообщение прочитано / не прочитано
    //по этому признаку будет составляться список пользователей, от которых есть новые сообщения

}
