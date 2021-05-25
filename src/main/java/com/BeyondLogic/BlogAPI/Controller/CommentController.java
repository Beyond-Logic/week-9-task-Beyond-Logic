package com.BeyondLogic.BlogAPI.Controller;

import com.BeyondLogic.BlogAPI.DT0.userComments;
import com.BeyondLogic.BlogAPI.DT0.userPosts;
import com.BeyondLogic.BlogAPI.Model.Comment;
import com.BeyondLogic.BlogAPI.Model.Post;
import com.BeyondLogic.BlogAPI.Repository.CommentRepository;
import com.BeyondLogic.BlogAPI.Repository.PostRepository;
import com.BeyondLogic.BlogAPI.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PostRepository postRepository;


    //Add New Comment
    @PostMapping("/addNew/{post_id}/{username}")
    public Comment AddComment(@RequestBody Comment comment, @PathVariable("post_id")  Long post_id, @PathVariable("username")  String username) {
        Date current_time = new Date();
        comment.setCreated_at(current_time);
        comment.setPost(postRepository.findById(post_id).get());
        comment.setUsers(usersRepository.findByUserName(username));
        return this.commentRepository.save(comment);
    }

    //GET ALL Comments

    @GetMapping
    public List<userComments> getAllComments() {
        return usersRepository.getUserComments();
    }

    //GET COMMENT BY ID
    @GetMapping("/{id}")
    public Optional<Comment> getByCommentId(@PathVariable(value = "id") Long id) {
        return this.commentRepository.findById(id);
    }

    //GET COMMENT BY USERNAME
    @GetMapping("/{id}/{username}")
    public Optional<Comment> getByCommentUserName(@PathVariable(value = "id") Long id, @PathVariable("username")  String username) {
        Comment exitingComment = this.commentRepository.findById(id).get();
        exitingComment.setUsers(usersRepository.findByUserName(username));
        return this.commentRepository.findById(id);
    }

    //UPDATE COMMENT BY USER
    @PutMapping("/{id}/{username}")
    public Comment updateComment(@RequestBody Comment comment, @PathVariable("id") Long id, @PathVariable("username")  String username ){
        Comment existingComment =  this.commentRepository.findById(id).get();
        existingComment.setPost_comment(comment.getPost_comment());
        Date current_time = new Date();
        existingComment.setUpdated_at(current_time);
        existingComment.setUsers(usersRepository.findByUserName(username));
        return this.commentRepository.save(existingComment);
    }

    //DELETE COMMENT BY USER
    @DeleteMapping ("/{id}/{username}")
    public ResponseEntity<Comment> deleteCommentByUser(@PathVariable("id") Long id, @PathVariable("username")  String username) {
        Comment exitingComment = this.commentRepository.findById(id).get();
        exitingComment.setUsers(usersRepository.findByUserName(username));
        this.commentRepository.delete(exitingComment);
        return ResponseEntity.ok().build();
    }

}
