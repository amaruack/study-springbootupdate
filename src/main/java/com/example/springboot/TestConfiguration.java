package com.example.springboot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.util.unit.DataSize;

@Getter
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties(prefix = "test")
public class TestConfiguration {
    String key1;
    Integer key2;
    DataSize dataSize;
}
