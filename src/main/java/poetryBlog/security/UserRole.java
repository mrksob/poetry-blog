package poetryBlog.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static poetryBlog.security.UserPermission.USER_READ;
import static poetryBlog.security.UserPermission.USER_WRITE;

public enum UserRole {

    USER(Sets.newHashSet(USER_READ , USER_WRITE)) ;

    private Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {

        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions()
                .stream()
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.getPermission()))
                .collect(Collectors.toSet());

        permissions.add(new SimpleGrantedAuthority("ROLE " + this.name()));
        return permissions;
    }
}
