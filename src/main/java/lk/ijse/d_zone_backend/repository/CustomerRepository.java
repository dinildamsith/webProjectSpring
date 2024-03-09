package lk.ijse.d_zone_backend.repository;

import lk.ijse.d_zone_backend.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,String> {
}
