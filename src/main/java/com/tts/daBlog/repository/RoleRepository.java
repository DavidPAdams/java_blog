package com.tts.daBlog.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.daBlog.model.Role;

public interface RoleRepository
    extends CrudRepository<Role, Long> {
  public Role findByRole(String role);
}
