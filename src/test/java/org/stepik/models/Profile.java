package org.stepik.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.stepik.models.LanguageModelRequest.Language;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Profile {

    public Profile(Language language) {
        this.language = language;
    }

    private Language language;
    @JsonProperty("last_name")
    private String lastName = "Вьюшкова";
    @JsonProperty("first_name")
    private String firstName = "Елена";
}
