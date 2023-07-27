package org.stepik.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishListModelResponse {

    @JsonProperty("wish-lists")
    private List<WishList> wishLists;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WishList {
        private Long id;
        private Long user;
        private Long course;
        @JsonProperty("create_date")
        private String createDate;
        private String platform;
    }
}
