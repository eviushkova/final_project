package org.stepik.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WishListModelRequest {

    private WishList wishList;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class WishList {

        public WishList(String course) {
            this.course = course;
        }

        private String course;
        @JsonProperty("create_date")
        private String createDate;
        private String platform = "web";
        private long user;
    }
}