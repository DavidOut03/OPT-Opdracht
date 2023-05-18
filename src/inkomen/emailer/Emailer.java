package inkomen.emailer;

public abstract class Emailer implements ESender {

    protected abstract String getEmailTo();
    protected abstract String getMessage();

}
