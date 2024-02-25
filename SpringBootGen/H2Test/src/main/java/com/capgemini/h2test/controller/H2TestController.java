package com.capgemini.h2test.controller;

import com.capgemini.h2test.model.Message;
import com.capgemini.h2test.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class H2TestController
{

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(value = "/")
    public String startUp(Model model)
    {
        Message message = new Message();
        message.setContent("Checking in the template now!");
        messageRepository.save(message);
        Message savedMessage = messageRepository.findById(message.getId()).orElse(null);
        if(savedMessage != null)
        {
            model.addAttribute("message", savedMessage.getContent());
        }
        else
        {
            model.addAttribute("message", "Message not found!");
        }
        return "welcome";
    }
}