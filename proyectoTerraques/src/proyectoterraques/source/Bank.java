package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    int accountTenNumbers;
    String office;
    static final String entity = "0049";
    String country;
    int digitControl;
    Scanner scNumber = new Scanner(System.in);
    Scanner scText = new Scanner(System.in);
    List<Client> clients;
    List<Account> accounts;

    public Bank(String office, String country) {
        this.office=office;
        this.country=country;
        clients= new ArrayList<>();
        accounts= new ArrayList<>();
        //TODO leer el archivo accounts.dat y clients.dat y rellenar los arrays
        loadData();
    }

   public void getClients() {

       System.out.println("---CLIENT LIST---\n");

       for (int i =0;i<clients.size();i++){

           if (clients.get(i) instanceof ShareholderClient){
               ((ShareholderClient) clients.get(i)).getFullData();
           } else if (clients.get(i) instanceof StandardClient) {
               ((StandardClient) clients.get(i)).getFullData();
           }

       }

   }

   public void getAccounts() {

           System.out.println("---ACCOUNT LIST---\n");

        for (int i =0;i<accounts.size();i++){

            if (accounts.get(i) instanceof CreditAccount){
                ((CreditAccount) accounts.get(i)).showAccountData();
            } else if (accounts.get(i) instanceof DebitAccount) {
                ((DebitAccount) accounts.get(i)).showAccountData();
            }

        }
   }

   public void newClient() throws InvalidCharacterException {

        //StandardClient cliente = new StandardClient(dni,name,surname,address,phoneNumber);
       int election;

       String dni;
       String name;
       String surname;
       String address;
       String phoneNumber;


       System.out.println("Select a client type: ");
       System.out.println("1 - Standard");
       System.out.println("2 - Shareholder");
       election = scNumber.nextInt();
       if (election==1){

           System.out.print("Dni: ");
           dni = scText.next();
           System.out.print("Name: ");
           name = scText.next();
           System.out.print("Surname: ");
           surname = scText.next();
           System.out.print("Address: ");
           address = scText.next();
           System.out.print("Phone Number: ");
           phoneNumber = scText.next();

           StandardClient client = new StandardClient(dni,name,surname,address,phoneNumber);

           clients.add(client);

           //TODO  añadir el cliente al archivo clients.dat

       } else if (election==2){
           System.out.print("Dni: ");
           dni = scText.next();
           System.out.print("Name: ");
           name = scText.next();
           System.out.print("Surname: ");
           surname = scText.next();
           System.out.print("Address: ");
           address = scText.next();
           System.out.print("Phone Number: ");
           phoneNumber = scText.next();

           ShareholderClient client = new ShareholderClient(dni,name,surname,address,phoneNumber);

           clients.add(client);

           //TODO  añadir el cliente al archivo clients.dat

       }else {
           throw new InvalidCharacterException("Invalid option, only numeric characters allowed");

       }
   }


    public void newAccount() throws InvalidCharacterException {

        int election;

        //todo leer archivo numberOfAccounts.dat y sacar las cuentas creadas , sumarle 1
        //todo y meterlo en el atributo de clase (accountNumber) y sobreescribimos el archivo con el nuevo valor
        accountTenNumbers=1234567890;
        //TODO  generamos un aleatorio entre 10 y 90 y lo metemos en el atributo digit control
        digitControl=(int)(Math.random()*80+10);
        //TODO  creamos numero de cuenta completo
        String accountNumber=country+" "+ digitControl+" "+entity+" "+office+" "+digitControl+" "+accountTenNumbers;

        System.out.println("\nCREATE ACCOUNT");
        System.out.println("1 - Debit");
        System.out.println("2 - Credit");
        System.out.print("\nSelect an account type: ");
        election = scNumber.nextInt();

        if (election==1){
            DebitAccount tempDebAcc = new DebitAccount(accountNumber);
            //todo guardamos accountNumber en el archivo numberOfAccounts.dat
            accounts.add(tempDebAcc);
            System.out.println("\nDebit account successfully created\n");



        } else if (election==2){
            CreditAccount tempCredAcc = new CreditAccount(accountNumber);
            //todo guardamos accountNumber en el archivo numberOfAccounts.dat
            accounts.add(tempCredAcc);
            System.out.println("\nCredit account successfully created\n");

        }else {
            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");
        }


    }

    public void removeClient(String dni){

        for (int i=0; i<clients.size();i++){
            if (dni.equalsIgnoreCase(clients.get(i).getDni())){
                clients.remove(i);
                System.out.println("Client successfully removed");
            }else {
                System.out.println("Client not found");
            }
        }

    }

    public void removeAccount(String accountNumber){

        for (int i=0; i<accounts.size();i++){
            if (accountNumber.equalsIgnoreCase(accounts.get(i).getAccountNumber())){
                accounts.remove(i);
                System.out.println("Account successfully removed");
            }else {
                System.out.println("Account not found");
            }
        }

    }

    public void showClient(String dni){

        for (int i=0; i<clients.size();i++){
            if (dni.equalsIgnoreCase(clients.get(i).getDni())){
                clients.get(i).getFullData();
            }else {
                System.out.println("Client not found");
            }
        }

    }

    public void showAccount(String accountNumber){

        for (int i=0; i<accounts.size();i++){
            if (accountNumber.equalsIgnoreCase(accounts.get(i).getAccountNumber())){
                System.out.println(accounts.get(i).accountNumber+" - "+accounts.get(i).getAmount()+"€");
            }else {
                System.out.println("Account not found");
            }
        }
    }

    public void loadData(){


    }

   public void depositMoney(){

        String accountNumber;
        boolean found=false;

        System.out.print("Enter Account Number: ");
        accountNumber = scText.nextLine();
        for (int i=0;i< accounts.size();i++){

            if (accountNumber.equalsIgnoreCase(accounts.get(i).accountNumber)){
                found =true;

                if (found){
                    double amount=0;
                    System.out.print("Enter quantity to deposit: ");
                    try {
                         amount = scNumber.nextDouble();
                        try {

                            if (accounts.get(i) instanceof CreditAccount){
                                ((CreditAccount) accounts.get(i)).deposit(amount);

                            } else if (accounts.get(i) instanceof DebitAccount){
                                ((DebitAccount) accounts.get(i)).deposit(amount);
                            }

                        }catch (InvalidCharacterException e){
                            System.err.println("Error: "+e);
                        }
                    }catch(Exception e){
                        System.err.println("Only numeric characters allowed");
                    }

                }
            }
        }
        if (!found){
            System.err.println("Account not found");
        }

    }

    void withDrawMoney(){


    }
}
