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
public class User implements Serializable {
    private Long id;
    private String name;
    @JsonIgnore
    private String password;
    private String userPhotoPath;
    private String email;
    private Byte isApprovedUser;
    private Timestamp creationDate;
    private Timestamp modifyDate;
    private Byte isDeleted;
    private Integer status;
    private Integer region;
    private Collection<Auto> autosById;
    private Collection<Message> messagesById;
    private Collection<Request> requestsById;
    private Collection<Request> requestsById_0;
    private Collection<Session> sessionsById;
    private Collection<Tool> toolsById;
    private Userstatus userstatusByStatus;
    private Region regionByRegion;

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
    @Column(name = "Password", nullable = false, length = 50)
    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "UserPhotoPath", nullable = true, length = 100)
    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    @Basic
    @Column(name = "Email", nullable = true, length = 80)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "IsApprovedUser", nullable = true)
    public Byte getIsApprovedUser() {
        return isApprovedUser;
    }

    public void setIsApprovedUser(Byte isApprovedUser) {
        this.isApprovedUser = isApprovedUser;
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
    @Column(name = "IsDeleted", nullable = true)
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Basic
    @Column(name = "Status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "Region", nullable = true)
    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userPhotoPath != null ? !userPhotoPath.equals(user.userPhotoPath) : user.userPhotoPath != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (isApprovedUser != null ? !isApprovedUser.equals(user.isApprovedUser) : user.isApprovedUser != null)
            return false;
        if (creationDate != null ? !creationDate.equals(user.creationDate) : user.creationDate != null) return false;
        if (modifyDate != null ? !modifyDate.equals(user.modifyDate) : user.modifyDate != null) return false;
        if (isDeleted != null ? !isDeleted.equals(user.isDeleted) : user.isDeleted != null) return false;
        if (status != null ? !status.equals(user.status) : user.status != null) return false;
        if (region != null ? !region.equals(user.region) : user.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userPhotoPath != null ? userPhotoPath.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (isApprovedUser != null ? isApprovedUser.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByUser")
    public Collection<Auto> getAutosById() {
        return autosById;
    }

    public void setAutosById(Collection<Auto> autosById) {
        this.autosById = autosById;
    }

    @OneToMany(mappedBy = "userByCreateUser")
    public Collection<Message> getMessagesById() {
        return messagesById;
    }

    public void setMessagesById(Collection<Message> messagesById) {
        this.messagesById = messagesById;
    }

    @OneToMany(mappedBy = "userByUser")
    public Collection<Request> getRequestsById() {
        return requestsById;
    }

    public void setRequestsById(Collection<Request> requestsById) {
        this.requestsById = requestsById;
    }

    @OneToMany(mappedBy = "userByCreationUser")
    public Collection<Request> getRequestsById_0() {
        return requestsById_0;
    }

    public void setRequestsById_0(Collection<Request> requestsById_0) {
        this.requestsById_0 = requestsById_0;
    }

    @OneToMany(mappedBy = "userByUser")
    public Collection<Session> getSessionsById() {
        return sessionsById;
    }

    public void setSessionsById(Collection<Session> sessionsById) {
        this.sessionsById = sessionsById;
    }

    @OneToMany(mappedBy = "userByUser")
    public Collection<Tool> getToolsById() {
        return toolsById;
    }

    public void setToolsById(Collection<Tool> toolsById) {
        this.toolsById = toolsById;
    }

    @ManyToOne
    @JoinColumn(name = "Status", referencedColumnName = "Id", insertable = false, updatable = false)
    public Userstatus getUserstatusByStatus() {
        return userstatusByStatus;
    }

    public void setUserstatusByStatus(Userstatus userstatusByStatus) {
        this.userstatusByStatus = userstatusByStatus;
    }

    @ManyToOne
    @JoinColumn(name = "Region", referencedColumnName = "Id", insertable = false, updatable = false)
    public Region getRegionByRegion() {
        return regionByRegion;
    }

    public void setRegionByRegion(Region regionByRegion) {
        this.regionByRegion = regionByRegion;
    }
}
