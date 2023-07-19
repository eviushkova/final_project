package org.stepik.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {

    public Profile(LanguageModelRequest.Language language) {
        this.language = language;
    }

    LanguageModelRequest.Language language;
    @JsonProperty("last_name")
    String lastName = "Вьюшкова";
    @JsonProperty("first_name")
    String firstName = "Елена";
}
