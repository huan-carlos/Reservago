package DAO.Class;

public class ErroDAO extends Exception{

    public ErroDAO() {
    }

    public ErroDAO(String message) {
        super("Erro DAO: "+message);
    }

    public ErroDAO(String message, Throwable cause) {
        super(message, cause);
    }

    public ErroDAO(Throwable cause) {
        super(cause);
    }

    public ErroDAO(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
