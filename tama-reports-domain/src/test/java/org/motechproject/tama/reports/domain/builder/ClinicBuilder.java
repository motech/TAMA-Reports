package org.motechproject.tama.reports.domain.builder;


import org.motechproject.tama.reports.domain.Clinic;

public class ClinicBuilder {

    public static Clinic validClinic() {
        Clinic clinic = new Clinic();
        clinic.setClinicId("clinicId");
        clinic.setClinicName("clinicName");
        clinic.setCityName("cityName");
        clinic.setGreetingName("greeting");
        clinic.setAddress("address");
        clinic.setContactNumber("09898977679");
        return clinic;
    }
}
