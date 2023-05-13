package com.example.model;

import com.example.client.responsemodel.PreferenceResModel;
import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
public class UserResModel {

    private int id;

    private String name;

    private String mobile;

    private String email;

    private PreferenceResModel preferenceResModel;
}
