package com.digitalholics.iotheraphy.Security.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.digitalholics.iotheraphy.Security.User.Permission.*;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_CREATE,
                    ADMIN_DELETE,
                    USER_READ,
                    PATIENT_READ,
                    PATIENT_UPDATE,
                    PATIENT_CREATE,
                    PATIENT_DELETE,
                    PHYSIOTHERAPIST_READ,
                    PHYSIOTHERAPIST_UPDATE,
                    PHYSIOTHERAPIST_CREATE,
                    PHYSIOTHERAPIST_DELETE
            )
    ),
    USER(
            Set.of(
                    USER_READ
            )
    ),
    PATIENT(
            Set.of(
                    PATIENT_READ,
                    PATIENT_UPDATE,
                    PATIENT_CREATE,
                    PATIENT_DELETE
            )
    ),
    PHYSIOTHERAPIST(
            Set.of(
                    PHYSIOTHERAPIST_READ,
                    PHYSIOTHERAPIST_UPDATE,
                    PHYSIOTHERAPIST_CREATE,
                    PHYSIOTHERAPIST_DELETE
            )
    )

    ;

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
       var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
       authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
       return authorities;
    }

}
