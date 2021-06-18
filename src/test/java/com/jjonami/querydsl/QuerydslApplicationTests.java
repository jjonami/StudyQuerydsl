package com.jjonami.querydsl;

import com.jjonami.querydsl.entity.QSample;
import com.jjonami.querydsl.entity.Sample;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
@Commit
class QuerydslApplicationTests {

	@Autowired EntityManager em;

	@Test
	void contextLoads() {
		Sample sample = new Sample();
		em.persist(sample);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QSample qSample = QSample.sample;

		Sample result = query
				.selectFrom(qSample)
				.fetchOne();

		assertThat(result).isEqualTo(sample);
		assertThat(result.getIdx()).isEqualTo(sample.getIdx());
	}

}
