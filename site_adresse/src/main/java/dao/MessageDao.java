package dao;

import entities.Message;

import java.util.List;

public interface MessageDao {

    List<Message> listMessage();
    void addMessage(Message message);
    void deleteMessage(int id);
}
