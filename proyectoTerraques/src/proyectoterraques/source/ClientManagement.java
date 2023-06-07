package proyectoterraques.source;

public interface ClientManagement {

    void addAccount(Account account);
    void removeAccount(String accountNumber) ;
    void listAccounts();

}
