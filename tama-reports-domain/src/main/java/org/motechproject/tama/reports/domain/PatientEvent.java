package org.motechproject.tama.reports.domain;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

@Data
@Table(name = "patient_event")
@Entity
public class PatientEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotBlank
    @Column(name = "patient_document_id")
    private String patientDocumentId;

    @NotBlank
    @Column(name = "event_name")
    private String eventName;

    @Column(name = "new_value")
    private String newValue;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "performed_by")
    private String performedBy;


    public boolean isValid() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<PatientEvent>> violations = validator.validate(this);
        return violations.isEmpty();
    }

    public void merge(PatientEvent patient) {
        this.setPatientDocumentId(patient.getPatientDocumentId());
        this.setNewValue(patient.getNewValue());
        this.setEventName(patient.getEventName());
        this.setDateTime(patient.getDateTime());
        this.setPerformedBy(patient.getPerformedBy());
    }
}
