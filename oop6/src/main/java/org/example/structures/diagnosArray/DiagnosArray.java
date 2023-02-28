package org.example.structures.diagnosArray;

import org.example.structures.patientArray.PatientArray;

public class DiagnosArray {
    private int[] amountsArray;
    private String[] diagnosArray;
    private int nItems;

    public DiagnosArray(int size) {
        amountsArray = new int[size];
        diagnosArray = new String[size];
    }

    public static DiagnosArray parseDiagnosArray(PatientArray patients) {
        DiagnosArray array = new DiagnosArray(patients.size());
        for (int i = 0; i < patients.nPatients(); i++) {
            array.add(patients.get(i).getDiagnos());
        }
        array.sort();
        return array;
    }

    public void sort() {
        for (int out = 1; out < nItems; out++) {
            String tempString = diagnosArray[out];
            int tempInt = amountsArray[out];
            int in = out;
            while (in > 0 && amountsArray[in - 1] < tempInt) {
                diagnosArray[in] = diagnosArray[in - 1];
                amountsArray[in] = amountsArray[in - 1];
                --in;
            }
            amountsArray[in] = tempInt;
            diagnosArray[in] = tempString;
        }
    }

    public void add(String diagnos) {
        ensureCapacity(nItems + 1);
        for (int i = 0; i < diagnosArray.length; i++) {
            if (diagnosArray[i] == null) {
                insert(i, diagnos);
                break;
            }
            if (diagnosArray[i].equals(diagnos)) {
                amountsArray[i]++;
                break;
            }
        }
    }

    private void insert(int index, String diagnos) {
        diagnosArray[index] = diagnos;
        amountsArray[index] = 1;
        nItems++;
    }

    private void ensureCapacity(int newSize) {
        if (newSize > amountsArray.length) {
            int[] newAmountsArray = new int[amountsArray.length * 2];
            String[] newDiagnosArray = new String[diagnosArray.length * 2];
            for (int i = 0; i < amountsArray.length; i++) {
                newDiagnosArray[i] = diagnosArray[i];
                newAmountsArray[i] = amountsArray[i];
            }
            amountsArray = newAmountsArray;
            diagnosArray = newDiagnosArray;
        }
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<amountsArray.length;i++){
            if(diagnosArray[i]==null) break;
            builder
                    .append("diagnos = ")
                    .append(diagnosArray[i])
                    .append(" amount = ")
                    .append(amountsArray[i])
                    .append("\n");
        }
        return builder.toString();
    }
}
