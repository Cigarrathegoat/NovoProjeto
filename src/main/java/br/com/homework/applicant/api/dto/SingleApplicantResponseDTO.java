package br.com.homework.applicant.api.dto;

import br.com.homework.applicant.repository.model.Applicant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SingleApplicantResponseDTO {

    private Applicant result;
}

