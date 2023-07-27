package org.stepik.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LanguageModelRequest {

    private Profile profile;

    public enum Language {
        PORTUGUESE("pt"),
        ENGLISH("en"),
        RUSSIAN("ru");
        @JsonValue
        private String value;

        Language(String value) {
            this.value = value;
        }
    }
}