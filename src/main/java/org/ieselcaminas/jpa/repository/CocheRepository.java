package org.ieselcaminas.jpa.repository;

import org.ieselcaminas.jpa.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
    List<Coche> findByMarca(String marca);
}