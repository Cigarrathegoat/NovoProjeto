package br.com.homework.applicant.repository;

import br.com.homework.applicant.repository.model.Applicant;

import java.util.List;

public interface IApplicantRepository {

    public void applicantSave(Applicant applicant);

    public List<Applicant> findApplicantByName(String firstName, String lastName);

    public List<Applicant> listAllApplicants();

    public Applicant findOneApplicantByName(String firstName, String lastName);

}
