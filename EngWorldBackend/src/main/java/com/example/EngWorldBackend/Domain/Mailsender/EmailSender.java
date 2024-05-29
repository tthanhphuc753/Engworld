package com.example.EngWorldBackend.Domain.Mailsender;

import com.example.EngWorldBackend.Domain.Model.User.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface EmailSender {
    void send(String url, User theUser) throws MessagingException
            , UnsupportedEncodingException;
}


