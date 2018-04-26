package korotaev.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Region implements Serializable  {
    private int id;
    private String name;
    private Byte isDeleted;

    private Collection<Message> messagesById;
    private Collection<User> usersById;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "regionByRegion")
    @Transient
    public Collection<Message> getMessagesById() {
        return messagesById;
    }
    @Transient
    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "regionByRegion")
    @Transient
    public Collection<User> getUsersById() {
        return usersById;
    }
    @Transient
    public void setUsersById(Collection<User> usersById) {
        this.usersById = usersById;
    }
}
