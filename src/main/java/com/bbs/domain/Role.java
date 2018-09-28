package com.bbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name="role")
public class Role implements GrantedAuthority{

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="role_id", length=30)
  private String id;

  @Override
  public String getAuthority() {
    return id;
  }

}
