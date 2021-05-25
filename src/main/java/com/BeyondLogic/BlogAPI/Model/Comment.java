package com.BeyondLogic.BlogAPI.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    private String post_comment;
    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToOne
    private Users users;

    @ManyToOne
    private Post post;

}
