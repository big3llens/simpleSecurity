package ru.markelov.simpleSecurity.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.markelov.simpleSecurity.entities.Role;
import ru.markelov.simpleSecurity.entities.Score;
import ru.markelov.simpleSecurity.entities.User;
import ru.markelov.simpleSecurity.repositories.UserRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    @Override

    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь: [%s] не найден", s)));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), mapRolesToAuthority(user.getRoles()));
    }

    public Collection<? extends GrantedAuthority> mapRolesToAuthority(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    public void daoIncCurrentUser(String username){
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь: [%s] не найден", username)));
        Score newScore = user.getScore();
        newScore.setPoints(user.getScore().getPoints() + 5);
        user.setScore(newScore);
        userRepository.save(user);
    }

    public void daoDecCurrentUser(String username){
        User user = findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь: [%s] не найден", username)));
        Score newScore = user.getScore();
        newScore.setPoints(user.getScore().getPoints() - 5);
        user.setScore(newScore);
        userRepository.save(user);
    }

    public User getUserById(Long id){
        User user = findById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("Пользователь c id: [%d] не найден", id)));
        return user;
    }
}
