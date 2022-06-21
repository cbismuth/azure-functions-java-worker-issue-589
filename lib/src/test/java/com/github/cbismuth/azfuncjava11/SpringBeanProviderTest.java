package com.github.cbismuth.azfuncjava11;

import org.assertj.core.api.Assertions;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.core.env.Environment;

public class SpringBeanProviderTest {

    @AfterClass
    public static void closeSpringContext() {
        SpringBeanProvider.close();
    }

    @Test
    public void testPropertyLoading() {
        final Environment environment = SpringBeanProvider.getBean(Environment.class);

        Assertions.assertThat(environment).isNotNull();
        Assertions.assertThat(environment.getProperty("foo")).isEqualTo("bar");
    }
}
