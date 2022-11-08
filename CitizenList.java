import java.util.*;
import java.io.*;
import java.util.LinkedList;
import javax.swing.*;

import static java.lang.System.in;

public class CitizenList extends Citizen {

    public static void main(String[] args){

        try{
            //create reader
            BufferedReader br = new BufferedReader(new FileReader("C://Users//space//IdeaProjects//Finale//src//Citizens"));

            //create object citizenList
            LinkedList<Citizen> citizenList = new LinkedList<>();
            //create object completedList
            LinkedList<Citizen> completedList = new LinkedList<>();

            //create object List1
            LinkedList<Citizen> List1 = new LinkedList<>();
            //create object List2
            LinkedList<Citizen> List2 = new LinkedList<>();
            //create object List3
            LinkedList<Citizen> List3 = new LinkedList<>();

            //create object firstDoseCompq1
            LinkedList<Citizen> firstDoseCompq1 = new LinkedList<>();
            //create object firstDoseCompq2
            LinkedList<Citizen> firstDoseCompq2 = new LinkedList<>();
            //create object firstDoseCompq3
            LinkedList<Citizen> firstDoseCompq3 = new LinkedList<>();

            //create stack object
            Stack<Citizen> stCenter1 = new Stack<>();
            Stack<Citizen> stCenter2 = new Stack<>();
            Stack<Citizen> stCenter3 = new Stack<>();

            //create queues
            Queue <Citizen> qCenter1 = new LinkedList();
            Queue <Citizen> qCenter2 = new LinkedList();
            Queue <Citizen> qCenter3 = new LinkedList();


            Citizen citizen;
            String indata = null;

            //read data from file and store into citizenList
            while ((indata = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(indata, ";");
                String name = st.nextToken();
                String IC = st.nextToken();
                String state = st.nextToken();
                int age = Integer.parseInt(st.nextToken());
                String category = st.nextToken();
                String firstdose  = st.nextToken();
                String secdose = st.nextToken();
                String vaccine_completion = st.nextToken();

                citizen = new Citizen(name,IC,state,age,category,firstdose,secdose,vaccine_completion); //create object
                // store into citizenList
                citizenList.add(citizen);
            }
            in.close();

            //welcome page
            JOptionPane.showMessageDialog(null,"Stay Safe and Get Your Vaccine Now.","WELCOME!", JOptionPane.INFORMATION_MESSAGE);


            int rmenu = 0;
            do {
                //instruction
                rmenu = Integer.parseInt(JOptionPane.showInputDialog("Please choose the following menu  "+
                        "\n Menu 1 - Add new citizen data" +
                        "\n Menu 2 - Remove citizen data " +
                        "\n Menu 3 - ST CENTRES " +
                        "\n Menu 4 - Exit "));

                if (rmenu==1) //add new citizen data
                {
                    String name = JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS NAME");
                    String IC = JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS IC");
                    while(IC.length()!=12) //error message if user put the wrong ic format
                    {
                        JOptionPane.showMessageDialog(null, "PLEASE PUT THE CORRECT IC!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        IC = JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS IC AGAIN (12 DIGITS)");
                    }
                    String state = JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS STATE");
                    int age = Integer.parseInt(JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS AGE"));
                    while(age<18) //error message if user put the wrong age
                    {
                        JOptionPane.showMessageDialog(null, "PLEASE PUT THE CORRECT AGE! THIS AGE IS ILLEGIBLE FOR THE VACCINE!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        age = Integer.parseInt(JOptionPane.showInputDialog("PLEASE ENTER THE CORRECT AGE AGAIN (Above 18)"));
                    }
                    String category = JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS CATEGORY (HIGH RISK/LOW RISK)");
                    while(!category.equalsIgnoreCase("LOW RISK") && (!category.equalsIgnoreCase("HIGH RISK"))) //error message if u
                    {
                        JOptionPane.showMessageDialog(null, "PLEASE PUT THE CORRECT CATEGORY!", "ERROR", JOptionPane.ERROR_MESSAGE);
                        category = JOptionPane.showInputDialog("PLEASE ENTER RECIPIENTS CATEGORY AGAIN (LOW RISK/HIGH RISK)");
                    }
                    String firstdose = "NULL";
                    String seconddose = "NULL";
                    String vaccinecertificate = "NULL";

                    citizen = new Citizen(name, IC, state, age, category,  firstdose , seconddose, vaccinecertificate);

                    citizenList.addFirst(citizen);
                }
                else if(rmenu==2) //remove citizen data
                {
                    String ic = JOptionPane.showInputDialog("Enter the IC's number that you want to remove");
                    for (int i = 0; i < citizenList.size(); i++) {
                        citizen = citizenList.get(i);//retrieve object
                        if (citizen.getIC().equalsIgnoreCase(ic)) {
                            citizenList.remove(citizen); //remove object
                        }
                        else{
                            System.out.println("Data not found! ");
                        }
                    }
                }
                else if (rmenu==3) // update first dose status
                {

                    //put into stack
                    while (!citizenList.isEmpty()) {

                        citizen = citizenList.removeLast();
                        if (citizen.getAge() >= 18 && citizen.getAge() <= 30) {
                            stCenter1.push(citizen);
                        } else if (citizen.getAge() >= 31 && citizen.getAge() <= 49) {
                            stCenter2.push(citizen);
                        } else if (citizen.getAge() >= 50) {
                            stCenter3.push(citizen);
                        }
                    }

                    int menu = 0;
                    do {

                        //instructions
                        menu = Integer.parseInt(JOptionPane.showInputDialog("Please choose the following menu  " +
                                "\n Menu 1 - ST CENTRE 1" +
                                "\n Menu 2 - ST CENTRE 2 " +
                                "\n Menu 3 - ST CENTRE 3 " +
                                "\n Menu 4 - Display 1st Dose List"+
                                "\n Menu 5 - Display Completed Dose List"+
                                "\n Menu 6 - Back"));


                        if (menu == 1) {

                            int submenu = 0;
                            do {

                                submenu = Integer.parseInt(JOptionPane.showInputDialog("Menu 1 - Demonstrate 1st Vaccination Process and display it " +
                                        "\n Menu 2 - Demonstrate 2nd Vaccination Process and display it " +
                                        "\n Menu 3 - Back"));
                                if (submenu == 1) {

                                    while (!stCenter1.isEmpty()) //put into stCenter1 stack
                                    {
                                        citizen = stCenter1.pop();
                                        if (citizen.getvaccinedose1().equalsIgnoreCase("null")) {
                                            citizen.setvaccinedose1("COMPLETED");
                                            qCenter1.add(citizen);
                                            firstDoseCompq1.add(citizen); //add into firstDoseCompq1
                                        }
                                    }
                                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tST CENTRE 1\n");
                                    System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                                    System.out.println(firstDoseCompq1);
                                } else if (submenu == 2) {
                                    while (!qCenter1.isEmpty()) {
                                        citizen = qCenter1.remove(); //retrieve and remove element
                                        if (citizen.getvaccinedose2().equalsIgnoreCase("NULL")) {
                                            citizen.setvaccinedose2("COMPLETED");
                                            if (citizen.getvaccinecertification().equalsIgnoreCase("NULL")) {
                                                citizen.setvaccinecertification("FULLY VACCINATED");
                                            }
                                            List1.add(citizen); //add into List1
                                            completedList.add(citizen); //add into comletedList
                                        }
                                    }
                                    System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tST CENTRE 1\n");
                                    System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                                    System.out.println(List1);
                                }


                            } while (submenu != 3); //exit submenu
                        }
                        else if (menu == 2)
                        {

                            int submenu = 0;
                            do {

                                submenu = Integer.parseInt(JOptionPane.showInputDialog("Menu 1 - Demonstrate 1st Vaccination Process and display it " +
                                        "\n Menu 2 - Demonstrate 2nd Vaccination Process and display it " +
                                        "\n Menu 3 - Back"));
                                if (submenu == 1) {
                                    while (!stCenter2.isEmpty()) {
                                        citizen = stCenter2.pop();
                                        if (citizen.getvaccinedose1().equalsIgnoreCase("NULL")) {
                                            citizen.setvaccinedose1("COMPLETED");
                                            qCenter2.add(citizen);
                                            firstDoseCompq2.add(citizen); //add into fistDoseCompq2
                                        }
                                    }
                                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tST CENTRE 2\n");
                                    System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                                    System.out.println(firstDoseCompq2);

                                } else if (submenu == 2) {
                                    while (!qCenter2.isEmpty()) {
                                        citizen = qCenter2.remove(); //retrieve and remove element
                                        if (citizen.getvaccinedose2().equalsIgnoreCase("NULL")) {
                                            citizen.setvaccinedose2("COMPLETED");
                                            if (citizen.getvaccinecertification().equalsIgnoreCase("NULL")) {
                                                citizen.setvaccinecertification("FULLY VACCINATED");
                                            }
                                            List2.add(citizen); //add into List2
                                            completedList.add(citizen); //add data into comletedList
                                        }
                                    }
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tST CENTRE 2\n");
                                    System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                                    System.out.println(List2);
                                }


                            } while (submenu != 3);


                        } else if (menu == 3) {
                            int submenu = 0;
                            do {
                                submenu = Integer.parseInt(JOptionPane.showInputDialog("Menu 1 - Demonstrate 1st Vaccination Process and display it " +
                                        "\n Menu 2 - Demonstrate 2nd Vaccination Process and display it " +
                                        "\n Menu 3 - Back"));
                                if (submenu == 1) {
                                    while (!stCenter3.isEmpty()) {
                                        citizen = stCenter3.pop();
                                        if (citizen.getvaccinedose1().equalsIgnoreCase("NULL")) {
                                            citizen.setvaccinedose1("COMPLETED");
                                            qCenter3.add(citizen);
                                            firstDoseCompq3.add(citizen); //add into firstDoseCompq3
                                        }
                                    }
                                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tST CENTRE 3\n");
                                    System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                                    System.out.println(firstDoseCompq3);
                                } else if (submenu == 2) {
                                    while (!qCenter3.isEmpty()) {
                                        citizen = qCenter3.remove(); //retrieve and remove element
                                        if (citizen.getvaccinedose2().equalsIgnoreCase("NULL")) {
                                            citizen.setvaccinedose2("COMPLETED");
                                            if (citizen.getvaccinecertification().equalsIgnoreCase("NULL")) {
                                                citizen.setvaccinecertification("FULLY VACCINATED");
                                            }
                                            List3.add(citizen); //add into List3
                                            completedList.add(citizen); //add into completedList
                                        }

                                    }
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tST CENTRE 3\n");
                                    System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                                    System.out.println(List3);
                                }
                            }
                            while (submenu != 3);
                        }
                        else if (menu==4) //to display first dose list
                        {
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1st DOSE RECIPIENTS LIST \n");
                            System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                            System.out.println(firstDoseCompq1);
                            System.out.println(firstDoseCompq2);
                            System.out.println(firstDoseCompq3);
                        }
                        else if (menu == 5) //display completed dose list
                        {
                            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCOMPLETED LIST\n");
                            System.out.println(String.format(" \t  | %15s | %12s | %20s | %5s | %10s | %15s | %15s | %15s | %n", "NAME", "IC", "STATE", "AGE", "CATEGORY", "DOSE STATUS 1", "DOSE STATUS 2", "VACCINATION CERTIFICATE"));
                            System.out.println(completedList);
                        }



                    } while (menu != 6); //to exit
                }
            }
            while (rmenu!=4); //to exit
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}