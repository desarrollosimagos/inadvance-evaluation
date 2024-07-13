package org.inadvance.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
public class PhoneDTO {
    @ApiModelProperty(notes = "The Phone number", example = "937836233")
    private String number;
    @ApiModelProperty(notes = "The Phone cityCode", example = "99")
    private String cityCode;
    @ApiModelProperty(notes = "The Phone cityCode", example = "56")
    private String countryCode;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

}
