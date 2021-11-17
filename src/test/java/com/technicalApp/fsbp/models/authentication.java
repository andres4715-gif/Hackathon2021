package com.technicalApp.fsbp.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class authentication {
    private String userName;
    private String userParam;
    private String countryCode;
    private boolean rememberMe;
}
