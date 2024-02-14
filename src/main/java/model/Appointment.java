package model;

import DAO.AppointmentsQuery;
import helper.Alerts;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Model for Appointment.
 *
 * @author Wilson Ramirez
 */
public class Appointment {
    private int apptID;
    private String apptTitle;
    private String apptDescription;
    private String apptLocation;
    private final String apptType;
    private int apptTypeTotal;
    private LocalDateTime apptStart;
    private LocalDateTime apptEnd;
    private int customerID;
    private int userID;
    private int contactID;

    /**
     * Constructor for Appointment in database.
     * @param apptID Appointment ID.
     * @param apptTitle Appointment title.
     * @param apptDescription Appointment description.
     * @param apptLocation Appointment location.
     * @param apptType Appointment type.
     * @param apptStart Appointment start date/time.
     * @param apptEnd Appointment end date/time.
     * @param customerID Associated customer ID.
     * @param userID Associated user ID.
     * @param contactID Associated contact ID.
     */
    public Appointment(int apptID, String apptTitle, String apptDescription, String apptLocation, String apptType, LocalDateTime apptStart, LocalDateTime apptEnd, int customerID, int userID, int contactID) {
        this.apptID = apptID;
        this.apptTitle = apptTitle;
        this.apptDescription = apptDescription;
        this.apptLocation = apptLocation;
        this.apptType = apptType;
        this.apptStart = apptStart;
        this.apptEnd = apptEnd;
        this.customerID = customerID;
        this.userID = userID;
        this.contactID = contactID;
    }

    /**
     *
     * @param apptType Appointment type
     * @param apptTypeTotal Total appointments by type
     */
    public Appointment(String apptType, int apptTypeTotal) {
        this.apptType = apptType;
        this.apptTypeTotal = apptTypeTotal;
    }

    /**
     *
     * @return appointment ID.
     */
    public int getApptID() {
        return apptID;
    }



    /**
     *
     * @return appointment title.
     */
    public String getApptTitle() {
        return apptTitle;
    }

    /**
     *
     * @return appointment description.
     */
    public String getApptDescription() {
        return apptDescription;
    }

    /**
     *
     * @return appointment location.
     */
    public String getApptLocation() {
        return apptLocation;
    }

    /**
     *
     * @return appointment type.
     */
    public String getApptType() {
        return apptType;
    }

    /**
     *
     * @return total appointments by type.
     */
    public int getApptTypeTotal() {
        return apptTypeTotal;
    }

    /**
     * Set appointment totals by type.
     *
     * @param apptTypeTotal Number of appointments by type.
     */
    public void setApptTypeTotal(int apptTypeTotal) {
        this.apptTypeTotal = apptTypeTotal;
    }

    /**
     *
     * @return appointment start date/time
     */
    public LocalDateTime getApptStart() {
        return apptStart;
    }

    /**
     *
     * @return appointment end date/time
     */
    public LocalDateTime getApptEnd() {
        return apptEnd;
    }

    /**
     *
     * @return associated customer ID.
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @return associated user ID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *
     * @return associated contact ID.
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * Get local start time for business.
     * @return business local start time.
     */
    public static LocalTime localStart() {
        LocalTime openingBusinessTime = LocalTime.of(8,0);
        ZoneId easternTime = ZoneId.of("America/New_York");
        ZoneId localTime = ZoneId.systemDefault();

        LocalDateTime businessEasternTime = LocalDateTime.of(LocalDate.now(), openingBusinessTime);
        LocalDateTime businessLocalTime = businessEasternTime.atZone(easternTime).withZoneSameInstant(localTime).toLocalDateTime();

        return businessLocalTime.toLocalTime();

    }

    /**
     * Get local end time for business.
     * @return business local end time.
     */
    public static LocalTime localEnd() {
        LocalTime closingBusinessTime = LocalTime.of(22,0);
        ZoneId easternTime = ZoneId.of("America/New_York");
        ZoneId localTime = ZoneId.systemDefault();

        LocalDateTime businessEasternTime = LocalDateTime.of(LocalDate.now(), closingBusinessTime);
        LocalDateTime businessLocalTime = businessEasternTime.atZone(easternTime).withZoneSameInstant(localTime).toLocalDateTime();

        return businessLocalTime.toLocalTime();

    }

    /**
     * Check to see if appointment time is within business hours.
     *
     * @param appointmentStart Appointment start time.
     * @param appointmentEnd Appointment end time.
     * @return true or false if appointment time is within business hours or not.
     */
    public static boolean businessHours(LocalDateTime appointmentStart, LocalDateTime appointmentEnd) {
        ZoneId localZone = ZoneId.systemDefault();
        ZoneId estZone = ZoneId.of("America/New_York");

        LocalDateTime appStartEST = appointmentStart.atZone(localZone).withZoneSameInstant(estZone).toLocalDateTime();
        LocalDateTime appEndEST = appointmentEnd.atZone(localZone).withZoneSameInstant(estZone).toLocalDateTime();

        LocalDateTime businessStartEST = appStartEST.withHour(8).withMinute(0);
        LocalDateTime businessEndEST = appEndEST.withHour(22).withMinute(0);

        return appStartEST.isBefore(businessStartEST) || appEndEST.isAfter(businessEndEST);
    }

    /**
     * Check if appointment time overlaps with other appointments for this customer.
     *
     * @param customerID Selected customer
     * @param apptStart Appointment start time for customer.
     * @param apptEnd Appointment end time for customer.
     * @return true or false if appointment overlaps or not.
     */
    public static boolean checkApptOverlap(int customerID, LocalDateTime apptStart, LocalDateTime apptEnd) {
        ObservableList<Appointment> allAppointments = AppointmentsQuery.getAllAppointments();
        LocalDateTime apptStartCheck;
        LocalDateTime apptEndCheck;

        for (Appointment appointment : allAppointments) {
            apptStartCheck = appointment.getApptStart();
            apptEndCheck = appointment.getApptEnd();
            if (customerID != appointment.getCustomerID()) {
                continue;
            } else if (apptStartCheck.isEqual(apptStart) || apptEndCheck.isEqual(apptEnd)) {
                Alerts.getWarning(1);
                return true;
            } else if (apptStart.isAfter(apptStartCheck) && apptStart.isBefore(apptEndCheck)) {
                Alerts.getWarning(2);
                return true;
            } else if (apptEnd.isAfter(apptStartCheck) && apptEnd.isBefore(apptEndCheck)) {
                Alerts.getWarning(3);
                return true;
            }
        }
        return false;
    }
}
