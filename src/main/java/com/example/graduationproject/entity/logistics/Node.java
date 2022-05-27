package com.example.graduationproject.entity.logistics;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node {
    private int id;
    private double lon;
    private double lat;
}
