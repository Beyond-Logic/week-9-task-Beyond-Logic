package com.BeyondLogic.BlogAPI.Repository;

import com.BeyondLogic.BlogAPI.DT0.userComments;
import com.BeyondLogic.BlogAPI.DT0.userPosts;
import com.BeyondLogic.BlogAPI.Model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Optional<Users> login(String email, String password);

    Optional<Users> findByUserName(String username);

    Optional<Users> deleteByUserName(String username);

    @Query("SELECT new com.BeyondLogic.BlogAPI.DT0.userPosts(u.users.userName, u.post_id, u.post_title, u.post_description, u.created_at, u.updated_at) FROM Post u JOIN u.users p")
    public List<userPosts> getUserPosts();

    @Query("SELECT new com.BeyondLogic.BlogAPI.DT0.userComments(u.users.userName, u.post.post_id, u.post.post_title, u.post.post_description, u.comment_id, u.post_comment, u.created_at, u.updated_at) FROM Comment u JOIN u.users p")
    public List<userComments> getUserComments();

}
