package org.example.actionObjects.objectPrinter;

import org.example.structures.patient.Patient;
import org.example.structures.diagnosArray.DiagnosArray;
import org.example.structures.patientArray.PatientArray;

public class ObjectPrinter {
    public void print(Patient patient){
        if(patient!=null) System.out.println(patient.toText());
    }
    public void print(PatientArray patientArray){
        for(int i=0;i<patientArray.size();i++){
            print(patientArray.get(i));
        }
    }
    public void print(DiagnosArray diagnosArray){
        System.out.print(diagnosArray);
    }
}
