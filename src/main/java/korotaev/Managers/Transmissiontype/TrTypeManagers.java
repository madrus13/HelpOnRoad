package korotaev.Managers.Transmissiontype;

import korotaev.Entity.TransmissionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrTypeManagers extends CrudRepository<TransmissionType, Long> {
    List<TransmissionType> findAll();
}
