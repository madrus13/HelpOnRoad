package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Tool implements Serializable {
    private int id;
    private Integer type;
    private Integer user;
    private Byte isDeleted;
    private Tooltypes tooltypesByType;
    private User userByUser;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "User", nullable = true)
    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
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
        int result = id;
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
