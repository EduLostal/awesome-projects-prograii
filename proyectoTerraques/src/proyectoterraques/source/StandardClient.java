package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

import java.util.Scanner;

public class StandardClient extends Client implements ClientManagement{

    Scanner scNumber = new Scanner(System.in);
    Scanner scText = new Scanner(System.in);

    DebitAccount debit_Account;

    public StandardClient(String dni, String name, String surname, String address, String phoneNumber) {
        super(dni, name, surname, address, phoneNumber);
    }

    @Override
    public String getDni() {
        return super.getDni();
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public String getFullData() {
        return super.getFullData();
    }

    @Override
    public boolean addAccount(Account account)   {
        //TODO MIRAR SI ESTA BIEN
        if (account instanceof DebitAccount) {
            if (debit_Account==null){
                debit_Account=((DebitAccount) account);
                System.out.println("Debit account vinculated to client\n");
                return false;
            }else {
                System.out.println("You can't vinculate another debit account to the client\n");
                //todo borrar cuenta del array de cuentas en Bank
                //todo retornar un booleano a la clase Bank y si es false borrarla
                return true;
            }
        } else if (account instanceof CreditAccount) {
            //todo borrar cuenta del array de cuentas en Bank
            System.out.println("You can't vinculate a credit account to a standard client\n");
            return true;
        }
        return false;
    }


    @Override
    public void removeAccount(String accountNumber){
        //Todo

        boolean found=false;

        if (debit_Account.accountNumber.equalsIgnoreCase(accountNumber)){
            debit_Account=null;
            found=true;
        }

        if (found){
            System.out.println("Debit Account successfully removed\n");
        } else {
            System.out.println("Account not found to remove\n");
        }

    }

    @Override
    public void listAccounts() {

        System.out.println(getFullName()+" Debit Account: ");

        if (debit_Account!=null){
            debit_Account.showAccountData();
        } else {
            System.out.println("None\n");
        }
    }
}

