package com.example.demoBeans.component;

import lombok.ToString;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myBean")
@ToString
@Lazy
@Scope("prototype")
public class MyBean {
}
