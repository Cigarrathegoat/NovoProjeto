package br.com.homework.applicant.log;

public class ApplicantPrompt {

    public void enteredSuccessfully(){
        System.out.println("Applicant entered successfully!");
    }
    public void tooYoung(){
        System.out.println("Sorry, only people 18 years old and over can apply!");
    }
    public void noneFound(){
        System.out.println("Sorry, there is no one by that name in our records!");
    }
}
