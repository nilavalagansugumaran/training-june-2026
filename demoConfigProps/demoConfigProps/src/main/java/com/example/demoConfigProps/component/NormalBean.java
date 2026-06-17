package com.example.demoConfigProps.component;

import lombok.ToString;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@ToString
@Profile("local")
public class NormalBean implements SimpleBean {
}
