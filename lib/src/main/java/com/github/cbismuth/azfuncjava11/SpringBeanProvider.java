package com.github.cbismuth.azfuncjava11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public final class SpringBeanProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBeanProvider.class);

    private static final SpringBeanProvider INSTANCE = new SpringBeanProvider();

    public static <T> T getBean(final Class<T> beanClass) {
        return INSTANCE.applicationContext.getBean(beanClass);
    }

    public static void close() {
        INSTANCE.applicationContext.close();
    }

    private final AnnotationConfigApplicationContext applicationContext;

    private SpringBeanProvider() {
        try {
            applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

            Runtime.getRuntime().addShutdownHook(new Thread(SpringBeanProvider::close));
        } catch (final Throwable e) {
            LOGGER.error(e.getMessage(), e);

            throw new RuntimeException(e);
        }
    }
}
