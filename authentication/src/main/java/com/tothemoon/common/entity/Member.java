package com.tothemoon.common.entity;

import com.bird.enums.Role;
import com.bird.enums.UserStatus;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 200, nullable = false)
    private String password;
    @Column(length = 50)
    private String email;
    @Column
    private Long points;
    @Column(length = 50, nullable = false)
    private String phone;
    @Column
    private LocalDate dateOfBirth;
    @Column
    private LocalDate lastLogin;
    @Column(length = 200)
    private String bio;
    @Column(nullable = false)
    private String profileImageUrl;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    private Role role;
    @Column(length = 20)
    private String resetKey;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private UserStatus status;
    @Column
    private Boolean firstTimeLogin;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<Member> friends;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Comment> comments;

    @CreationTimestamp
    @Column
    private ZonedDateTime createTime;
    @CreationTimestamp
    @Column
    private ZonedDateTime updateTime;
}

