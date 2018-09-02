package ru.Managers.Region;

import ru.Entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionManagers extends CrudRepository<Region, Long> {
    List<Region> findAllByIsDeleted(Byte IsDeleted);
}
