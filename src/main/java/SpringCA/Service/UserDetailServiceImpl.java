package SpringCA.Service;

import SpringCA.Repository.AdminUserRepository;
import SpringCA.Repository.LecturerUserRepository;
import SpringCA.Repository.StudentUserRepository;
import SpringCA.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
@Primary
public class UserDetailServiceImpl implements UserDetailsService {
    private AdminUserRepository adminUserRepository;
    private LecturerUserRepository lecturerUserRepository;
    private StudentUserRepository studentUserRepository;

    @Autowired
    public UserDetailServiceImpl(AdminUserRepository adminUserRepository, LecturerUserRepository lecturerUserRepository,
                                 StudentUserRepository studentUserRepository) {
        this.adminUserRepository = adminUserRepository;
        this.lecturerUserRepository = lecturerUserRepository;
        this.studentUserRepository = studentUserRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = adminUserRepository.findByUsername(username);
        if (user == null) {
            user = lecturerUserRepository.findByUsername(username);
        }

        if (user == null) {
            user = studentUserRepository.findByUsername(username);
        }
        if (user == null) throw new UsernameNotFoundException("user not found");

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));


        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                grantedAuthorities);
    }
}
