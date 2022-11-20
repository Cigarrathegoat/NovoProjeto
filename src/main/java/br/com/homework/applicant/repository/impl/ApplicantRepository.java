package br.com.homework.applicant.repository.impl;

import br.com.homework.applicant.repository.IApplicantRepository;
import br.com.homework.applicant.repository.model.Applicant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ApplicantRepository implements IApplicantRepository {


    private List<Applicant> applicants = new ArrayList<>();

    private static ApplicantRepository instance;

    public ApplicantRepository() {
    }

    public static ApplicantRepository getInstance() {
        if (instance == null) {
            instance = new ApplicantRepository();
        }
        return instance;
    }

    public void applicantSave(Applicant applicant) {
        applicants.add(applicant);
    }

    public List<Applicant> findApplicantByName(String firstName, String lastName) {
        List<Applicant> allResults = new ArrayList<>();
        for (Applicant applicantFind : applicants) {
            if (applicantFind.getFirstName().equalsIgnoreCase(firstName)
            && applicantFind.getLastName().equalsIgnoreCase(lastName)) {
                allResults.add(applicantFind);
            }
        }
        return allResults;

    }

    public Applicant findOneApplicantByName(String firstName, String lastName){
        for (Applicant applicantFind : applicants) {
            if (applicantFind.getFirstName().equalsIgnoreCase(firstName)
            && applicantFind.getLastName().equalsIgnoreCase(lastName)){
                return applicantFind;
            }
        }
        return null;
    }

    public List<Applicant> listAllApplicants() {
        return applicants;
    }



}
