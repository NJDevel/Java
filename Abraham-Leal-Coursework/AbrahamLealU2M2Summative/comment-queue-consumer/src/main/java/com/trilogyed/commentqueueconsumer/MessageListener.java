package com.trilogyed.commentqueueconsumer;

import com.trilogyed.commentqueueconsumer.model.Comment;
import com.trilogyed.commentqueueconsumer.util.feign.CommentServiceClient;
import com.trilogyed.commentqueueconsumer.util.messages.CommentEntry;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class MessageListener {

    @Autowired
    private CommentServiceClient commentServiceClient;

    MessageListener(CommentServiceClient commentServiceClient) {
        this.commentServiceClient = commentServiceClient;
    }

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveMessages(CommentEntry msg) {
        System.out.println(msg.toString());
        Comment comment = new Comment();
        comment.setCommentId(msg.getCommentId());
        comment.setCommenterName(msg.getCommenterName());
        comment.setCreateDate(LocalDate.parse(msg.getCreateDate()));
        comment.setPostId(msg.getPostId());
        comment.setComment(msg.getComment());
        commentServiceClient.createComment(comment);
    }

}
