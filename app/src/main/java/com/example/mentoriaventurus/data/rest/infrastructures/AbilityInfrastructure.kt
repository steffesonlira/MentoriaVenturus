/*
 * Copyright 2020 by Samsung Eletrônica da Amazônia Ltda. All rights reserved.
 *
 * This software and its code is the confidential ("Confidential Information")
 * and proprietary information of Samsung Eletrônica da Amzônia Ltda.
 * You shall not disclose such Confidential Information and shall use it only in accordance
 * with the terms of the license agreement you entered into with Samsung Eletrônica da Amazônia Ltda.
 */

package com.example.mentoriaventurus.data.rest.infrastructures

import com.example.mentoriaventurus.data.rest.api.AbilityApi
import com.example.mentoriaventurus.data.rest.mappers.AbilityMapper
import com.example.mentoriaventurus.domain.models.Ability
import com.example.mentoriaventurus.domain.services.AbilityService
import javax.inject.Inject

class AbilityInfrastructure @Inject constructor(
    private val service: AbilityApi,
    private val mapper: AbilityMapper
) : AbilityService {

    override suspend fun fetchAbilities(): Ability {
        val abilities = service.fetchAbilities()

        return mapper.fromResponse(abilities)
    }
}