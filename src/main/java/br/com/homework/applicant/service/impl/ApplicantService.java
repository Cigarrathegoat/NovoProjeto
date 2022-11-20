package br.com.homework.applicant.service.impl;

import br.com.homework.applicant.repository.IApplicantRepository;
import br.com.homework.applicant.service.IApplicantService;
import br.com.homework.applicant.repository.model.Applicant;
import br.com.homework.applicant.log.ApplicantPrompt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService implements IApplicantService {

    @Autowired
    private IApplicantRepository applicantRepository;

    private ApplicantPrompt applicantPrompt = new ApplicantPrompt();

    public Applicant applicantSaver(String firstName, String lastName, int age,
                                    double height, double weight, String ethnicity) {
        if (age >= 18) {
            Applicant applicant = Applicant.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .age(age)
                    .height(height)
                    .weight(weight)
                    .ethnicity(ethnicity)
                    .build();

            applicantRepository.applicantSave(applicant);
            applicantPrompt.enteredSuccessfully();

            return applicant;
        } else {
            applicantPrompt.tooYoung();
        }
        return null;
    }

    public List<Applicant> findApplicantByFirstAndLastName(String firstName, String lastName) {
        List<Applicant> applicantsFind = applicantRepository.findApplicantByName(firstName, lastName);
        if (applicantsFind != null) {
            System.out.println(applicantsFind.toString());
        } else {
            applicantPrompt.noneFound();
        }
        return applicantsFind;
    }

    public List<Applicant> listAllApplicants() {
        return applicantRepository.listAllApplicants();
    }

    public Applicant applicantModifier(String firstNameFind, String lastNameFind, String firstName,
                                       String lastName, int age, double height, double weight,
                                       String ethnicity){
        Applicant applicantChange = applicantRepository
                .findOneApplicantByName(firstNameFind, lastNameFind);

        applicantChange.setFirstName(firstName);
        applicantChange.setLastName(lastName);
        applicantChange.setAge(age);
        applicantChange.setHeight(height);
        applicantChange.setWeight(weight);
        applicantChange.setEthnicity(ethnicity);

        applicantRepository.applicantSave(applicantChange);
        return applicantChange;
    }
}
