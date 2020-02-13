package hh.palvelinohjelmointi.carcrudproject.domain;

import org.springframework.data.repository.CrudRepository;

// tietokantakäsittelyn rajapinta
public interface CarRepository extends CrudRepository<Car, Long> {
	//crud repo rajapinnan parametrisoinnissa annetaa entity luokan nimi 
	// eli tässä car ja toisena param pääavainsarakkeen luokkatietotyyppi eli tässä long
	
	//carrepository peritytyy (extends) crudrepo ja perii mm metodiesittelyt
	// findAll findById deleteById jne
	
	public Car findByModel(String model);
	

}
