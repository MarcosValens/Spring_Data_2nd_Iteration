package com.esliceu.rfidpass.amarillo.gestordedatos.models.notificationModels;

import org.springframework.stereotype.Component;

@Component
public class AbsenceNotify {

    private String date;
    private String time;
    private String subject;

    public AbsenceNotify(){}

    public AbsenceNotify(String date, String time, String subject) {
        this.date = date;
        this.time = time;
        this.subject = subject;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Absence{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
