package poetryBlog.security;

public enum UserPermission {
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
