package korotaev.Models.Md;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {
    private int id;
    private String text;
    private Timestamp creationDate;
    private Timestamp modifyDate;
    private Integer createUser;
    private String messagePhotoPath;
    private Byte isDeleted;
    private Integer request;
    private Integer type;
    private Integer region;
    private User userByCreateUser;
    private Request requestByRequest;
    private Messagetype messagetypeByType;
    private Region regionByRegion;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Text", nullable = true, length = 255)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
    @Column(name = "ModifyDate", nullable = true)
    public Timestamp getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Timestamp modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Basic
    @Column(name = "CreateUser", nullable = true)
    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    @Basic
    @Column(name = "MessagePhotoPath", nullable = true, length = 100)
    public String getMessagePhotoPath() {
        return messagePhotoPath;
    }

    public void setMessagePhotoPath(String messagePhotoPath) {
        this.messagePhotoPath = messagePhotoPath;
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
    @Column(name = "Request", nullable = true)
    public Integer getRequest() {
        return request;
    }

    public void setRequest(Integer request) {
        this.request = request;
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

        Message message = (Message) o;

        if (id != message.id) return false;
        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        if (creationDate != null ? !creationDate.equals(message.creationDate) : message.creationDate != null)
            return false;
        if (modifyDate != null ? !modifyDate.equals(message.modifyDate) : message.modifyDate != null) return false;
        if (createUser != null ? !createUser.equals(message.createUser) : message.createUser != null) return false;
        if (messagePhotoPath != null ? !messagePhotoPath.equals(message.messagePhotoPath) : message.messagePhotoPath != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(message.isDeleted) : message.isDeleted != null) return false;
        if (request != null ? !request.equals(message.request) : message.request != null) return false;
        if (type != null ? !type.equals(message.type) : message.type != null) return false;
        if (region != null ? !region.equals(message.region) : message.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (modifyDate != null ? modifyDate.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (messagePhotoPath != null ? messagePhotoPath.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (request != null ? request.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CreateUser", referencedColumnName = "Id")
    public User getUserByCreateUser() {
        return userByCreateUser;
    }

    public void setUserByCreateUser(User userByCreateUser) {
        this.userByCreateUser = userByCreateUser;
    }

    @ManyToOne
    @JoinColumn(name = "Request", referencedColumnName = "Id")
    public Request getRequestByRequest() {
        return requestByRequest;
    }

    public void setRequestByRequest(Request requestByRequest) {
        this.requestByRequest = requestByRequest;
    }

    @ManyToOne
    @JoinColumn(name = "Type", referencedColumnName = "Id")
    public Messagetype getMessagetypeByType() {
        return messagetypeByType;
    }

    public void setMessagetypeByType(Messagetype messagetypeByType) {
        this.messagetypeByType = messagetypeByType;
    }

    @ManyToOne
    @JoinColumn(name = "Region", referencedColumnName = "Id")
    public Region getRegionByRegion() {
        return regionByRegion;
    }

    public void setRegionByRegion(Region regionByRegion) {
        this.regionByRegion = regionByRegion;
    }
}
