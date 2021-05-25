//package com.BeyondLogic.BlogAPI.Controller;
//import com.BeyondLogic.BlogAPI.Repository.PostRepository;
//import com.BeyondLogic.BlogAPI.Repository.LikeRepository;
//import com.BeyondLogic.BlogAPI.Repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/reactions")
//public class ReactionController {
//
//    @Autowired
//    LikeRepository likeRepository;
//
//    @Autowired
//    UsersRepository usersRepository;
//
//    @Autowired
//    PostRepository postRepository;
//
//    //Add Reaction
//    @PostMapping("/{post_id}/{like}/{username}")
//    public Reaction AddReaction(Reaction reaction, @PathVariable("post_id")  Long post_id, @PathVariable("like") String like, @PathVariable("username")  String username) {
//        reaction.setLike(reaction.getLike());
//        reaction.setLike(+1);
//        reaction.setUnlike(-0);
//        reaction.setPost(postRepository.findById(post_id).get());
//        reaction.setUsers(usersRepository.findByUserName(username));
//        return this.likeRepository.save(reaction);
//    }
//
//    //GET ALL USER REACTIONS
//    @GetMapping
//    public List<Reaction> getAllLikes() {
//        return (List<Reaction>) this.likeRepository.findAll();
//    }
//
////
////    String like = "Reaction";
////        reaction.setPost_reaction(like);
////        if(reaction.getPost_reaction().equalsIgnoreCase("Reaction")) {
////        reaction.setPost_like_counts(reaction.getPost_like_counts(+1));
////        reaction.setPost_unlike_counts(reaction.getPost_unlike_counts(0));
////    } else if (reaction.getPost_reaction().equalsIgnoreCase("Unlike")) {
////        reaction.setPost_unlike_counts(reaction.getPost_unlike_counts(-1));
////        reaction.setPost_like_counts(reaction.getPost_like_counts(0));
////    }
////        reaction.setPost_reaction(reaction.getPost_reaction());
////        reaction.setPost_reaction(String.valueOf(reaction.getPost_reaction().equalsIgnoreCase("Unlike")));
//
//}
