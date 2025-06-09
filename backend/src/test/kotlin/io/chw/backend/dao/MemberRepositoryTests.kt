package io.chw.backend.dao

import io.chw.backend.util.genMember
import io.github.oshai.kotlinlogging.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import java.time.LocalDateTime

//val logger= LoggerFactory.getLogger(MemberRepositoryTests::class.java) // java 로거
private val log = KotlinLogging.logger {}

@DataJpaTest
class MemberRepositoryTests @Autowired constructor(
    var repository: MemberRepository
) {

    @Test
    fun `repository 주입 테스트`() {

        log.info { repository }
        assertThat(repository).isNotNull

    }

    @Test
    fun `회원을 생성해서 저장하면 id와 생성날짜, 수정날짜가 자동으로 등록된다`() {

        val targetName = "member1"
        val targetEmail = "member1@email.com"

        val member = genMember(targetName, targetEmail)

        val saved = repository.save(member)

        assertThat(saved.createdAt).isNotNull
        assertThat(saved.updatedAt).isNotNull
        assertThat(saved.id).isNotNull

        val now = LocalDateTime.now()

        assertThat(saved.createdAt).isBefore(now)
        assertThat(saved.updatedAt).isBefore(now)

        log.info { saved.id }
        log.info { saved.createdAt }
        log.info { saved.updatedAt }


    }


}

