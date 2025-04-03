package org.ieselcaminas.jpa.repository;

import org.ieselcaminas.jpa.entity.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Long> {
}