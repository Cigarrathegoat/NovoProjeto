package br.com.homework.applicant.repository.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Applicant {

    private String firstName;

    private String lastName;

    private int age;

    private double height;

    private double weight;

    private String ethnicity;


}
