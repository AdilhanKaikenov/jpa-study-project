package com.epam.adok.jpaproject.entity;

import com.epam.adok.jpaproject.entity.comment.AbstractComment;
import com.epam.adok.jpaproject.entity.comment.BlogComment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.readById", query = "SELECT user FROM User user WHERE user.id = :id"),
        @NamedQuery(name = "User.readAuth", query = "SELECT user FROM User user WHERE user.login = :login and user.password = :password"),
        @NamedQuery(name = "User.readByLogin", query = "SELECT user FROM User user WHERE user.login = :login")
})
@Table(name = "user")
public class User extends AbstractBaseEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_registration")
    private Date registrationDate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<Role> roles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AbstractComment> comments;

    public User() {
    }

    public Set<AbstractComment> getComments() {
        return comments;
    }

    public void setComments(Set<AbstractComment> comments) {
        this.comments = comments;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                ", roles=" + roles +
                '}';
    }
}
