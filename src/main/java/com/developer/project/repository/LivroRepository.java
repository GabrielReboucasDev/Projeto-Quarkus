package com.developer.project.repository;

import com.developer.project.entity.LivroEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LivroRepository implements PanacheRepositoryBase<LivroEntity, Integer> {
}
