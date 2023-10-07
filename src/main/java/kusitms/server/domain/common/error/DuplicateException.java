package kusitms.server.domain.common.error;

public class DuplicateException extends ApplicationException{

    public DuplicateException(ApplicationError error) {
        super(error);
    }
}
