package challenge.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import challenge.entity.URL;


@Repository
public interface URLRepository extends  CrudRepository<URL, Integer> {

	
	public URL save(URL url);
	public URL findById(int id);
	public void deleteById(int id);
	public List<URL> findAll();
	
	
}
