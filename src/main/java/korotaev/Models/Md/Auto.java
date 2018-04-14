package korotaev.Models.Md;

import javax.persistence.*;

@Entity
public class Auto {
    private int id;
    private String name;
    private Byte haveCable;
    private Integer user;
    private Byte isDeleted;
    private Integer transmissionType;
    private User userByUser;
    private Transmissiontype transmissiontypeByTransmissionType;

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
    @Column(name = "HaveCable", nullable = true)
    public Byte getHaveCable() {
        return haveCable;
    }

    public void setHaveCable(Byte haveCable) {
        this.haveCable = haveCable;
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

    @Basic
    @Column(name = "TransmissionType", nullable = true)
    public Integer getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(Integer transmissionType) {
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
        int result = id;
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
    public Transmissiontype getTransmissiontypeByTransmissionType() {
        return transmissiontypeByTransmissionType;
    }

    public void setTransmissiontypeByTransmissionType(Transmissiontype transmissiontypeByTransmissionType) {
        this.transmissiontypeByTransmissionType = transmissiontypeByTransmissionType;
    }
}
