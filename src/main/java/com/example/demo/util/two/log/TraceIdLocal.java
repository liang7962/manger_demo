package com.example.demo.util.two.log;

public class TraceIdLocal {
    private static final ThreadLocal traceIdLocal = new ThreadLocal();


    public static void setId(String traceId) {
        traceIdLocal.set(traceId);
    }

    public static String getId() {
        return (String) traceIdLocal.get();
    }
}
