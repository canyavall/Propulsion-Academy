package repository;

import domain.User;

public class InMemoryUserRepository extends AbstractCrudRepository<User, String> implements UserRepository {
}
