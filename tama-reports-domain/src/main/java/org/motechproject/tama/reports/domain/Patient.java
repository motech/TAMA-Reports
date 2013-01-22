package org.motechproject.tama.reports.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Data
public class Patient {

    @NotBlank
    private String patientId;
    @NotNull
    private Date dateOfBirth;
    @NotBlank
    private String gender;
    @NotBlank
    private String clinicId;
    @NotBlank
    private String travelTimeToClinic;
    @NotBlank
    private String ivrPassCode;
    @NotBlank
    private String ivrLanguage;
    @NotBlank
    private String callPreference;
    @NotNull
    private Date bestCallTime;
    @NotNull
    private Boolean receiveOTCAdvice;
    @NotNull
    private Boolean receiveAppointmentReminder;

    public boolean isValid() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Patient>> violations = validator.validate(this);
        return violations.isEmpty();
    }
}
