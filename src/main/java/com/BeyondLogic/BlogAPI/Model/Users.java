package com.BeyondLogic.BlogAPI.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {

    @Column(name = "username")
    private String userName;

    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "registered_At", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registeredAt;

    @Column(name = "updated_At")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(targetEntity = Post.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private List<Post> posts;

    @OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(targetEntity = Favourite.class,cascade = CascadeType.ALL)
    private List<Favourite> favourites;

    @OneToMany(targetEntity = Connection.class,cascade = CascadeType.ALL)
    private List<Connection> connections;

//    @OneToMany(targetEntity = Reaction.class, cascade = CascadeType.ALL)
//    private List<Reaction> reactions;

}
