package com.pger.de.decorator;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;

public class JsonLogger extends DecoratorLogger {
    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String s) {
        JSONObject jsonObject = composeBasicJsonResult();
        jsonObject.put("MESSAGE", s);
        super.info(jsonObject.toString());
    }

    @Override
    public void debug(String s) {
        super.debug(s);
    }

    @Override
    public void warn(String s) {
        super.warn(s);
    }

    @Override
    public void error(String s) {
        JSONObject jsonObject = composeBasicJsonResult();
        jsonObject.put("EXCEPTION", s);
        super.error(jsonObject.toString());
    }

    @Override
    public void trace(String s) {
        super.trace(s);
    }

    @Override
    public void trace(Marker marker, String s) {
        super.trace(marker, s);
    }

    @Override
    public void trace(Marker marker, String s, Object o) {
        super.trace(marker, s, o);
    }

    @Override
    public void trace(Marker marker, String s, Object o, Object o1) {
        super.trace(marker, s, o, o1);
    }

    @Override
    public void trace(Marker marker, String s, Object... objects) {
        super.trace(marker, s, objects);
    }

    @Override
    public void trace(Marker marker, String s, Throwable throwable) {
        super.trace(marker, s, throwable);
    }

    @Override
    public void trace(String s, Object o) {
        super.trace(s, o);
    }

    @Override
    public void trace(String s, Object o, Object o1) {
        super.trace(s, o, o1);
    }

    @Override
    public void trace(String s, Object... objects) {
        super.trace(s, objects);
    }

    @Override
    public void trace(String s, Throwable throwable) {
        super.trace(s, throwable);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return super.isTraceEnabled();
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return super.isTraceEnabled(marker);
    }

    @Override
    public boolean isDebugEnabled() {
        return super.isDebugEnabled();
    }

    @Override
    public void debug(String s, Object o) {
        super.debug(s, o);
    }

    @Override
    public void debug(String s, Object o, Object o1) {
        super.debug(s, o, o1);
    }

    @Override
    public void debug(String s, Object... objects) {
        super.debug(s, objects);
    }

    @Override
    public void debug(String s, Throwable throwable) {
        super.debug(s, throwable);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return super.isDebugEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String s) {
        super.debug(marker, s);
    }

    @Override
    public void debug(Marker marker, String s, Object o) {
        super.debug(marker, s, o);
    }

    @Override
    public void debug(Marker marker, String s, Object o, Object o1) {
        super.debug(marker, s, o, o1);
    }

    @Override
    public void debug(Marker marker, String s, Object... objects) {
        super.debug(marker, s, objects);
    }

    @Override
    public void debug(Marker marker, String s, Throwable throwable) {
        super.debug(marker, s, throwable);
    }

    @Override
    public boolean isInfoEnabled() {
        return super.isInfoEnabled();
    }

    @Override
    public void info(String s, Object o) {
        super.info(s, o);
    }

    @Override
    public void info(String s, Object o, Object o1) {
        super.info(s, o, o1);
    }

    @Override
    public void info(String s, Object... objects) {
        super.info(s, objects);
    }

    @Override
    public void info(String s, Throwable throwable) {
        super.info(s, throwable);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return super.isInfoEnabled(marker);
    }

    @Override
    public void info(Marker marker, String s) {
        super.info(marker, s);
    }

    @Override
    public void info(Marker marker, String s, Object o) {
        super.info(marker, s, o);
    }

    @Override
    public void info(Marker marker, String s, Object o, Object o1) {
        super.info(marker, s, o, o1);
    }

    @Override
    public void info(Marker marker, String s, Object... objects) {
        super.info(marker, s, objects);
    }

    @Override
    public void info(Marker marker, String s, Throwable throwable) {
        super.info(marker, s, throwable);
    }

    @Override
    public boolean isWarnEnabled() {
        return super.isWarnEnabled();
    }

    @Override
    public void warn(String s, Object o) {
        super.warn(s, o);
    }

    @Override
    public void warn(String s, Object... objects) {
        super.warn(s, objects);
    }

    @Override
    public void warn(String s, Object o, Object o1) {
        super.warn(s, o, o1);
    }

    @Override
    public void warn(String s, Throwable throwable) {
        super.warn(s, throwable);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return super.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String s) {
        super.warn(marker, s);
    }

    @Override
    public void warn(Marker marker, String s, Object o) {
        super.warn(marker, s, o);
    }

    @Override
    public void warn(Marker marker, String s, Object o, Object o1) {
        super.warn(marker, s, o, o1);
    }

    @Override
    public void warn(Marker marker, String s, Object... objects) {
        super.warn(marker, s, objects);
    }

    @Override
    public void warn(Marker marker, String s, Throwable throwable) {
        super.warn(marker, s, throwable);
    }

    @Override
    public boolean isErrorEnabled() {
        return super.isErrorEnabled();
    }

    @Override
    public void error(String s, Object o) {
        super.error(s, o);
    }

    @Override
    public void error(String s, Object o, Object o1) {
        super.error(s, o, o1);
    }

    @Override
    public void error(String s, Object... objects) {
        super.error(s, objects);
    }

    @Override
    public void error(String s, Throwable throwable) {
        super.error(s, throwable);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return super.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String s) {
        super.error(marker, s);
    }

    @Override
    public void error(Marker marker, String s, Object o) {
        super.error(marker, s, o);
    }

    @Override
    public void error(Marker marker, String s, Object o, Object o1) {
        super.error(marker, s, o, o1);
    }

    @Override
    public void error(Marker marker, String s, Object... objects) {
        super.error(marker, s, objects);
    }

    @Override
    public void error(Marker marker, String s, Throwable throwable) {
        super.error(marker, s, throwable);
    }

    private JSONObject composeBasicJsonResult() {
        JSONObject result = new JSONObject();
        result.put("msg", "信息");
        return result;
    }

    public static class JsonLoggerFactory {
        public static JsonLogger getLogger(Class clazz) {
            Logger logger = LoggerFactory.getLogger(clazz);
            return new JsonLogger(logger);
        }
    }


}
