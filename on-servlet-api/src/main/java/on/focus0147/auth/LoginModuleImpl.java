package on.focus0147.auth;


import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * На основе BASIC авторизации будет сессия сущестоввать до тех пор,
 * пока браузер не закроется, например
 */
public class LoginModuleImpl implements LoginModule {

    //При помощи CallbackHandler мы сможем запросить различную информацию о субъекте аутентификации
    private CallbackHandler handler;
    //субъект аутентификации.пределённый человек является Subject.
    private Subject subject;
    //Principal является представлением Subject.Водительское удостоверение человека
    private UserPrincipal userPrincipal;
    private RolePrincipal rolePrincipal;
    private String login;
    private List<String> userGroups;

    @Override
    public void initialize(Subject subject,
                           CallbackHandler callbackHandler,
                           Map<String, ?> sharedState,
                           Map<String, ?> options) {

        handler = callbackHandler;
        this.subject = subject;
    }

    @Override
    public boolean login() throws LoginException {
    // Это является первой фазой аутентификации
        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("login");
        callbacks[1] = new PasswordCallback("password", true);

        try {
            handler.handle(callbacks);
            String name = ((NameCallback) callbacks[0]).getName();
            String password = String.valueOf(((PasswordCallback) callbacks[1])
                    .getPassword());

            if (name != null && name.equals("1")//хардкодим
                    && password != null && password.equals("1")) {
                login = name;
                userGroups = new ArrayList<>();
                userGroups.add("1");
                return true;
            }
            throw new LoginException("Authentication failed");

        } catch (IOException|UnsupportedCallbackException e) {
            throw new LoginException(e.getMessage());
        }
    }

    @Override
    public boolean commit() throws LoginException {
        //Это является 2 фазой аутентификации:
        userPrincipal = new UserPrincipal(login);
        subject.getPrincipals().add(userPrincipal);

        if (userGroups != null && !userGroups.isEmpty()) {
            for (String groupName : userGroups) {
                rolePrincipal = new RolePrincipal(groupName);
                subject.getPrincipals().add(rolePrincipal);
            }
        }
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        //Метод abort вызывается тогда, когда завершилась неудачей первая фаза аутентификации.
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        subject.getPrincipals().remove(userPrincipal);
        subject.getPrincipals().remove(rolePrincipal);
        return true;
    }

}
