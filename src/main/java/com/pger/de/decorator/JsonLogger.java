package com.pger.de.decorator;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

public class JsonLogger extends DecoratorLogger {

    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String s) {
        JSONObject jsonObject = composeJsonResult();
        jsonObject.put("MESSAGE", s);
        logger.info(jsonObject.toString());
    }

    @Override
    public void debug(String s) {
        logger.debug(s);
    }

    @Override
    public void warn(String s) {
        logger.warn(s);
    }

    @Override
    public void error(String s) {
        JSONObject jsonObject = composeJsonResult();
        jsonObject.put("exception", s);
        logger.error(jsonObject.toString());
    }


    @Override
    public void debug(String s, Object o) {
        super.debug(s, o);
    }


    private JSONObject composeJsonResult() {
        JSONObject result = new JSONObject();
        result.put("msg", "信息");
        return result;
    }

}
