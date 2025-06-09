package io.chw.backend.util

import io.chw.backend.domain.Member
import io.chw.backend.dto.Role

fun genMember(targetName: String, targetEmail: String): Member = Member(null, targetName, targetEmail, Role.BRONZE)