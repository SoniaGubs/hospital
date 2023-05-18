package com.academy.hospital.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiagnosisDto {

    private Integer id;
    private String code;
    private String diagnosisName;

    @Override
    public String toString() {
        return  "id=" + id +
                ",code=" + code + ",diagnosisName=" + diagnosisName;
    }
}
