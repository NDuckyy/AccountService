package mss.study.accountserviceproject.repositories;

import mss.study.accountserviceproject.pojos.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmail(String email);

    Account findByAccountName(String accountName);

    List<Account> findByRoleRoleId(int roleId);

    List<Account> findByRoleRoleName(String roleName);

    List<Account> findByEmailContaining(String emailPattern);

    boolean existsByEmail(String email);

    List<Account> findByRoleRoleNameAndEmailContaining(String roleName, String email);

    List<Account> findByAccountNameContaining(String accountName);

    default List<Account> search(String emailPattern) {
        return findByEmailContaining(emailPattern);
    }
}
