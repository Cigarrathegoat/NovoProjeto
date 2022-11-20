package br.com.homework.applicant.api;

import br.com.homework.applicant.api.dto.ApplicantListResponseDTO;
import br.com.homework.applicant.service.IApplicantService;
import br.com.homework.applicant.api.dto.SingleApplicantResponseDTO;
import br.com.homework.applicant.repository.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applicant")
public class ApplicantAPI {

    @Autowired
    private IApplicantService applicantService;

    @PostMapping ("/new")
    public SingleApplicantResponseDTO addWithBody(@RequestBody Applicant applicant){
        System.out.println("git send test");
        return SingleApplicantResponseDTO.builder()
                .result(applicantService.applicantSaver(applicant.getFirstName(),
                        applicant.getLastName(), applicant.getAge(), applicant.getHeight(),
                        applicant.getWeight(), applicant.getEthnicity()))
                .build();
    }

    @GetMapping("/find/{firstName}/{lastName}")
    public ApplicantListResponseDTO find(@PathVariable("firstName") String firstName,
                                         @PathVariable("lastName") String lastName) {
        return ApplicantListResponseDTO.builder()
                .data(applicantService.findApplicantByFirstAndLastName(firstName, lastName))
                .build();
    }
    @GetMapping("/list")
    public ApplicantListResponseDTO listAllApplicants(){
        return ApplicantListResponseDTO.builder()
                .data(applicantService.listAllApplicants())
                .build();
    }
    @PutMapping("/change/{firstNameFind}/{lastNameFind}")
    public SingleApplicantResponseDTO change(@PathVariable("firstNameFind") String firstNameFind,
                                           @PathVariable("lastNameFind") String lastNameFind,
                                           String firstName, String lastName, int age,
                                           double height, double weight, String ethnicity){
        return SingleApplicantResponseDTO.builder()
                .result(applicantService.applicantModifier(firstNameFind, lastNameFind, firstName,
                        lastName, age, height, weight, ethnicity))
                .build();
    }

}
