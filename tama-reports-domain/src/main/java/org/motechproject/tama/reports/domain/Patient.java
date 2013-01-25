package org.motechproject.tama.reports.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
@Table(name = "patient")
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "patient_id")
    private String patientId;
    @NotNull
    @Column(name = "date_of_birth")
    private Date dateOfBirth;
    @NotBlank
    @Column(name = "gender")
    private String gender;
    @NotBlank
    @Column(name = "clinic_id")
    private String clinicId;
    @NotBlank
    @Column(name = "travel_time_to_clinic")
    private String travelTimeToClinic;
    @NotBlank
    @Column(name = "ivr_pass_code")
    private String ivrPassCode;
    @NotBlank
    @Column(name = "ivr_language")
    private String ivrLanguage;
    @NotBlank
    @Column(name = "call_preference")
    private String callPreference;
    @Column(name = "best_call_time")
    private String bestCallTime;
    @NotNull
    @Column(name = "receive_otc_advice")
    private Boolean receiveOTCAdvice;
    @NotNull
    @Column(name = "receive_appointment_reminder")
    private Boolean receiveAppointmentReminder;

    public boolean isValid() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Patient>> violations = validator.validate(this);
        return violations.isEmpty();
    }

    public void merge(Patient patient) {
        this.setBestCallTime(patient.getBestCallTime());
        this.setGender(patient.getGender());
        this.setCallPreference(patient.getCallPreference());
        this.setDateOfBirth(patient.getDateOfBirth());
        this.setClinicId(patient.getClinicId());
        this.setTravelTimeToClinic(patient.getTravelTimeToClinic());
        this.setReceiveOTCAdvice(patient.getReceiveOTCAdvice());
        this.setReceiveAppointmentReminder(patient.getReceiveAppointmentReminder());
        this.setIvrLanguage(patient.getIvrLanguage());
        this.setIvrPassCode(patient.getIvrPassCode());
    }
}
