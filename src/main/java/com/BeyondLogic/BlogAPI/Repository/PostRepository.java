package com.BeyondLogic.BlogAPI.Repository;

import com.BeyondLogic.BlogAPI.Model.Post;
import com.BeyondLogic.BlogAPI.Model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    Post findByUsers(String username);

}
