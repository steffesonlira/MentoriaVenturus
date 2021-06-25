package com.example.mentoriaventurus.domain.models

data class Pokemon(
    val count: Long,
    val next: String?,
    val previous: String?,
    val results: List<Result>
)
