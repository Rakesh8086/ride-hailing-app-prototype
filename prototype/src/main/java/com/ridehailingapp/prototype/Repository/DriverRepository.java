package com.ridehailingapp.prototype.Repository;

import com.ridehailingapp.prototype.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    List<Driver> findByIsAvailableTrue();
}