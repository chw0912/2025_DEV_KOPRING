package io.chw.backend.util

import io.chw.backend.domain.Member
import io.chw.backend.dto.MemberDescription
import io.chw.backend.dto.Role

fun genMember(targetName: String, targetEmail: String, targetRole: Role = Role.BRONZE): Member = Member(null, targetName, targetEmail, targetRole)

fun genMemberDesc(
    actualName: String,
    actualEmail: String,
    actualRole: Role
): MemberDescription = MemberDescription(actualName, actualEmail, actualRole)