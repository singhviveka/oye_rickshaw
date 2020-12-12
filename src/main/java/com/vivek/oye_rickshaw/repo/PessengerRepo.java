package com.vivek.oye_rickshaw.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.vivek.oye_rickshaw.model.Pessenger;

@Component
public interface PessengerRepo extends JpaRepository<Pessenger, Integer>{

}
