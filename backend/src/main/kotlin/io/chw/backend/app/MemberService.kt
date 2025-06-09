package io.chw.backend.app

import io.chw.backend.dao.MemberRepository
import io.chw.backend.domain.Member
import io.chw.backend.dto.MemberDescription
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService (
    private val repository: MemberRepository
) {
    // CRUD
    @Transactional
    fun save(desc: MemberDescription): MemberDescription {

        val member = Member(
            name = desc.name,
            email = desc.email,
            role = desc.role,
        )
        repository.save(member)
        return desc
    }


}