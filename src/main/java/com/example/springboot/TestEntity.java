package com.example.springboot;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Builder
@Table(name = "TEST_ENTITY")
public class TestEntity {

    @Id
//    @GeneratedValue
    Long id ;

    String title;

    String name;

}
