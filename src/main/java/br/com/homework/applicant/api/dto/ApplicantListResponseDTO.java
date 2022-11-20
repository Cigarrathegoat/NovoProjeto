package br.com.homework.applicant.api.dto;

import br.com.homework.applicant.repository.model.Applicant;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApplicantListResponseDTO {

    private List<Applicant> data;
}
