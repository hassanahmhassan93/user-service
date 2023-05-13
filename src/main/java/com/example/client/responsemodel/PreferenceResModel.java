package com.example.client.responsemodel;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Introspected
public class PreferenceResModel {

    private int id;

    private int userId;

    private String locale;

    private String diet;

    private boolean notifyOff;
}
