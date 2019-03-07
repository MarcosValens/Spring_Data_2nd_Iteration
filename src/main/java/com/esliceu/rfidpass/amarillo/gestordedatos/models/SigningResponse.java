package com.esliceu.rfidpass.amarillo.gestordedatos.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SigningResponse {

    @JsonProperty("rfid")
    private String RFID;
    private String date;

    @JsonProperty("hour")
    private String time;
    private String weekDay;
    private String idMachine;

    @Autowired
    public SigningResponse() {
    }

    public String getRFID() {
        return RFID;
    }

    public void setRFID(String RFID) {
        this.RFID = RFID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getIdMachine() {
        return idMachine;
    }

    public void setIdMachine(String idMachine) {
        this.idMachine = idMachine;
    }

    @Override
    public String toString() {
        return "FichajeResponse{" +
                "RFID='" + RFID + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", weekDay=" + weekDay +
                ", idMachine='" + idMachine + '\'' +
                '}';
    }
}
