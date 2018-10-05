package com.bbs.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name="user")
public class User implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name="user_id", length=10)
  private String id;

  @ManyToOne
  @JoinColumn(name="role_id", nullable=false)
  private Role role;

  @Column(nullable=false, length=100)
  private String password;

  @Column(name = "username")
  private String userName;

  @Column(name = "phone")
  private String phone;

  @Column(name = "gender")
  private String gender;

  @Column(name = "email")
  private String email;

  @Override
  public String getUsername() {
    return id;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return AuthorityUtils.createAuthorityList(role.getAuthority());
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
