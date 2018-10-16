package javache.constants;

public final class RequestConstants {

    public static final String ROOT_PAGE = "/";
    public static final String INDEX_PAGE_STATIC = "/index.html";
    public static final String INDEX_PAGE = "/index";
    public static final String LOGIN_PAGE_STATIC = "/login.html";
    public static final String LOGIN_PAGE = "/login";
    public static final String LOGOUT_PAGE = "/logout";
    public static final String REGISTER_PAGE_STATIC = "/register.html";
    public static final String REGISTER_PAGE = "/register";
    public static final String USER_PROFILE_PAGE = "/users/profile";
    public static final String USER_HOME_PAGE = "/home";

    public static final String RESOURCE_PATH = "casebook/";
    public static final String ASSETS_PATH = RESOURCE_PATH + "assets/";
    public static final String PAGES_PATH = RESOURCE_PATH + "pages/";

    public static final String PARAMETER_PASSWORD_CONFIRM = "passwordConfirm";
    public static final String PARAMETER_PASSWORD = "password";
    public static final String PARAMETER_EMAIL = "email";
    public static final String PLACEHOLDER_USERS = "${users}";
    public static final String FORMAT_USERS = "<p>%s<p/>";
    public static final String PLACEHOLDER_EMAIL = "${email}";
    public static final String PLACEHOLDER_PASSWORD = "${password}";
    public static final String EMPTY_STRING = "";

    private RequestConstants() {
    }
}
