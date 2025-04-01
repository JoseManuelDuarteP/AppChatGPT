package org.ieselcaminas.jpa.repository;


import org.ieselcaminas.jpa.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PropietarioRepository extends JpaRepository<Propietario, Long> {}