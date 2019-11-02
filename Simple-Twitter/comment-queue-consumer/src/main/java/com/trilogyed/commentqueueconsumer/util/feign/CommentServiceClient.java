package com.trilogyed.commentqueueconsumer.util.feign;

import com.trilogyed.commentqueueconsumer.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "comment-service")
public interface CommentServiceClient {

    @PostMapping(value = "/comments")
    @ResponseStatus(HttpStatus.CREATED)
    Comment createComment(@RequestBody Comment comment);
}
