package ru.Entity;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.transaction.annotation.Transactional;
import ru.Entity.AndroidAnnotation.DatabaseField;
import ru.Entity.AndroidAnnotation.DatabaseTable;
import ru.Entity.AndroidAnnotation.ForeignCollectionField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity(name = "tooltypes")
@Table(name = "tooltypes")
@Transactional
@JsonIgnoreProperties(value = { "handler", "hibernateLazyInitializer" })
@DatabaseTable
public class Tooltypes implements Serializable {
    @DatabaseField(generatedId = true)
    private Long id;
    @DatabaseField
    private String name;
    @DatabaseField
    private Byte isDeleted;
    @JsonIgnore
    @ForeignCollectionField
    private Collection<Tool> toolsById;

    public Tooltypes() {
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

        Tooltypes tooltypes = (Tooltypes) o;

        if (id != tooltypes.id) return false;
        if (name != null ? !name.equals(tooltypes.name) : tooltypes.name != null) return false;
        if (isDeleted != null ? !isDeleted.equals(tooltypes.isDeleted) : tooltypes.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "tooltypesByType")
    @JsonIgnore
    public Collection<Tool> getToolsById() {
        return toolsById;
    }

    public void setToolsById(Collection<Tool> toolsById) {
        this.toolsById = toolsById;
    }
}
