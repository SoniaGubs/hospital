package com.academy.hospital.converter;

import com.academy.hospital.dto.DiagnosisDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToDiagnosesDtoConverter implements Converter<String, DiagnosisDto> {


    @Override
    public DiagnosisDto convert(String source) {
        DiagnosisDto diagnosesDto = new DiagnosisDto();

        String[] parts = source.split(",");

        String[] partsValues1 = parts[0].split("=");
        String[] partsValues2 = parts[1].split("=");
        String[] partsValues3 = parts[2].split("=");

        diagnosesDto.setId(Integer.valueOf(partsValues1[1]));
        diagnosesDto.setCode(partsValues2[1]);
        diagnosesDto.setDiagnosisName(partsValues3[1]);

        return diagnosesDto;
    }
}
