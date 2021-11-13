package com.ds.watchtable;

import com.ds.watchtable.entity.Pos;
import com.ds.watchtable.repository.PosRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class WatchtableApplicationTests {

	@Autowired
	PosRepository posRepository;

	@Test
	public void  SelectPos() {
		Long posNum = 1L;
		Optional<Pos> result = posRepository.findById(posNum);
		System.out.println("=============================");
		if (result.isPresent()) {
			Pos memo = result.get();
			System.out.println(memo);
		}
	}

}
