package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Region implements Serializable  {
    private Long id;
    private String name;
    private Byte isDeleted;

    @JsonIgnore
    private  Collection<Message> messagesById;
    @JsonIgnore
    private  Collection<User> usersById;

    @Id
    @Column(name = "Id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Region region = (Region) o;

        if (id != region.id) return false;
        if (name != null ? !name.equals(region.name) : region.name != null) return false;
        if (isDeleted != null ? !isDeleted.equals(region.isDeleted) : region.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionByRegion")
    @JsonIgnore
    public Collection<Message> getMessagesById() {
        return messagesById;
    }
    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "regionByRegion")
    @JsonIgnore
    public Collection<User> getUsersById() {
        return usersById;
    }

    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
