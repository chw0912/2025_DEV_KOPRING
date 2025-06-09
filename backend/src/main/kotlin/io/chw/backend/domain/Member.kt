package io.chw.backend.domain

import io.chw.backend.dto.Role
import io.chw.backend.global.TimeStamp
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class Member(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    var name: String,
    var email: String,

    @Enumerated(EnumType.STRING)
    var role: Role,

) : TimeStamp()

