package com.screenplay.project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BuyerData {

    private final String firstName;
    private final String lastName;
    private final String postalCode;
}