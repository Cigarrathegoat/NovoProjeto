package br.com.homework.applicant.service;

import br.com.homework.applicant.repository.model.Applicant;

import java.util.List;

public interface IApplicantService {

    public Applicant applicantSaver(String firstName, String lastName, int age,
                                    double height, double weight, String ethnicity);

    public List<Applicant> findApplicantByFirstAndLastName(String firstName, String lastName);

    public List<Applicant> listAllApplicants();

    public Applicant applicantModifier(String firstNameFind, String lastNameFind, String firstName,
                                       String lastName, int age, double height, double weight,
                                       String ethnicity);

}
