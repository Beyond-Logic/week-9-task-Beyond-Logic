package com.BeyondLogic.BlogAPI.Repository;

import com.BeyondLogic.BlogAPI.Model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
