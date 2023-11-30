package ru.onko.security.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.onko.model.jooq.tables.pojos.AccountEntity;

@Component
public class AuthUtil {

    public AccountEntity getAccount() {
        return (AccountEntity) (SecurityContextHolder.getContext().getAuthentication()).getPrincipal();
    }
}
