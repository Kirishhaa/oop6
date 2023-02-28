package org.example.main;

import org.example.actionObjects.arrayOperations.ArrayOperations;
import org.example.io.IO;
import org.example.actionObjects.objectPrinter.ObjectPrinter;
import org.example.structures.patientArray.PatientArray;
import org.example.userInterface.UserInterface;

import java.util.Scanner;

public class Main {
    PatientArray patientArray;
    IO io;
    UserInterface userInterface;
    ArrayOperations arrayOperations;
    ObjectPrinter objectPrinter;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        patientArray = new PatientArray();
        io = new IO();
        userInterface = new UserInterface(scanner);
        arrayOperations = new ArrayOperations();
        objectPrinter = new ObjectPrinter();
        int ui;
        while ((ui = userInterface.menu()) != 0) {
            switch (ui) {
                case 1 -> patientArray.add(userInterface.inputPatient());
                case 2 -> patientArray.remove(userInterface.inputRemoveMedCardNo());
                case 3 -> io.saveToDefaultFile(patientArray, IO.DEFAULT_FILE);
                case 4 -> io.saveToBinaryFile(patientArray, IO.BINARY_FILE);
                case 5 -> patientArray = io.readFromDefaultFile(IO.DEFAULT_FILE);
                case 6 -> patientArray = io.readFromBinaryFile(IO.BINARY_FILE);
                case 7 -> {
                    PatientArray filter = arrayOperations.filter(
                            patientArray, userInterface.inputDiagnos());
                    arrayOperations.sortByMedNo(filter);
                    objectPrinter.print(filter);
                }
                case 8 -> objectPrinter.print(
                        arrayOperations.filter(patientArray, userInterface.inputRange()));
                case 9 -> objectPrinter.print(
                        arrayOperations.filter(
                                patientArray, userInterface.inputFirstNumberOfThePhone())
                );
                case 10 -> objectPrinter.print(arrayOperations.filter(patientArray));
            }
        }
    }
}