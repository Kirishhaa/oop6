package org.example.io;

import org.example.structures.patient.Patient;
import org.example.structures.patientArray.PatientArray;

import java.io.*;

public class IO {

    public static String DEFAULT_FILE = "defaultFile.txt";
    public static String BINARY_FILE = "binaryFile.dat";

    public void saveToDefaultFile(PatientArray patientArray, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(patientArray);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
    }

    public PatientArray readFromDefaultFile(String fileName) {
        PatientArray patientArray = new PatientArray();
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line=bf.readLine())!=null){
                patientArray.add(Patient.parsePatient(line));
            }
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
        return patientArray;
    }

    public PatientArray readFromBinaryFile(String fileName) {
        PatientArray patientArray = new PatientArray();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            patientArray = (PatientArray) ois.readObject();
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND EXCEPTION");
        }
        return patientArray;
    }

    public void saveToBinaryFile(PatientArray patientArray, String fileName) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(patientArray);
        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
    }
}
