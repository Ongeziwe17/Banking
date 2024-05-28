package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, String> {
}
