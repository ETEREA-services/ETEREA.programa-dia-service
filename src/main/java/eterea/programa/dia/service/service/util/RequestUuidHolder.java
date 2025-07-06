package eterea.programa.dia.service.service.util;

import org.springframework.lang.Nullable;

public final class RequestUuidHolder {

    private static final ThreadLocal<String> requestUuid = new ThreadLocal<>();

    private RequestUuidHolder() {
    }

    public static void clear() {
        requestUuid.remove();
    }

    public static void set(String uuid) {
        requestUuid.set(uuid);
    }

    @Nullable
    public static String get() {
        return requestUuid.get();
    }

}
