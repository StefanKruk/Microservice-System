package de.stefankruk.microservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@Component
@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Long> {
}
