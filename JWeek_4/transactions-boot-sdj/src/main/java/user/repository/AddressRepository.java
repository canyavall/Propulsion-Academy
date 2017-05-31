package user.repository;

import org.springframework.data.repository.CrudRepository;

import user.domain.Address;

interface AddressRepository extends CrudRepository<Address, Long> {
	
}
