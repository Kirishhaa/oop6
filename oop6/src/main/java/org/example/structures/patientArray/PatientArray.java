package org.example.structures.patientArray;

import org.example.structures.patient.Patient;

import java.io.Serializable;

public class PatientArray implements Serializable {
    private Patient[] patients = new Patient[100];
    private int nPatients = 0;

    public int size() {
        return patients.length;
    }

    public Patient get(int index) {
        return patients[index];
    }

    public int nPatients() {
        return nPatients;
    }

    public void add(Patient patient) {
        ensureCapacity(nPatients + 1);
        patients[nPatients++] = patient;
    }

    public Patient remove(int medCardNo) {
        int index;
        for (index = 0; index < nPatients; index++) {
            if (medCardNo==patients[index].getMedCardNo()) {
                Patient temp = patients[index];
                for (int j = index; j < nPatients - 1; j++)
                    patients[j] = patients[j + 1];
                nPatients--;
                return temp;
            }
        }
        return null;
    }

    private void ensureCapacity(int newSize) {
        if (newSize == patients.length) {
            Patient[] newArray = new Patient[patients.length * 2];
            System.arraycopy(patients, 0, newArray, 0, patients.length);
            patients = newArray;
        }
    }

    public void insert(int index, Patient patient) {
        patients[index] = patient;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Patient patient : patients) {
            if (patient == null) break;
            result.append(patient);
            if(patient!=patients[nPatients-1])
                result.append("\n");
        }
        return result.toString();
    }
}
