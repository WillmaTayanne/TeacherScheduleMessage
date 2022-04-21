package com.pdist.message.Service;

import com.pdist.message.Model.Message;
import com.pdist.message.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> read() {
        return this.messageRepository.findAll();
    }

    public Message readById(Long id){
        return this.messageRepository.findById(id).orElse(null);
    }

    @Transactional
    public Message push(Message message){
        return this.messageRepository.save(message);
    }

    public void delete(Long id){
        this.messageRepository.deleteById(id);
    }
}
