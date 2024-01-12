
package com.Airbus.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Airbus.entity.Location;
public interface LocationDao extends JpaRepository<Location, Long>{
}
