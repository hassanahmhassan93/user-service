package com.example.model;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
public class UserReqModel {

    @NotBlank
    private String name;

    @NotBlank
    private String mobile;

    @NotBlank
    private String email;
}
