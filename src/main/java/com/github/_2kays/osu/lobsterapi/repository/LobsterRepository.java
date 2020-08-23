package com.github._2kays.osu.lobsterapi.repository;

import com.github._2kays.osu.lobsterapi.model.Lobster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LobsterRepository<T extends Lobster> extends JpaRepository<T, Long>, JpaSpecificationExecutor<Lobster> {
}

