package com.BeyondLogic.BlogAPI.DT0;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT )

public class userComments {
    private String username;
    private Long post_id;
    private String post_title;
    private String post_description;
    private Long comment_id;
    private String post_comment;
    private Date created_at;
    private Date updated_at;


    public userComments(String username, Long post_id, String post_title, String post_description, Long comment_id, String post_comment, Date created_at, Date updated_at) {
        this.username = username;
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_description = post_description;
        this.comment_id = comment_id;
        this.post_comment = post_comment;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
