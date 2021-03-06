package org.motechproject.tama.reports.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.Set;

import static org.apache.commons.lang.StringUtils.isNotBlank;

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
    @NotBlank
    @Column(name = "patient_document_id")
    private String patientDocumentId;
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
    @Column(name = "morning_pill_time")
    private Time morningPillTime;
    @Column(name = "evening_pill_time")
    private Time eveningPillTime;
    @Column(name = "best_call_time")
    private Time bestCallTime;
    @Column(name = "day_of_weekly_call")
    private String dayOfWeeklyCall;
    @NotNull
    @Column(name = "receive_otc_advice")
    private Boolean receiveOTCAdvice;
    @NotNull
    @Column(name = "receive_appointment_reminder")
    private Boolean receiveAppointmentReminder;
    @Column(name = "complete")
    private Boolean complete;

    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;

    public boolean isValid() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Patient>> violations = validator.validate(this);
        return violations.isEmpty();
    }

    public void merge(Patient patient) {
        this.setBestCallTime(patient.getBestCallTime());
        this.setDayOfWeeklyCall(patient.getDayOfWeeklyCall());
        this.setPatientDocumentId(patient.getPatientDocumentId());
        this.setGender(patient.getGender());
        this.setCallPreference(patient.getCallPreference());
        this.setDateOfBirth(patient.getDateOfBirth());
        this.setClinicId(patient.getClinicId());
        this.setNotes(patient.getNotes());
        this.setTravelTimeToClinic(patient.getTravelTimeToClinic());
        this.setReceiveOTCAdvice(patient.getReceiveOTCAdvice());
        this.setReceiveAppointmentReminder(patient.getReceiveAppointmentReminder());
        this.setIvrLanguage(patient.getIvrLanguage());
        this.setIvrPassCode(patient.getIvrPassCode());
        this.setRegisteredOn(patient.getRegisteredOn());
        this.setStatus(patient.getStatus());
        this.setComplete(patient.getComplete());
    }

    public void mergePillTimes(String morningPillTime, String eveningPillTime) {
        setMorningPillTime(pillTimeValue(morningPillTime));
        setEveningPillTime(pillTimeValue(eveningPillTime));
    }

    private Time pillTimeValue(String pillTimeString) {
        return isNotBlank(pillTimeString) ? Time.valueOf(pillTimeString) : null;
    }
}
