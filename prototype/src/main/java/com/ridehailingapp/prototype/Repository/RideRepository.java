package com.ridehailingapp.prototype.Repository;

import com.ridehailingapp.prototype.entity.Rides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RideRepository extends JpaRepository<Rides, Long> {

}