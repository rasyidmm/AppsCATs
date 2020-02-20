package com.catdemo.demo.repository;

import com.catdemo.demo.entity.MenuPrevillageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MenuPrevillageRepository  extends JpaRepository<MenuPrevillageEntity, UUID> {
}
