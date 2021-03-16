package com.martin.urlshortener.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppProperties {
    private String redirectBaseUrl;
    private Integer maxLength;
}
