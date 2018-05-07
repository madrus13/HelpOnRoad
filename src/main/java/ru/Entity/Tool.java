package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tool")
@Table(name = "tool")
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Tool implements Serializable {
    private Long id;
    private Long type;
    private Long user;
    private Byte isDeleted;
    private Tooltypes tooltypesByType;
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
    @Column(name = "Type", nullable = true)
    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    @Basic
    @Column(name = "User", nullable = true)
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Basic
    @Column(name = "IsDeleted", nullable = true)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tool tool = (Tool) o;

        if (id != tool.id) return false;
        if (type != null ? !type.equals(tool.type) : tool.type != null) return false;
        if (user != null ? !user.equals(tool.user) : tool.user != null) return false;
        if (isDeleted != null ? !isDeleted.equals(tool.isDeleted) : tool.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "Type", referencedColumnName = "Id", insertable = false, updatable = false)
    public Tooltypes getTooltypesByType() {
        return tooltypesByType;
    }

    public void setTooltypesByType(Tooltypes tooltypesByType) {
        this.tooltypesByType = tooltypesByType;
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
