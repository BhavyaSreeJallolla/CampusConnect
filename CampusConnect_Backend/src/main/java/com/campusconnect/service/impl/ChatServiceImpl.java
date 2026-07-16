package com.campusconnect.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.campusconnect.entity.Alumni;
import com.campusconnect.entity.ChatMessage;
import com.campusconnect.entity.Student;
import com.campusconnect.entity.User;
import com.campusconnect.enums.ConnectionStatus;
import com.campusconnect.repository.AlumniRepository;
import com.campusconnect.repository.ChatMessageRepository;
import com.campusconnect.repository.ConnectionRepository;
import com.campusconnect.repository.StudentRepository;
import com.campusconnect.repository.UserRepository;
import com.campusconnect.service.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AlumniRepository alumniRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    public ChatMessage sendMessage(ChatMessage chatMessage) {

        User sender = userRepository.findById(chatMessage.getSender().getId())
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        User receiver = userRepository.findById(chatMessage.getReceiver().getId())
                .orElseThrow(() -> new RuntimeException("Receiver not found"));
       System.out.println("Sender User ID = " + sender.getId());
        System.out.println("Receiver User ID = " + receiver.getId());

        System.out.println("Sender Student = " + studentRepository.findByUser(sender).isPresent());
        System.out.println("Sender Alumni = " + alumniRepository.findByUser(sender).isPresent());

        System.out.println("Receiver Student = " + studentRepository.findByUser(receiver).isPresent());
        System.out.println("Receiver Alumni = " + alumniRepository.findByUser(receiver).isPresent());

       
        Long studentId = null;
        Long alumniId = null;

        if (studentRepository.findByUser(sender).isPresent()
                && alumniRepository.findByUser(receiver).isPresent()) {

            Student student = studentRepository.findByUser(sender).get();
            Alumni alumni = alumniRepository.findByUser(receiver).get();

            studentId = student.getStudentId();
            alumniId = alumni.getAlumniId();

        } else if (alumniRepository.findByUser(sender).isPresent()
                && studentRepository.findByUser(receiver).isPresent()) {

            Alumni alumni = alumniRepository.findByUser(sender).get();
            Student student = studentRepository.findByUser(receiver).get();

            studentId = student.getStudentId();
            alumniId = alumni.getAlumniId();

        } else {

            throw new RuntimeException(
                    "Chat is allowed only between Student and Alumni.");
        }

        boolean connected =
                connectionRepository.existsByStudentIdAndAlumniIdAndStatus(
                        studentId,
                        alumniId,
                        ConnectionStatus.ACCEPTED
                );

        if (!connected) {

            throw new RuntimeException(
                    "You can chat only after the connection request is accepted.");
        }

        chatMessage.setSender(sender);
        chatMessage.setReceiver(receiver);

        return chatMessageRepository.save(chatMessage);
    }

    @Override
    public List<ChatMessage> getConversation(Long senderId,
                                             Long receiverId) {

        User sender = userRepository.findById(senderId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        User receiver = userRepository.findById(receiverId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        List<ChatMessage> sent =
                chatMessageRepository.findBySenderAndReceiver(sender, receiver);

        List<ChatMessage> received =
                chatMessageRepository.findBySenderAndReceiver(receiver, sender);

        return Stream.concat(sent.stream(), received.stream())
                .sorted(Comparator.comparing(ChatMessage::getCreatedDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChatMessage> getMessagesByUser(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return Stream.concat(
                chatMessageRepository.findBySender(user).stream(),
                chatMessageRepository.findByReceiver(user).stream())
                .sorted(Comparator.comparing(ChatMessage::getCreatedDate))
                .collect(Collectors.toList());
    }
}