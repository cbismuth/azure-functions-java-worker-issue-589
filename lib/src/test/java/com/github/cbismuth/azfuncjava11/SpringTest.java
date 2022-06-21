package com.github.cbismuth.azfuncjava11;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SpringTest {

    @Autowired
    private Environment environment;

    @Test
    public void testPropertyLoading() {
        Assertions.assertThat(environment.getProperty("foo")).isEqualTo("bar");
    }
}
