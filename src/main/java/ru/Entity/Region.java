package ru.Entity;
//import com.j256.ormlite.dao.ForeignCollection;
//import com.j256.ormlite.field.DatabaseField;
//import com.j256.ormlite.field.ForeignCollectionField;
//import com.j256.ormlite.table.DatabaseTable;
//import com.korotaev.r.ms.testormlite.data.Transactional;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;
import ru.Entity.AndroidAnnotation.DatabaseField;
import ru.Entity.AndroidAnnotation.DatabaseTable;
import ru.Entity.AndroidAnnotation.ForeignCollectionField;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import ru.Entity.AndroidAnnotation.*;
import ru.Entity.AndroidAnnotation.*;

@Entity(name = "region")
@Table(name = "region")
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
@DatabaseTable
public class Region implements Serializable  {
    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private Byte isDeleted;

    @JsonIgnore
    @ForeignCollectionField
    private Collection<Message> messagesById;
    @JsonIgnore
    @ForeignCollectionField
    private  Collection<User> usersById;

    public Region() {
    }

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
