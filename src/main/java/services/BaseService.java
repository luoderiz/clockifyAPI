package services;

import com.crowdar.api.rest.MethodsService;

public class BaseService extends MethodsService {

    public static final ThreadLocal<String> API_KEY = new ThreadLocal<>();

    public static final ThreadLocal<String> ID_WORKSPACE = new ThreadLocal<>();

    public static final ThreadLocal<String> ID_PROJECT = new ThreadLocal<>();

}
