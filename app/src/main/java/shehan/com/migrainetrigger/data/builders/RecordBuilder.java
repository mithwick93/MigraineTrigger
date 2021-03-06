package shehan.com.migrainetrigger.data.builders;

import java.sql.Timestamp;
import java.util.ArrayList;

import shehan.com.migrainetrigger.data.model.BodyArea;
import shehan.com.migrainetrigger.data.model.LifeActivity;
import shehan.com.migrainetrigger.data.model.Location;
import shehan.com.migrainetrigger.data.model.Medicine;
import shehan.com.migrainetrigger.data.model.Record;
import shehan.com.migrainetrigger.data.model.Relief;
import shehan.com.migrainetrigger.data.model.Symptom;
import shehan.com.migrainetrigger.data.model.Trigger;
import shehan.com.migrainetrigger.data.model.WeatherData;

public class RecordBuilder {
    private ArrayList<LifeActivity> activities;
    private ArrayList<BodyArea> bodyAreas;
    private Timestamp endTime;
    private int intensity;
    private Location location;
    private int locationId;
    private ArrayList<Medicine> medicines;
    private int recordId;
    private ArrayList<Relief> reliefs;
    private Timestamp startTime;
    private ArrayList<Symptom> symptoms;
    private ArrayList<Trigger> triggers;
    private WeatherData weatherData;

    public Record createRecord() {
        return new Record(recordId, intensity, startTime, endTime, locationId, activities, bodyAreas, location, medicines, reliefs, symptoms, triggers, weatherData);
    }

    public RecordBuilder setActivities(ArrayList<LifeActivity> activities) {
        this.activities = activities;
        return this;
    }

    public RecordBuilder setBodyAreas(ArrayList<BodyArea> bodyAreas) {
        this.bodyAreas = bodyAreas;
        return this;
    }

    public RecordBuilder setEndTime(Timestamp endTime) {
        this.endTime = endTime;
        return this;
    }

    public RecordBuilder setIntensity(int intensity) {
        this.intensity = intensity;
        return this;
    }

    public RecordBuilder setLocation(Location location) {
        this.location = location;
        return this;
    }

    public RecordBuilder setLocationId(int locationId) {
        this.locationId = locationId;
        return this;
    }

    public RecordBuilder setMedicines(ArrayList<Medicine> medicines) {
        this.medicines = medicines;
        return this;
    }

    public RecordBuilder setRecordId(int recordId) {
        this.recordId = recordId;
        return this;
    }

    public RecordBuilder setReliefs(ArrayList<Relief> reliefs) {
        this.reliefs = reliefs;
        return this;
    }

    public RecordBuilder setStartTime(Timestamp startTime) {
        this.startTime = startTime;
        return this;
    }

    public RecordBuilder setSymptoms(ArrayList<Symptom> symptoms) {
        this.symptoms = symptoms;
        return this;
    }

    public RecordBuilder setTriggers(ArrayList<Trigger> triggers) {
        this.triggers = triggers;
        return this;
    }

    public RecordBuilder setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
        return this;
    }
}