package com.huilian.user.config;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author admin
 */
@Configuration
public class FeignDecoder implements Decoder {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    private static final Logger logger = LoggerFactory.getLogger(FeignDecoder.class);

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {

        Object object = new SpringDecoder(messageConverters).decode(response, type);

        logger.info("Feign返回：{}", object);
        return object;
    }
}
