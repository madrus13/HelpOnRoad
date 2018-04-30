package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
public class Request implements Serializable {
    private Long id;
    private String description;
    private Timestamp creationDate;
    private Timestamp modifyDate;
    private Timestamp closeDate;
    private Byte isResolvedByUser;
    private String requestPhotoPath;
    private Byte isDeleted;
    private Long user;
    private Long creationUser;
    private Double latitude;
    private Double longitude;
    private Long type;
    private Long status;
    private Collection<Message> messagesById;
    private User userByUser;
    private User userByCreationUser;
    private Requesttype requesttypeByType;
    private Requeststatus requeststatusByStatus;

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
    @Column(name = "Description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "ModifyDate", nullable = false)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "CloseDate", nullable = true)
    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    @Basic
    @Column(name = "IsResolvedByUser", nullable = true)
    public Byte getIsResolvedByUser() {
        return isResolvedByUser;
    }

    public void setIsResolvedByUser(Byte isResolvedByUser) {
        this.isResolvedByUser = isResolvedByUser;
    }

    @Basic
    @Column(name = "RequestPhotoPath", nullable = true, length = 100)
    public String getRequestPhotoPath() {
        return requestPhotoPath;
    }

    public void setRequestPhotoPath(String requestPhotoPath) {
        this.requestPhotoPath = requestPhotoPath;
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
    @Column(name = "User", nullable = true)
    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    @Basic
    @Column(name = "CreationUser", nullable = true)
    public Long getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(Long creationUser) {
        this.creationUser = creationUser;
    }

    @Basic
    @Column(name = "Latitude", nullable = true, precision = 0)
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "Longitude", nullable = true, precision = 0)
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
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
    @Column(name = "Status", nullable = true)
    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (id != request.id) return false;
        if (description != null ? !description.equals(request.description) : request.description != null) return false;
        if (creationDate != null ? !creationDate.equals(request.creationDate) : request.creationDate != null)
            return false;
        if (modifyDate != null ? !modifyDate.equals(request.modifyDate) : request.modifyDate != null) return false;
        if (closeDate != null ? !closeDate.equals(request.closeDate) : request.closeDate != null) return false;
        if (isResolvedByUser != null ? !isResolvedByUser.equals(request.isResolvedByUser) : request.isResolvedByUser != null)
            return false;
        if (requestPhotoPath != null ? !requestPhotoPath.equals(request.requestPhotoPath) : request.requestPhotoPath != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(request.isDeleted) : request.isDeleted != null) return false;
        if (user != null ? !user.equals(request.user) : request.user != null) return false;
        if (creationUser != null ? !creationUser.equals(request.creationUser) : request.creationUser != null)
            return false;
        if (latitude != null ? !latitude.equals(request.latitude) : request.latitude != null) return false;
        if (longitude != null ? !longitude.equals(request.longitude) : request.longitude != null) return false;
        if (type != null ? !type.equals(request.type) : request.type != null) return false;
        if (status != null ? !status.equals(request.status) : request.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
        result = 31 * result + (isResolvedByUser != null ? isResolvedByUser.hashCode() : 0);
        result = 31 * result + (requestPhotoPath != null ? requestPhotoPath.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (creationUser != null ? creationUser.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "requestByRequest")
    @JsonIgnore
    public Collection<Message> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "User", referencedColumnName = "Id", insertable = false, updatable = false)
    public User getUserByUser() {
        return userByUser;
    }

    public void setUserByUser(User userByUser) {
        this.userByUser = userByUser;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "CreationUser", referencedColumnName = "Id", insertable = false, updatable = false)
    public User getUserByCreationUser() {
        return userByCreationUser;
    }

    public void setUserByCreationUser(User userByCreationUser) {
        this.userByCreationUser = userByCreationUser;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "Type", referencedColumnName = "Id", insertable = false, updatable = false)
    public Requesttype getRequesttypeByType() {
        return requesttypeByType;
    }

    public void setRequesttypeByType(Requesttype requesttypeByType) {
        this.requesttypeByType = requesttypeByType;
    }

    @ManyToOne
    @JoinColumn(name = "Status", referencedColumnName = "Id", insertable = false, updatable = false)
    public Requeststatus getRequeststatusByStatus() {
        return requeststatusByStatus;
    }

    public void setRequeststatusByStatus(Requeststatus requeststatusByStatus) {
        this.requeststatusByStatus = requeststatusByStatus;
    }
}
