package ru.onko.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientResponseException;
import ru.onko.model.jooq.enums.AccountRole;
import ru.onko.model.jooq.tables.pojos.AccountEntity;
import ru.onko.service.AccountService;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<AccountEntity> account = accountService.findByEmail(email);
        if (account.isPresent()) {
            List<AccountRole> roles = accountService.findRolesById(account.get().getId());
            return new UserDetailsImpl(account.get(), roles);
        }
        return null;
    }
}
