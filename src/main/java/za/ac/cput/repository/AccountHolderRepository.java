package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.AccountHolder;
@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {
}
