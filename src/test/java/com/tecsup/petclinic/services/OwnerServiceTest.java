package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.repositories.OwnerRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@Slf4j
public class OwnerServiceTest {

	@InjectMocks
	private OwnerServicesImpl ownerService;

	@Mock
	private OwnerRepository ownerRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testSave() {
		Owner owner = new Owner();
		owner.setId(1);
		owner.setNombres("Jaime");
		owner.setAddress("123 Main St");
		owner.setTelephone("555-1234");
		owner.setEmail("jaime@example.com");

		when(ownerRepository.save(owner)).thenReturn(owner);

		log.info("Executing testSave...");
		try {
			Owner savedOwner = ownerService.save(owner);
			log.info("Saved owner: {}", savedOwner);

			assertEquals("Jaime", savedOwner.getNombres());
			assertEquals("123 Main St", savedOwner.getAddress());
			assertEquals("555-1234", savedOwner.getTelephone());
			assertEquals("jaime@example.com", savedOwner.getEmail());

			verify(ownerRepository).save(owner);
			log.info("testSave completed successfully.");
		} catch (Exception e) {
			log.error("Error in testSave: {}", e.getMessage(), e);
			throw e;
		}
	}

	@Test
	public void testDeleteById() {
		Integer id = 1;

		log.info("Executing testDeleteById for ID: {}", id);
		try {
			ownerService.deleteById(id);
			verify(ownerRepository).deleteById(id);
			log.info("testDeleteById completed successfully.");
		} catch (Exception e) {
			log.error("Error in testDeleteById: {}", e.getMessage(), e);
			throw e;
		}
	}
}
