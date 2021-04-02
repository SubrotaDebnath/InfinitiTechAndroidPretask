package uk.infiniti.tech.infinititechandroidpretask.view.login;

public interface LoginCommunicator {

    public interface LoginView{
        public void loginSuccess(String message);
        public void loginFailure(String message);
    }

    public interface LoginPresenter{
        public void handelLogin(String mobileNo, String password);
    }
}
