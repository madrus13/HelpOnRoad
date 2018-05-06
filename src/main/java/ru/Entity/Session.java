package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "session")
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Session implements Serializable {
    private Long id;
    private String token;
    private Timestamp creationDate;
    private Long user;
    private User userByUser;

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Token", nullable = false, length = 50)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "CreationDate", nullable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "User", nullable = true)
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        if (id != session.id) return false;
        if (token != null ? !token.equals(session.token) : session.token != null) return false;
        if (creationDate != null ? !creationDate.equals(session.creationDate) : session.creationDate != null)
            return false;
        if (user != null ? !user.equals(session.user) : session.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "User", referencedColumnName = "Id", insertable = false, updatable = false)
    public User getUserByUser() {
        return userByUser;
    }

    public void setUserByUser(User userByUser) {
        this.userByUser = userByUser;
    }
}
