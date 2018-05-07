package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "auto")
@Table(name = "auto")
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Auto implements Serializable {
    private Long id;
    private String name;
    private Byte haveCable;
    private Long user;
    private Byte isDeleted;
    private Long transmissionType;
    private User userByUser;
    private TransmissionType transmissionTypeByTransmissionType;

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
    @Column(name = "HaveCable", nullable = true)
    public Byte getHaveCable() {
        return haveCable;
    }

    public void setHaveCable(Byte haveCable) {
        this.haveCable = haveCable;
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

    @Basic
    @Column(name = "TransmissionType", nullable = true)
    public Long getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(Long transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auto auto = (Auto) o;

        if (id != auto.id) return false;
        if (name != null ? !name.equals(auto.name) : auto.name != null) return false;
        if (haveCable != null ? !haveCable.equals(auto.haveCable) : auto.haveCable != null) return false;
        if (user != null ? !user.equals(auto.user) : auto.user != null) return false;
        if (isDeleted != null ? !isDeleted.equals(auto.isDeleted) : auto.isDeleted != null) return false;
        if (transmissionType != null ? !transmissionType.equals(auto.transmissionType) : auto.transmissionType != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (haveCable != null ? haveCable.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (transmissionType != null ? transmissionType.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "TransmissionType", referencedColumnName = "Id", insertable = false, updatable = false)
    public TransmissionType getTransmissionTypeByTransmissionType() {
        return transmissionTypeByTransmissionType;
    }

    public void setTransmissionTypeByTransmissionType(TransmissionType transmissionTypeByTransmissionType) {
        this.transmissionTypeByTransmissionType = transmissionTypeByTransmissionType;
    }
}
