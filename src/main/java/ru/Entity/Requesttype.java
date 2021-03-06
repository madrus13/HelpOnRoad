package ru.Entity;
//import com.j256.ormlite.dao.ForeignCollection;
//import com.j256.ormlite.field.DatabaseField;
//import com.j256.ormlite.field.ForeignCollectionField;
//import com.j256.ormlite.table.DatabaseTable;
//import com.korotaev.r.ms.testormlite.data.Transactional;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;
import ru.Entity.AndroidAnnotation.*;
//import org.springframework.transaction.annotation.Transactional;

@Entity(name = "requesttype")
@Table(name = "requesttype")
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
@DatabaseTable
public class Requesttype implements Serializable {
    @DatabaseField(generatedId = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private Byte isDeleted;

    public static final Long TypeAccumIsDown    = 4L;
    public static final Long TypeNotStarted   = 5L;
    public static final Long TypeStuck = 6L;
    public static final Long TypeAlarm = 7L;
    public static final Long TypeCarNotOpen = 8L;
    public static final Long TypeTowTruckNeed = 9L;


    @JsonIgnore
    @ForeignCollectionField
    private Collection<Request> requestsById;

    public Requesttype() {
    }

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

        Requesttype that = (Requesttype) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "requesttypeByType")
    @JsonIgnore
    public Collection<Request> getRequestsById() {
        return requestsById;
    }

    public void setRequestsById(Collection<Request> requestsById) {
        this.requestsById = requestsById;
    }
}
