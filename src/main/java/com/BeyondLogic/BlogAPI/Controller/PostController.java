package com.BeyondLogic.BlogAPI.Controller;

import com.BeyondLogic.BlogAPI.DT0.userPosts;
import com.BeyondLogic.BlogAPI.Model.Post;
import com.BeyondLogic.BlogAPI.Repository.PostRepository;
import com.BeyondLogic.BlogAPI.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PostRepository postRepository;


    //Add New Post
    @PostMapping("/addNew/{username}")
    public Post AddPost(@RequestBody Post post, @PathVariable("username") String username) {
        Date current_time = new Date();
        post.setCreated_at(current_time);
        post.setUsers(usersRepository.findByUserName(username));
        return this.postRepository.save(post);
    }


    //GET ALL POSTS
    @GetMapping
    public List<userPosts> getAllPosts() {
        return usersRepository.getUserPosts();
    }

    //GET POSTS BY ID
    @GetMapping("/{id}")
    public Optional<Post> getByPostId(@PathVariable(value = "id") Long id) {
        return this.postRepository.findById(id);
    }


    //UPDATE POST BY USER
    @PutMapping("/{id}/{username}")
    public Post updatePost(@RequestBody Post post, @PathVariable("id") Long id, @PathVariable("username")  String username ){
        Post existingPost =  this.postRepository.findById(id).get();
        existingPost.setPost_title(post.getPost_title());
        existingPost.setPost_description(post.getPost_description());
        Date current_time = new Date();
        existingPost.setUpdated_at(current_time);
        existingPost.setUsers(usersRepository.findByUserName(username));
        return this.postRepository.save(existingPost);
    }


    //DELETE POST BY USER
    @DeleteMapping ("/{id}/{username}")
    public ResponseEntity<Post> deletePost(@PathVariable("id") Long id, @PathVariable("username")  String username) {
        Post exitingPost = this.postRepository.findById(id).get();
        exitingPost.setUsers(usersRepository.findByUserName(username));
        this.postRepository.delete(exitingPost);
        return ResponseEntity.ok().build();
    }

}
