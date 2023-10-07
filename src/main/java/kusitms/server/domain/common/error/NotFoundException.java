package kusitms.server.domain.common.error;

public class NotFoundException extends ApplicationException{

    public NotFoundException(ApplicationError error) {
        super(error);
    }
}
