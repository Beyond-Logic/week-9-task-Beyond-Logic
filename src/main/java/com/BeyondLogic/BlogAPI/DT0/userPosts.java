package com.BeyondLogic.BlogAPI.DT0;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT )

public class userPosts  {
    private String username;
    private Long post_id;
    private String post_title;
    private  String post_description;
    private Date created_at;
    private Date updated_at;

    public userPosts(String username, Long post_id, String post_title, String post_description, Date created_at, Date updated_at) {
        this.username = username;
        this.post_id = post_id;
        this.post_title = post_title;
        this.post_description = post_description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
