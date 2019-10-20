package com.horseboarding.horseboarding.models.data;

import com.horseboarding.horseboarding.models.Horse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HorseDao extends CrudRepository<Horse, Integer> {
}
