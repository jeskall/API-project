package com.surfer.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AddWeatherRequest {

    private int waves;
    private String sharksType;
    private int temperature;
    private int wind;
    private Long beachId;

}
