package korotaev.Managers.Region;

import korotaev.Entity.Message;
import korotaev.Entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionManagers extends CrudRepository<Region, Long> {
    List<Region> findAll();
}
