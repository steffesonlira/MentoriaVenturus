package com.example.mentoriaventurus.rest.responses

data class AbilityResponse(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<ResultResponse>
)
